package Utils;

import DTOs.TransactionDTO;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mapper {
    private static final Pattern FIELD_PATTERN = Pattern.compile("\\s*(\\w+)\\s*:\\s*([^|]+)");

    public static TransactionDTO parsePayload(String payload) {
        Map<String, String> fields = new HashMap<>();
        Matcher matcher = FIELD_PATTERN.matcher(payload);
        while (matcher.find()) {
            String key = matcher.group(1).trim().toUpperCase(); // Normaliza chave
            String value = matcher.group(2).trim(); // Trim no valor
            fields.put(key, value);
        }

        // Extrai valores obrigatórios
        String user = fields.get("USER");
        String id = fields.get("ID");
        String value = fields.get("VAL");
        String coin = fields.get("COIN");
        String hash = fields.get("HASH");

        // Validação básica de presença
        if (user == null || id == null || value == null || coin == null || hash == null) {
            throw new IllegalArgumentException("Payload incompleto: campos obrigatórios ausentes");
        }

        return new TransactionDTO(user, id, value, coin, hash);
    }
}

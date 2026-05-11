package Utils;

import DTOs.TransactionDTO;
import DTOs.ValidationResult;

import java.util.List;
import java.util.regex.Pattern;

public class Validacao {
    private static final Pattern USER_PATTERN = Pattern.compile("^\\d+$");
    private static final Pattern HASH_PATTERN = Pattern.compile("^[a-zA-Z0-9]+$");

    public static ValidationResult isValidTransation(TransactionDTO transactionDTO) {
        List<String> errors = new java.util.ArrayList<>();
        if (!USER_PATTERN.matcher(transactionDTO.user()).matches()) {
            errors.add("Usuário invalido");
        }
        if (!HASH_PATTERN.matcher(transactionDTO.hash()).matches()) {
            errors.add("Hash invalida");
        }
        return new ValidationResult(errors.isEmpty(), errors);
    }
}

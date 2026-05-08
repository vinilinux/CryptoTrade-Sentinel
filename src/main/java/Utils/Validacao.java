package Utils;

import DTOs.TransactionDTO;

import java.util.ArrayList;

public class Validacao {
    public static String isValidTransation(TransactionDTO transactionDTO) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(validaUser(transactionDTO.user()));
        stringBuilder.append(validaHash(transactionDTO.hash()));
        return stringBuilder.toString();
    }

    private static String validaHash(String hash) {
        boolean isNoValid = hash.codePoints().noneMatch(cp ->
                Character.isISOControl(cp) ||
                        Character.getType(cp) == Character.MATH_SYMBOL ||
                        Character.isEmoji(cp)

        );
        return isNoValid ? "Hash invalido": "";
    }

    private static String validaUser(String user) {
        boolean isNoValid = user.codePoints().anyMatch(cp ->
                            Character.isISOControl(cp) ||
                            Character.isAlphabetic(cp) ||
                            Character.getType(cp) == Character.MATH_SYMBOL ||
                                    Character.isEmoji(cp)
        );
        return isNoValid ? "Usuário invalido" : "";
    }

}

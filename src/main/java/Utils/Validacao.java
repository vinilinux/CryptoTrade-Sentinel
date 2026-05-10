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
        return hash.codePoints().allMatch(Character::isLetterOrDigit) ? "": "Hash invalido";
    }

    private static String validaUser(String user) {
        return user.codePoints().allMatch(Character::isDigit) ? "" : "Usuário invalido";
    }

}

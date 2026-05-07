package Utils;

import DTOs.TransactionDTO;

import java.util.ArrayList;

public class Validacao {
    public static String isValidTransation(TransactionDTO transactionDTO) {
        ArrayList<String> errorMsg = new ArrayList<>();
        errorMsg.add(validaUser(transactionDTO.user()));
        errorMsg.add(validaId(transactionDTO.id()));
        errorMsg.add(validaHas(transactionDTO.hash()));
        errorMsg.add(validaCoin(transactionDTO.coin()));
        errorMsg.add(validaValue(transactionDTO.value()));

        return errorMsg.toString();
    }

    private static String validaValue(String value) {
        return null;
    }

    private static String validaCoin(String coin) {

        return null;
    }

    private static String validaHas(String hash) {
        return null;
    }

    private static String validaId(String id) {
        return null;
    }

    private static String validaUser(String user) {
        return null;
    }

}

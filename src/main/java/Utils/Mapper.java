package Utils;

import DTOs.TransactionDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mapper {
    public static TransactionDTO parsePayload(String payload){
        ArrayList<String> transation = new ArrayList<>();
        String[] split = payload.split("\\|");
        for (String string : split) {
            String[] user = string.trim().split(":");
            transation.add(user[1]);
        }
        return new TransactionDTO(transation.get(0), transation.get(1), transation.get(2), transation.get(3), transation.get(4));
    }
}

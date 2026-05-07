package Utils;

import DTOs.TransactionDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mapper {
    /*
    Melhoria
    Verificar a vantagem de utilizar hashMap ou melhorar a regex para extrair somente o dado bruto ou utilizar stringbuilder
     */
    public static TransactionDTO parsePayload(String payload){
        ArrayList<String> transation = new ArrayList<>();
        String[] split = payload.replaceAll("\\s", "").split("\\|");
        for (String string : split) {
            String[] user = string.split(":");
            transation.add(user[1]);
        }
        return new TransactionDTO(transation.get(0), transation.get(1), transation.get(2), transation.get(3), transation.get(4));
    }
}

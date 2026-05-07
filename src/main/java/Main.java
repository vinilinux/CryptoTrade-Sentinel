import DTOs.TransactionDTO;
import Utils.Mapper;
import Utils.Validacao;

public class Main {

    public static void main(String[] args) {
        String payload = "USER:  12345|  ID  :acc_br_99|VAL:1500,75|COIN:BTC|HASH:  7a8b9c";
        TransactionDTO transactionDTO = Mapper.parsePayload(payload);

        String erroMsg = Validacao.isValidTransation(transactionDTO);

        if (erroMsg.isBlank()) {

        } else {
            System.out.println(erroMsg);
        }

    }
}

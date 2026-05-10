import DTOs.TransactionDTO;
import Utils.Mapper;
import Utils.Validacao;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {

    public static void main(String[] args) {
        String payload = "USER:  123|  ID  :acc_br_99|VAL:1500,75|COIN:BTC|HASH:  7a8b9c";
        double limite = 10000;
        TransactionDTO transactionDTO = Mapper.parsePayload(payload);

        String erroMsg = Validacao.isValidTransation(transactionDTO);

        BigDecimal valorTotal = new ProcessamentoFinanceiro().processar(transactionDTO.value());

        if (!erroMsg.isEmpty()) {
            System.out.println(erroMsg);
            return;
        }

        if (valorTotal.compareTo(BigDecimal.valueOf(limite)) > 0) {
            System.out.println("Limite atingido");
        } else {
            System.out.println(valorTotal.setScale(2, RoundingMode.HALF_UP));
        }
    }
}

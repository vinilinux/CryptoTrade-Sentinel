import DTOs.TransactionDTO;
import DTOs.ValidationResult;
import Utils.Mapper;
import Utils.Validacao;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {

    public static void main(String[] args) {
        String payload = "USER:  123|ID  :acc_br_99|VAL:1500.75|COIN:BTC|HASH:  7a8b9c";
        double limite = 10000;
        try {
            TransactionDTO transactionDTO = Mapper.parsePayload(payload);

            ValidationResult validationResult = Validacao.isValidTransation(transactionDTO);

            if (validationResult.isValid()) {
                BigDecimal valorTotal = new ProcessamentoFinanceiro().processar(transactionDTO.value());

                if (valorTotal.compareTo(BigDecimal.valueOf(limite)) > 0) {
                    System.out.println("Limite atingido");
                } else {
                    System.out.println(valorTotal.setScale(2, RoundingMode.HALF_UP));
                }
            } else {
                validationResult.errorMessage().forEach(System.out::println);
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao processar payload: " + e.getMessage());
        }

    }
}

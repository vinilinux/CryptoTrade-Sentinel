import DTOs.TransactionDTO;
import DTOs.ValidationResult;
import Utils.Mapper;
import Utils.Validacao;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class Main {

    private static final double LIMITE_TRANSACAO = 10000.0;
    private static final String PAYLOAD_EXEMPLO = "USER:  123|  ID  :acc_br_99|VAL:15000,75|COIN:BTC|HASH:  7a8b9c";

    public static void main(String[] args) {
        executarProcessamento(PAYLOAD_EXEMPLO, LIMITE_TRANSACAO);
    }

    private static void executarProcessamento(String payload, double limite) {
        try {
            TransactionDTO transacao = parsePayload(payload);
            ValidationResult erroValidacao = validarTransacao(transacao);

            if (!erroValidacao.isValid()) {
                imprimirErro(erroValidacao.errorMessage());
                return;
            }

            BigDecimal valorTotal = processarValor(transacao);
            verificarELimitar(valorTotal, limite);
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }

    private static void imprimirErro(List<String> strings) {
        strings.forEach(System.out::println);
    }

    private static TransactionDTO parsePayload(String payload) {
        return Mapper.parsePayload(payload);
    }

    private static ValidationResult validarTransacao(TransactionDTO transacao) {
        return Validacao.isValidTransation(transacao);
    }

    private static BigDecimal processarValor(TransactionDTO transacao) {
        return new ProcessamentoFinanceiro().processar(transacao.value());
    }

    private static void verificarELimitar(BigDecimal valorTotal, double limite) {
        if (valorTotal.compareTo(BigDecimal.valueOf(limite)) > 0) {
            System.out.println("Limite atingido");
        } else {
            System.out.println(formatarValor(valorTotal));
        }
    }

    private static String formatarValor(BigDecimal valor) {
        return valor.setScale(2, RoundingMode.HALF_UP).toString();
    }
}

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class ProcessamentoFinanceiro {
    public BigDecimal processar(String coin) {
        try {
            BigDecimal valorConvertido = converterStringParaBigdecimal(coin);
            BigDecimal taxaCorregatem = new BigDecimal("1.02");
            return valorConvertido.multiply(taxaCorregatem);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private BigDecimal converterStringParaBigdecimal(String coin) throws ParseException {
        Locale brasil = new Locale("pt", "BR");
        DecimalFormat nf = (DecimalFormat) NumberFormat.getInstance(brasil);
        nf.setParseBigDecimal(true);
        return (BigDecimal) nf.parse(coin);
    }
}

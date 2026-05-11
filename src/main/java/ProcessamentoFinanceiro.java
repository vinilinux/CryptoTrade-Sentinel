import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class ProcessamentoFinanceiro {
    private static final BigDecimal TAXA = new BigDecimal("1.02");

    private static final ThreadLocal<DecimalFormat> THREAD_FORMAT = ThreadLocal.withInitial(() -> {
        DecimalFormat df = (DecimalFormat) NumberFormat.getInstance(new Locale("pt", "BR"));
        df.setParseBigDecimal(true);
        return df;
    });

    public BigDecimal processar(String value) {
        try {
            BigDecimal valor = (BigDecimal) THREAD_FORMAT.get().parse(value);
            return valor.multiply(TAXA).setScale(2, RoundingMode.HALF_UP);
        } catch (ParseException e) {
            throw new RuntimeException("Erro ao processar valor: " + value, e);
        }
    }
}

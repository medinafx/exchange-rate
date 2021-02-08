package ni.gob.inss.exchangerate.scraper;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;

public interface TipoCambioScraperService {
    public TipoCambioMensual getTipoCambioMensual(YearMonth anioMes);

    public BigDecimal getTipoCambio(LocalDate date);
}

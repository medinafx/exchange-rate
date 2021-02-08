package ni.gob.inss.exchangerate.scraper;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;

public class TipoCambioScraperServiceImpl implements TipoCambioScraperService {
    @Override
    public TipoCambioMensual getTipoCambioMensual(YearMonth anioMes) {
        TipoCambioBCNScraper tipoCambioBCNScraper = new TipoCambioBCNScraper();
        return tipoCambioBCNScraper.getTipoCambioMensualOficial(anioMes);
    }

    @Override
    public BigDecimal getTipoCambio(LocalDate date) {
        return getTipoCambioMensual(YearMonth.from(date)).getTipoDeCambio(date);
    }
}

package ni.gob.inss.exchangerate;

import ni.gob.inss.exchangerate.scraper.TipoCambioScraperService;
import ni.gob.inss.exchangerate.soap.TipoCambioSoapService;

import java.time.LocalDate;

public class TipoCambioScraperAdapter implements TipoCambioSoapService
{
    private final TipoCambioScraperService tipoCambioScraperService;

    public TipoCambioScraperAdapter(TipoCambioScraperService tipoCambioScraperService)
    {
        this.tipoCambioScraperService = tipoCambioScraperService;
    }

    @Override
    public double getTipoDeCambioOficial(int anio, int mes, int dia)
    {
        return this.tipoCambioScraperService.getTipoCambio(LocalDate.of(anio, mes, dia)).doubleValue();
    }
}

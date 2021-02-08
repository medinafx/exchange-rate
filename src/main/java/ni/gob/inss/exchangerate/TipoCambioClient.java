package ni.gob.inss.exchangerate;


import ni.gob.inss.exchangerate.soap.TipoCambioSoapService;
import ni.gob.inss.exchangerate.soap.TipoCambioSoapServiceImpl;


public final class TipoCambioClient
{
    public static double getTasaDeCambioOficial(int anio, int mes, int dia)
    {
        TipoCambioSoapService service = new TipoCambioSoapServiceImpl();
        //TipoCambioSoapService service = new TipoCambioScraperAdapter(new TipoCambioScraperServiceImpl());

        return service.getTipoDeCambioOficial(anio, mes, dia);
    }
}

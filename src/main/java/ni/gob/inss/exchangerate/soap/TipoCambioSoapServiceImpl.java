package ni.gob.inss.exchangerate.soap;

public class TipoCambioSoapServiceImpl implements TipoCambioSoapService {
    @Override
    public double getTipoDeCambioOficial(int anio, int mes, int dia) {
        TipoCambioBCN service = new TipoCambioBCN();
        TipoCambioBCNSoap port = service.getTipoCambioBCNSoap();

        return port.recuperaTCDia(anio, mes, dia);
    }
}

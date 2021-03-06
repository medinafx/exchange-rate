package ni.gob.inss.exchangerate.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 */
@WebService(name = "Tipo_Cambio_BCNSoap", targetNamespace = "http://servicios.bcn.gob.ni/")
@XmlSeeAlso({
        ObjectFactory.class
})
public interface TipoCambioBCNSoap {


    /**
     * Recupera el tipo de cambio del día solicitado.
     * Parametros: (Año, Mes, Día)
     *
     * @param ano
     * @param mes
     * @param dia
     * @return returns double
     */
    @WebMethod(operationName = "RecuperaTC_Dia", action = "http://servicios.bcn.gob.ni/RecuperaTC_Dia")
    @WebResult(name = "RecuperaTC_DiaResult", targetNamespace = "http://servicios.bcn.gob.ni/")
    @RequestWrapper(localName = "RecuperaTC_Dia", targetNamespace = "http://servicios.bcn.gob.ni/", className = "RecuperaTCDia")
    @ResponseWrapper(localName = "RecuperaTC_DiaResponse", targetNamespace = "http://servicios.bcn.gob.ni/", className = "RecuperaTCDiaResponse")
    public double recuperaTCDia(
            @WebParam(name = "Ano", targetNamespace = "http://servicios.bcn.gob.ni/")
                    int ano,
            @WebParam(name = "Mes", targetNamespace = "http://servicios.bcn.gob.ni/")
                    int mes,
            @WebParam(name = "Dia", targetNamespace = "http://servicios.bcn.gob.ni/")
                    int dia);

    /**
     * Recupera el detalle completo de la base de tipos de cambio para el mes solicitado.
     * Parametros: (Año, Mes)
     *
     * @param ano
     * @param mes
     * @return returns RecuperaTCMesResponse.RecuperaTCMesResult
     */
    @WebMethod(operationName = "RecuperaTC_Mes", action = "http://servicios.bcn.gob.ni/RecuperaTC_Mes")
    @WebResult(name = "RecuperaTC_MesResult", targetNamespace = "http://servicios.bcn.gob.ni/")
    @RequestWrapper(localName = "RecuperaTC_Mes", targetNamespace = "http://servicios.bcn.gob.ni/", className = "RecuperaTCMes")
    @ResponseWrapper(localName = "RecuperaTC_MesResponse", targetNamespace = "http://servicios.bcn.gob.ni/", className = "RecuperaTCMesResponse")
    public RecuperaTCMesResponse.RecuperaTCMesResult recuperaTCMes(
            @WebParam(name = "Ano", targetNamespace = "http://servicios.bcn.gob.ni/")
                    int ano,
            @WebParam(name = "Mes", targetNamespace = "http://servicios.bcn.gob.ni/")
                    int mes);

}

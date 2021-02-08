package ni.gob.inss.exchangerate.soap;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Ano" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="Mes" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="Dia" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "ano",
        "mes",
        "dia"
})
@XmlRootElement(name = "RecuperaTC_Dia")
public class RecuperaTCDia {

    @XmlElement(name = "Ano")
    protected int ano;
    @XmlElement(name = "Mes")
    protected int mes;
    @XmlElement(name = "Dia")
    protected int dia;

    /**
     * Gets the value of the ano property.
     */
    public int getAno() {
        return ano;
    }

    /**
     * Sets the value of the ano property.
     */
    public void setAno(int value) {
        this.ano = value;
    }

    /**
     * Gets the value of the mes property.
     */
    public int getMes() {
        return mes;
    }

    /**
     * Sets the value of the mes property.
     */
    public void setMes(int value) {
        this.mes = value;
    }

    /**
     * Gets the value of the dia property.
     */
    public int getDia() {
        return dia;
    }

    /**
     * Sets the value of the dia property.
     */
    public void setDia(int value) {
        this.dia = value;
    }

}

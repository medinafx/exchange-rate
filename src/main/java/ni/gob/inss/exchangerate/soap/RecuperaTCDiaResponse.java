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
 *         &lt;element name="RecuperaTC_DiaResult" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "recuperaTCDiaResult"
})
@XmlRootElement(name = "RecuperaTC_DiaResponse")
public class RecuperaTCDiaResponse {

    @XmlElement(name = "RecuperaTC_DiaResult")
    protected double recuperaTCDiaResult;

    /**
     * Gets the value of the recuperaTCDiaResult property.
     */
    public double getRecuperaTCDiaResult() {
        return recuperaTCDiaResult;
    }

    /**
     * Sets the value of the recuperaTCDiaResult property.
     */
    public void setRecuperaTCDiaResult(double value) {
        this.recuperaTCDiaResult = value;
    }

}

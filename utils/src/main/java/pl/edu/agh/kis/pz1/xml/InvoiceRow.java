package pl.edu.agh.kis.pz1.xml;

import lombok.Getter;
import lombok.Setter;
import org.bouncycastle.asn1.BEROctetStringGenerator;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Class representing "<tns:InvoiceRow>""
 */
@Getter
@Setter
@XmlRootElement(name="tns:InvoiceRow")
@XmlAccessorType(XmlAccessType.FIELD)
public class InvoiceRow {
    @XmlElement(name="P_2B")
    private String id;
    @XmlElement(name="P_7")
    private String nameOfService;
    @XmlElement(name="P_8A")
    private String standard;
    @XmlElement(name="P_8B")
    private BigDecimal quantity;
    @XmlElement(name="P_9A")
    private BigDecimal netto;
    @XmlElement(name="P_9B")
    private BigDecimal brutto;
    @XmlElement(name="P_11")
    private BigDecimal sum;
    @XmlElement(name="P_12")
    private String tax;

    public InvoiceRow(String id, String quantity, BigDecimal netto, BigDecimal sum, String tax) {
        this.id = id;
        this.nameOfService = "Sprzedaż usług krajowych";
        this.standard = "szt";
        this.quantity = new BigDecimal(quantity).setScale(5, RoundingMode.HALF_EVEN);
        this.netto = netto;
        this.brutto = (netto.multiply(new BigDecimal("1").add(new BigDecimal(tax).divide(new BigDecimal("100"))))).setScale(2, RoundingMode.HALF_EVEN);
        this.sum = sum;
        this.tax = tax;
    }

    public InvoiceRow() {}
}

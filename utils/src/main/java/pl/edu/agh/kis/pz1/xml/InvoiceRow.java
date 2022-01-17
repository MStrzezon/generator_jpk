package pl.edu.agh.kis.pz1.xml;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@XmlRootElement(name="tns:JPK")
@XmlAccessorType(XmlAccessType.FIELD)
public class InvoiceRow {
    @XmlElement(name="P_2B")
    private String id;
    @XmlElement(name="P_7")
    private String nameOfService;
    @XmlElement(name="P_8A")
    private String standard;
    @XmlElement(name="P_8B")
    private String quantity;
    @XmlElement(name="P_9A")
    private String netto;
    @XmlElement(name="P_9B")
    private String brutto;
    @XmlElement(name="P_11")
    private String sum;
    @XmlElement(name="P_12")
    private String tax;

    public InvoiceRow(String id, String quantity, String netto, String sum, String tax) {
        this.id = id;
        this.nameOfService = "Sprzedaż usług krajowych";
        this.standard = "szt";
        this.quantity = quantity;
        this.netto = netto;
        this.brutto = (Double.parseDouble(netto)*(1+Double.parseDouble(tax)/100))+"";
        this.sum = sum;
        this.tax = tax;
    }

    public InvoiceRow() {}
}

package pl.edu.agh.kis.pz1.xml;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

/**
 * Class representing "<tns:InvoiceCtrl>""
 */
@Getter
@Setter
@XmlRootElement(name="tns:InvoiceCtrl")
@XmlAccessorType(XmlAccessType.FIELD)
public class InvoiceCtrl {
    @XmlElement(name="LiczbaFaktur")
    private int numberOfInvoices;
    @XmlElement(name="WartoscFaktur")
    private BigDecimal valueOfInvoices;

    InvoiceCtrl () {
        numberOfInvoices = 0;
        valueOfInvoices = new BigDecimal(0);
    }

    public void addInvoice() {
        numberOfInvoices++;
    }

    public void increaseValueOfInvoices(BigDecimal value) {
        valueOfInvoices = valueOfInvoices.add(value);
    }
}

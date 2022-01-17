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
public class InvoiceRowCtrl {
    @XmlElement(name="LiczbaWierszyFaktur")
    private int numberOfInvoices;
    @XmlElement(name="WartoscWierszyFaktur")
    private double valueOfInvoices;

    public void addInvoice() {
        numberOfInvoices++;
    }

    public void increaseValueOfInvoices(double value) {
        valueOfInvoices += value;
    }
}

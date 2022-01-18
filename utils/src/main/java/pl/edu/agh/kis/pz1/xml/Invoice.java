package pl.edu.agh.kis.pz1.xml;

import lombok.*;

import javax.xml.bind.annotation.*;

/**
 * Class representing "<tns:Faktura>""
 */
@Getter
@Setter
@AllArgsConstructor
@XmlRootElement(name="tns:Faktura")
@XmlAccessorType(XmlAccessType.FIELD)
public class Invoice {
    @XmlElement(name="tns:KodWaluty")
    private String currency;
    @XmlElement(name="tns:P_1")
    private String date;
    @XmlElement(name="tns:P_2A")
    private String id;
    @XmlElement(name="tns:P_3A")
    private String companyName;
    @XmlElement(name="tns:P_3B")
    private String companyAddress;
    @XmlElement(name="tns:P_3C")
    private String name;
    @XmlElement(name="tns:P_3D")
    private String address;
    @XmlElement(name="tns:P_4A")
    private String taxpayerCountry;
    @XmlElement(name="tns:P_4B")
    private String taxpayerId;
    @XmlElement(name="tns:P_5B")
    private String buyerId;
    @XmlElement(name="tns:P_6")
    private String deliveryEnd;
    @XmlElement(name="tns:P_13_1")
    private double nettoValue;
    @XmlElement(name="tns:P_14_1")
    private double nettoTax;
    @XmlElement(name="tns:P_15")
    private double sum;
    @XmlElement(name="tns:P_16")
    private boolean p16;
    @XmlElement(name="tns:P_17")
    private boolean p17;
    @XmlElement(name="tns:P_18")
    private boolean p18;
    @XmlElement(name="tns:P_18A")
    private boolean p18A;
    @XmlElement(name="tns:P_19")
    private boolean p19;
    @XmlElement(name="tns:P_20")
    private boolean p20;
    @XmlElement(name="tns:P_21")
    private boolean p21;
    @XmlElement(name="tns:P_22")
    private boolean p22;
    @XmlElement(name="tns:P_23")
    private boolean p23;
    @XmlElement(name="tns:P_106E_2")
    private boolean p106E2;
    @XmlElement(name="tns:P_106E_3")
    private boolean p106E3;
    @XmlElement(name="tns:RodzajFaktury")
    private String invoiceType;

    Invoice() {}

    public void increaseNettoValue(double value) {
        this.nettoValue += value;
    }

    public void increaseNettoTax(double value) {
        this.nettoTax += value;
    }

    public void increaseSum(double value) {
        this.sum += value;
    }
}

package pl.edu.agh.kis.pz1.xml;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@XmlRootElement(name="tns:JPK")
@XmlAccessorType(XmlAccessType.FIELD)
public class JPK {
    @XmlAttribute(name="xmlns:tns")
    private String xmlnsTns = "http://jpk.mf.gov.pl/wzor/2019/09/27/09271/";
    @XmlAttribute(name="xmlns:xsi")
    private String xmlnsXsi = "http://www.w3.org/2001/XMLSchema-instance";
    @XmlAttribute(name="xmlns:etd")
    private String xmlnsEtd = "http://crd.gov.pl/xml/schematy/dziedzinowe/mf/2018/08/24/eD/DefinicjeTypy/";
    @XmlAttribute(name="xmlns:kck")
    private String xmlnsKck = "http://crd.gov.pl/xml/schematy/dziedzinowe/mf/2013/05/23/eD/KodyCECHKRAJOW/";
    @XmlAttribute(name="xmlns:xsd")
    private String xmlnsXsd = "http://www.w3.org/2001/XMLSchema";
    @XmlAttribute(name="xmlns:xsl")
    private String xmlnsMsxsl = "urn:schemas-microsoft-com:xslt";
    @XmlAttribute(name="xmlns:usr")
    private String xmlnsUsr = "urn:the-xml-files:xslt";
    @XmlAttribute(name="xsi:schemaLocation")
    private String xsi = "http://jpk.mf.gov.pl/wzor/2019/09/27/09271/ https://www.gov.pl/attachment/1abeab45-4e71-4616-b8d5-6b71699e86f8";

    @XmlElement(name="tns:Naglowek")
    private Header header = new Header();
    @XmlElement(name="tns:Podmiot1")
    private Person person = new Person();
    @XmlElement(name="tns:Faktura")
    private List<Invoice> invoices = new ArrayList<>();
    @XmlElement(name="tns:FakturaCtrl")
    private InvoiceCtrl invoiceCtrl = new InvoiceCtrl();
    @XmlElement(name="tns:FakturaWiersz")
    private List<InvoiceRow> invoiceRows = new ArrayList<>();
    @XmlElement(name="tns:FakturaWierszCtrl")
    private InvoiceRowCtrl invoiceRowCtrl = new InvoiceRowCtrl();

    public boolean containsName(final String foreignId){
        return invoices.stream().anyMatch(o -> o.getId().equals(foreignId));
    }

    public Invoice getInvoiceId(final String foreignId) {
        return invoices.stream().filter(invoice -> foreignId.equals(invoice.getId()))
                .findAny()
                .orElse(null);
    }
    public void addInvoice(Invoice invoice) {
        invoiceCtrl.increaseValueOfInvoices(invoice.getSum());
        if (containsName(invoice.getId())) {
            getInvoiceId(invoice.getId()).increaseNettoValue(invoice.getNettoValue());
            getInvoiceId(invoice.getId()).increaseNettoTax(invoice.getNettoTax());
            getInvoiceId(invoice.getId()).increaseSum(invoice.getSum());
        } else {
            getInvoices().add(invoice);
            invoiceCtrl.addInvoice();
        }
    }

    public void addInvoiceRow(InvoiceRow invoiceRow) {
        invoiceRows.add(invoiceRow);
        invoiceRowCtrl.addInvoice();
        invoiceRowCtrl.increaseValueOfInvoices(Double.parseDouble(invoiceRow.getSum()));
    }
}

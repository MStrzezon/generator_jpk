package pl.edu.agh.kis.pz1.xml;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@XmlRootElement(name="tns:Nagłówek")
@XmlAccessorType(XmlAccessType.FIELD)
public class Header {
    @XmlElement(name="tns:KodFormularza")
    private final FormCode formCode = new FormCode();
    @XmlElement(name="tns:WariantFormularza")
    private final String formVariant = "3";
    @XmlElement(name="tns:CelZlozenia")
    private final String goal = "1";
    @XmlElement(name="tns:DataWytworzeniaJPK")
    private final String createDate = java.time.LocalDateTime.now().toString();
    @XmlElement(name="tns:DataOd")
    private final String dateFrom = "2020-10-01";
    @XmlElement(name="tns:DataDo")
    private final String dateTo = "2020-12-31";
    @XmlElement(name="tns:KodUrzedu")
    private final String departmentId = "1208";
}

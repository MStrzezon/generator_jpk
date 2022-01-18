package pl.edu.agh.kis.pz1.xml;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;


/**
 * Class representing "<tns:KodFormularza>""
 */
@Getter
@Setter
@XmlRootElement(name="tns:KodFormularza")
@XmlAccessorType(XmlAccessType.FIELD)
public class FormCode {
    @XmlAttribute(name="kodSystemowy")
    private final String systemCode = "JPK_FA (3)";
    @XmlAttribute(name="wersjaSchemy")
    private final String schemaVersion = "1-0";
    @XmlValue
    private final String l = "JPK_FA";
}

package pl.edu.agh.kis.pz1.xml;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class representing "<tns:IdentyfikatorPodmiotu>""
 */
@Getter
@Setter
@XmlRootElement(name="tns:IdentyfikatorPodmiotu")
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonId {
    @XmlElement(name="etd:NIP")
    private final String nip = "6762484560";
    @XmlElement(name="etd:PelnaNazwa")
    private final String companyName = "\"CORE LOGIC\" SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ";
}

package pl.edu.agh.kis.pz1.xml;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class representing "<tns:Podmiot1>""
 */
@Getter
@Setter
@XmlRootElement(name="tns:Podmiot1")
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {
    @XmlElement(name="tns:IdentyfikatorPodmiotu")
    private final PersonId personId = new PersonId();
    @XmlElement(name="AdresPodmiotu")
    private final PersonAddress personAddress = new PersonAddress();
}

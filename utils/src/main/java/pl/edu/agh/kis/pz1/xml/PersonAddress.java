package pl.edu.agh.kis.pz1.xml;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@XmlRootElement(name="tns:KodFormularza")
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonAddress {
    @XmlElement(name="etd:KodKraju")
    private final String countryId = "PL";
    @XmlElement(name="etd:Wojewodztwo")
    private final String province = "m. Kraków";
    @XmlElement(name="etd:Gmina")
    private final String commune = "Kraków";
    @XmlElement(name="etd:Ulica")
    private final String street = "ul. Feliksa Radwańskiego";
    @XmlElement(name="etd:NrDomu")
    private final String houseId = "15";
    @XmlElement(name="etd:NrLokalu")
    private final String venueId = "1";
    @XmlElement(name="etd:Miejscowosc")
    private final String city = "Kraków";
    @XmlElement(name="etd:KodPocztowy")
    private final String postCode = "30-065";
}

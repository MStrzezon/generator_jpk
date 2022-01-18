package pl.edu.agh.kis.pz1.write;

import pl.edu.agh.kis.pz1.xml.JPK;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

/**
 * Static class containing method for writing JAXB object into .xml file:
 */
public class Write {
    /**
     * Prevents the object from being created.
     */
    private Write() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Creates .xml file from JAXB class - JPK.
     * @param jpk class containing information from .csv or .xlsx file.
     * @param filename name of the file to be created.
     * @throws JAXBException if creating fails.
     */
    public static void marshal(JPK jpk, String filename) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(JPK.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(jpk, new File(filename));
    }
}

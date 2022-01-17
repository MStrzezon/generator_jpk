package pl.edu.agh.kis.pz1.write;

import pl.edu.agh.kis.pz1.xml.JPK;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class Write {
    private Write() {
        throw new IllegalStateException("Utility class");
    }

    public static void marshal(JPK invoices, String filename) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(JPK.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(invoices, new File(filename));
    }
}

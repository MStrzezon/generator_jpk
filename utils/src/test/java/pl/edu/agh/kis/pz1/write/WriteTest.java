package pl.edu.agh.kis.pz1.write;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pl.edu.agh.kis.pz1.xml.InvoiceCtrl;
import pl.edu.agh.kis.pz1.xml.JPK;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;

import java.io.ByteArrayOutputStream;
import java.io.File;

import static org.junit.Assert.*;

public class WriteTest {
    private final String _xmlHeader = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";

    @Test
    public void marshal() throws JAXBException {
        JPK jpk = new JPK();
        Write.marshal(jpk, "write_test.xml");
        File f = new File("C:\\Users\\mstrz\\IdeaProjects\\Projekty\\generator\\utils\\write_test.xml");
        assertTrue(f.exists());
        assertTrue(f.delete());
    }
}
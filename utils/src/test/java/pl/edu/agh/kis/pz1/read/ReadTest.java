package pl.edu.agh.kis.pz1.read;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pl.edu.agh.kis.pz1.xml.Invoice;
import pl.edu.agh.kis.pz1.xml.JPK;

import java.io.IOException;

import static org.junit.Assert.*;

public class ReadTest {

    @Test
    public void readXLSX() throws IOException {
        JPK jpk = new JPK();
        jpk = Read.readXLSX("C:\\Users\\mstrz\\IdeaProjects\\Projekty\\generator\\files\\test.xlsx");
        assertEquals(4, jpk.getInvoices().size());
        assertEquals(7, jpk.getInvoiceRows().size());
        assertTrue(jpk.containsName("3-14/10/2020"));
        assertFalse(jpk.containsName("test"));
        assertEquals(4, jpk.getInvoiceCtrl().getNumberOfInvoices());
        assertEquals(7, jpk.getInvoiceRowCtrl().getNumberOfInvoices());
        assertEquals("Firma1 Sp. z o.o", jpk.getInvoices().get(3).getCompanyName());
    }

    @Test
    public void readCSV() throws IOException {
        JPK jpk = new JPK();
        jpk = Read.readCSV("C:\\Users\\mstrz\\IdeaProjects\\Projekty\\generator\\files\\test.csv");
        assertEquals(4, jpk.getInvoices().size());
        assertEquals(7, jpk.getInvoiceRows().size());
        assertTrue(jpk.containsName("3-14/10/2020"));
        assertFalse(jpk.containsName("test"));
        assertEquals(4, jpk.getInvoiceCtrl().getNumberOfInvoices());
        assertEquals(7, jpk.getInvoiceRowCtrl().getNumberOfInvoices());
        assertEquals("Firma1 Sp. z o.o", jpk.getInvoices().get(3).getCompanyName());
    }
}
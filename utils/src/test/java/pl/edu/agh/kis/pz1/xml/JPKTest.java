package pl.edu.agh.kis.pz1.xml;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.*;

public class JPKTest {
    JPK jpk;

    @Before
    public void setUp() throws Exception {
        jpk = new JPK();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void containsName() {
        assertFalse(jpk.containsName("12"));
        try (Reader in = new InputStreamReader(new FileInputStream("C:\\Users\\mstrz\\IdeaProjects\\Projekty\\generator\\files\\test.csv"), StandardCharsets.UTF_8)) {
            Iterable<CSVRecord> records = CSVParser.parse(in, CSVFormat.Builder.create(CSVFormat.TDF).setHeader().setSkipHeaderRecord(true).build());
            for (CSVRecord myRecord : records) {
                if (myRecord.getRecordNumber() < 5) {
                    assertFalse(jpk.containsName(myRecord.get(5)));
                } else {
                    assertTrue(jpk.containsName(myRecord.get(5)));
                }
                jpk.addInvoice(new Invoice("PLN", myRecord.get(4), myRecord.get(5), myRecord.get(0),
                        myRecord.get(1), "\"CORE LOGIC\" SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ", "ul. Feliksa Radwańskiego 15/1, 30-065 Kraków", "PL", "6762484560",
                        myRecord.get(2), myRecord.get(4), new BigDecimal("11.0"), new BigDecimal("11.0"), new BigDecimal("11.0"),
                        false, false, false, false, false, false, false, false, false, false, false, "VAT"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addInvoice() {
        int i = 0;
        try (Reader in = new InputStreamReader(new FileInputStream("C:\\Users\\mstrz\\IdeaProjects\\Projekty\\generator\\files\\test.csv"), StandardCharsets.UTF_8)) {
            Iterable<CSVRecord> records = CSVParser.parse(in, CSVFormat.Builder.create(CSVFormat.TDF).setHeader().setSkipHeaderRecord(true).build());
            for (CSVRecord myRecord : records) {
                if (myRecord.getRecordNumber() < 5) {
                    assertEquals(i, jpk.getInvoices().size());
                    i++;
                } else {
                    assertEquals(i, jpk.getInvoices().size());
                }
                jpk.addInvoice(new Invoice("PLN", myRecord.get(4), myRecord.get(5), myRecord.get(0),
                        myRecord.get(1), "\"CORE LOGIC\" SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ", "ul. Feliksa Radwańskiego 15/1, 30-065 Kraków", "PL", "6762484560",
                        myRecord.get(2), myRecord.get(4), new BigDecimal("11.0"), new BigDecimal("11.0"), new BigDecimal("11.0"),
                        false, false, false, false, false, false, false, false, false, false, false, "VAT"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addInvoiceRow() {
        int i = 0;
        try (Reader in = new InputStreamReader(new FileInputStream("C:\\Users\\mstrz\\IdeaProjects\\Projekty\\generator\\files\\test.csv"), StandardCharsets.UTF_8)) {
            Iterable<CSVRecord> records = CSVParser.parse(in, CSVFormat.Builder.create(CSVFormat.TDF).setHeader().setSkipHeaderRecord(true).build());
            for (CSVRecord myRecord : records) {
                assertEquals(i, jpk.getInvoiceRows().size());
                i++;
                jpk.addInvoiceRow(new InvoiceRow(myRecord.get(5), myRecord.get(7).replace(",", "."), "11", "11", myRecord.get(9)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
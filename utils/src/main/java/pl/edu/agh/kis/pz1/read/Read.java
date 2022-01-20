package pl.edu.agh.kis.pz1.read;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pl.edu.agh.kis.pz1.xml.Invoice;
import pl.edu.agh.kis.pz1.xml.InvoiceRow;
import pl.edu.agh.kis.pz1.xml.JPK;

import java.io.*;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;

/**
 * Static class containing methods for reading files into the jpk class from:
 * <ul>
 *     <li>.xlsx</li>
 *     <li>.csv</li>
 * </ul>
 */
public class Read {
    /**
     * Prevents the object from being created.
     */
    private Read() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Reads from .xlsx file to JPK class, which is JAXB class.
     * @param pathToFile path to file, which we want to read.
     * @return  JPK object.
     * @throws IOException if reading fails.
     */
    public static JPK readXLSX (String pathToFile) throws IOException {
        JPK jpk = new JPK();
        try (FileInputStream file = new FileInputStream(pathToFile)) {
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                if (row.getRowNum() != 0) {
                    jpk.addInvoice(new Invoice("PLN", row.getCell(4).toString(), row.getCell(5).toString(), row.getCell(0).toString(),
                            row.getCell(1).toString(), "\"CORE LOGIC\" SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ", "ul. Feliksa Radwańskiego 15/1, 30-065 Kraków", "PL", "6762484560",
                            row.getCell(2).toString(), row.getCell(4).toString(), moneyToBigDecimal(row.getCell(11).toString()), moneyToBigDecimal(row.getCell(10).toString()), moneyToBigDecimal(row.getCell(12).toString()),
                            false, false, false, false, false, false, false, false, false, false, false, "VAT"));
                    jpk.addInvoiceRow(new InvoiceRow(row.getCell(5).toString(), row.getCell(7).toString().replace(",", "."), moneyToBigDecimal(row.getCell(8).toString()), moneyToBigDecimal(row.getCell(11).toString()), row.getCell(9).toString()));
                }
            }
        }
        return jpk;
    }

    /**
     * Reads from .csv file to JPK class, which is JAXB class.
     * @param pathToFile path to file, which we want to read.
     * @return JPK object.
     * @throws IOException if reading fails.
     */
    public static JPK readCSV (String pathToFile) throws IOException {
        JPK invoices = new JPK();
        try (Reader in = new InputStreamReader(new FileInputStream(pathToFile), StandardCharsets.UTF_8)) {
            Iterable<CSVRecord> records = CSVParser.parse(in, CSVFormat.Builder.create(CSVFormat.TDF).setHeader().setSkipHeaderRecord(true).build());
            for (CSVRecord myRecord : records) {
                invoices.addInvoice(new Invoice("PLN", myRecord.get(4), myRecord.get(5), myRecord.get(0),
                        myRecord.get(1), "\"CORE LOGIC\" SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ", "ul. Feliksa Radwańskiego 15/1, 30-065 Kraków", "PL", "6762484560",
                        myRecord.get(2), myRecord.get(4), moneyToBigDecimal(myRecord.get(11)), moneyToBigDecimal(myRecord.get(10)), moneyToBigDecimal(myRecord.get(12)),
                        false, false, false, false, false, false, false, false, false, false, false, "VAT"));
                invoices.addInvoiceRow(new InvoiceRow(myRecord.get(5), myRecord.get(7).replace(",", "."), moneyToBigDecimal(myRecord.get(8)), moneyToBigDecimal(myRecord.get(11)), myRecord.get(9)));
            }
        }
        return invoices;
    }

    /**
     * Converts string as <code>"3 600 zł"</code> to string: <code>"3600.00"</code>.
     * @param s String, which will be converted.
     * @return correct string.
     */
    private static String moneyToString(String s) {
        return s.replace("zł", "").replace(",", ".").replace(" ", "").replace("\u00A0","");
    }

    /**
     * Converts string as <code>"3 600 zł"</code> to BigDecimal: <code>3600.00</code>.
     * @param s String, which will be converted.
     * @return double from string.
     */
    private static BigDecimal moneyToBigDecimal(String s) {
        return new BigDecimal(s.replace("zł", "").replace(",", ".").replace(" ", "").replace("\u00A0",""));
    }
}

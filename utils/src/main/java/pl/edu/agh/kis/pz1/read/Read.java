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
import java.nio.charset.StandardCharsets;

public class Read {
    public static JPK readXLSX (String pathToFile) throws IOException {
        JPK jpk = new JPK();
        try (FileInputStream file = new FileInputStream(pathToFile)) {
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            XSSFSheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                if (row.getRowNum() != 0) {
                    jpk.addInvoice(new Invoice("PLN", row.getCell(4).toString(), row.getCell(5).toString(), row.getCell(0).toString(),
                            row.getCell(1).toString(), "\"CORE LOGIC\" SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ", "ul. Feliksa Radwańskiego 15/1, 30-065 Kraków", "PL", "6762484560",
                            row.getCell(2).toString(), row.getCell(4).toString(), moneyToDouble(row.getCell(11).toString()), moneyToDouble(row.getCell(10).toString()), moneyToDouble(row.getCell(12).toString()),
                            false, false, false, false, false, false, false, false, false, false, false, "VAT"));
                    jpk.addInvoiceRow(new InvoiceRow(row.getCell(5).toString(), row.getCell(7).toString().replace(",", "."), moneyToString(row.getCell(8).toString()), moneyToString(row.getCell(11).toString()), row.getCell(9).toString()));
                }
            }
        }
        return jpk;
    }

    public static JPK readCSV (String pathToFile) throws IOException {
        JPK invoices = new JPK();
        try (Reader in = new InputStreamReader(new FileInputStream(pathToFile), StandardCharsets.UTF_8)) {
            Iterable<CSVRecord> records = CSVParser.parse(in, CSVFormat.Builder.create(CSVFormat.TDF).setHeader().setSkipHeaderRecord(true).build());
            for (CSVRecord record : records) {
                invoices.addInvoice(new Invoice("PLN", record.get(4), record.get(5), record.get(0),
                        record.get(1), "\"CORE LOGIC\" SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ", "ul. Feliksa Radwańskiego 15/1, 30-065 Kraków", "PL", "6762484560",
                        record.get(2), record.get(4), moneyToDouble(record.get(11)), moneyToDouble(record.get(10)), moneyToDouble(record.get(12)),
                        false, false, false, false, false, false, false, false, false, false, false, "VAT"));
                invoices.addInvoiceRow(new InvoiceRow(record.get(5), record.get(7).replace(",", "."), moneyToString(record.get(8)), moneyToString(record.get(11)), record.get(9)));
            }
        }
        return invoices;
    }

    private static Double moneyToDouble(String s) {
        return Double.parseDouble(s.replace("zł", "").replace(",", ".").replace(" ", "").replaceAll("\\u00A0",""));
    }

    private static String moneyToString(String s) {
        return s.replace("zł", "").replace(",", ".").replace(" ", "").replaceAll("\\u00A0","");
    }
}

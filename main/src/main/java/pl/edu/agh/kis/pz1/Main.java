package pl.edu.agh.kis.pz1;

import pl.edu.agh.kis.pz1.read.Read;
import pl.edu.agh.kis.pz1.write.Write;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.util.logging.Level;

/**
 * Przykładowy kod do zajęć laboratoryjnych 2, 3, 4 z przedmiotu: Programowanie zaawansowane 1
 * @author Paweł Skrzyński
 */
public class Main {
    public static void main( String[] args ) throws IOException, JAXBException {
        if (args.length != 2) {
            System.out.println("Usage: java -jar ... <filename_in> <filename_out>.");
            System.exit(1);
        } else if (args[0].split("\\.")[1].equals("csv")) {
            Write.marshal(Read.readCSV(args[0]), args[1]);
        } else if (args[0].split("\\.")[1].equals("xlsx")) {
            Write.marshal(Read.readXLSX(args[0]), args[1]);
        } else {
            System.out.println("Only .csv and .xlsx files are serverd.");
        }
    }
}

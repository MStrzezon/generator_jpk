package pl.edu.agh.kis.pz1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.edu.agh.kis.pz1.read.Read;
import pl.edu.agh.kis.pz1.write.Write;

import javax.xml.bind.JAXBException;
import java.io.*;

/**
 * XML generator from files: .csv and .xlsx
 * @author Michał Strzeżoń
 */
public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main( String[] args ) {
        try {
            if (args.length != 2) {
                logger.error("Usage: java -jar ... <filename_in> <filename_out>.");
                System.exit(1);
            } else if (args[0].split("\\.")[1].equals("csv")) {
                Write.marshal(Read.readCSV(args[0]), args[1]);
            } else if (args[0].split("\\.")[1].equals("xlsx")) {
                Write.marshal(Read.readXLSX(args[0]), args[1]);
            } else {
                logger.error("Only .csv and .xlsx files are served.");
            }
        } catch (FileNotFoundException e) {
            logger.error(args[0] + " nie istnieje.");
        } catch (JAXBException e) {
            logger.error(args[1] + "-nie istnieje taka sciezka.");
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}

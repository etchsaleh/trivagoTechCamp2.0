/**
 * Created by HeshamSaleh on 7/29/18.
 */

import reader.CSVReader;
import writer.JSONFileWriter;
import writer.XMLFileWriter;

import java.util.ArrayList;

public class Main {

    private static final String CSV_FILE_PATH = "hotels.csv";
    private static final String FILE_NAME = "hotels";

    public static void main(String[] args) {

        CSVReader reader = new CSVReader();
        JSONFileWriter jsonWriter = new JSONFileWriter();
        XMLFileWriter xmlWriter = new XMLFileWriter();

        ArrayList<ArrayList<String>> hotels = reader.read(CSV_FILE_PATH);

        jsonWriter.writeFile(hotels, FILE_NAME);
        xmlWriter.writeFile(hotels, FILE_NAME);
    }
}
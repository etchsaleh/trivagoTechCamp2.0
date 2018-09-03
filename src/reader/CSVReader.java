/**
 * Created by HeshamSaleh on 7/29/18.
 */
package reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import validator.Validator;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CSVReader {

    public ArrayList<ArrayList<String>> read(String CSV_FILE_PATH) {

        ArrayList<ArrayList<String>> hotels = new ArrayList<>();

        try {

            Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);

            for (CSVRecord hotelRecord : csvParser) {

                String name = hotelRecord.get(0);
                String address = hotelRecord.get(1);
                String stars = hotelRecord.get(2);
                String contact = hotelRecord.get(3);
                String phone = hotelRecord.get(4);
                String uri = hotelRecord.get(5);

                if(Validator.isValidListing(name,uri,stars)) {

                    ArrayList<String> hotel = new ArrayList<>();
                    hotel.add(name);
                    hotel.add(address);
                    hotel.add(stars);
                    hotel.add(contact);
                    hotel.add(phone);
                    hotel.add(uri);

                    hotels.add(hotel);
                }
            }

        } catch(IOException e) {
            e.printStackTrace();
        }

        return hotels;
    }
}

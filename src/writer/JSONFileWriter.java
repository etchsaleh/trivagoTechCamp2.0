/**
 * Created by HeshamSaleh on 7/29/18.
 */
package writer;

import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class JSONFileWriter extends writer.FileWriter {

    private JSONObject hotelObject = new JSONObject();
    private int index = 0;

    void addHotel(String name, String address, String stars, String contact, String phone, String
            uri) {

        JSONObject obj = new JSONObject();
        obj.put("name", name);
        obj.put("address", address);
        obj.put("stars", stars);
        obj.put("contact", contact);
        obj.put("phone", phone);
        obj.put("uri", uri);

        hotelObject.put(index,obj);
        index++;
    }

    public void writeFile(ArrayList<ArrayList<String>> hotels, String fileName) {

        String fileNameWithExtension = fileName + ".json";

        for(ArrayList<String> hotel : hotels) {
            String name = hotel.get(0);
            String address = hotel.get(1);
            String stars = hotel.get(2);
            String contact = hotel.get(3);
            String phone = hotel.get(4);
            String uri = hotel.get(5);

            addHotel(name,address,stars,contact,phone,uri);
        }

        try (FileWriter file = new FileWriter(fileNameWithExtension)) {
            file.write(hotelObject.toJSONString());

            System.out.println("Successfully created " + fileNameWithExtension);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

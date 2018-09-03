/**
 * Created by HeshamSaleh on 7/29/18.
 */
package writer;

import java.util.ArrayList;

abstract public class FileWriter {

    abstract public void writeFile(ArrayList<ArrayList<String>> hotels, String fileName);

    abstract void addHotel(String name, String address, String stars, String contact, String phone, String
            uri);
}

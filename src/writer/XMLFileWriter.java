/**
 * Created by HeshamSaleh on 7/29/18.
 */
package writer;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class XMLFileWriter extends writer.FileWriter {

    private Element root = new Element("HOTELS");
    private Document doc = new Document();

    void addHotel(String name, String address, String stars, String contact, String phone, String
            uri) {

        Element child1 = new Element("NAME");
        child1.addContent(name);

        Element child2 = new Element("ADDRESS");
        child2.addContent(address);

        Element child3 = new Element("STARS");
        child3.addContent(stars);

        Element child4 = new Element("CONTACT");
        child4.addContent(contact);

        Element child5 = new Element("PHONE");
        child5.addContent(phone);

        Element child6 = new Element("URI");
        child6.addContent(uri);

        Element hotel = new Element("HOTEL");

        hotel.addContent(child1);
        hotel.addContent(child2);
        hotel.addContent(child3);
        hotel.addContent(child4);
        hotel.addContent(child5);
        hotel.addContent(child6);

        root.addContent(hotel);
    }

    public void writeFile(ArrayList<ArrayList<String>> hotels, String fileName) {

        String fileNameWithExtension = fileName + ".xml";

        for(ArrayList<String> hotel : hotels) {
            String name = hotel.get(0);
            String address = hotel.get(1);
            String stars = hotel.get(2);
            String contact = hotel.get(3);
            String phone = hotel.get(4);
            String uri = hotel.get(5);

            addHotel(name,address,stars,contact,phone,uri);
        }

        doc.setRootElement(root);

        XMLOutputter outputter = new XMLOutputter();
        outputter.setFormat(Format.getPrettyFormat());
        try {

            outputter.output(doc, new FileWriter(new File(fileNameWithExtension)));

            System.out.println("Successfully created " + fileNameWithExtension);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

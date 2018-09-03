/**
 * Created by HeshamSaleh on 7/29/18.
 */
package validator;

import java.io.UnsupportedEncodingException;
import java.net.URL;

public class Validator {

    private static boolean isValidHotelName(String hotelName) {
        String utf8String = null;
        try {
            utf8String = new String(hotelName.getBytes("UTF-8"),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return utf8String.equals(hotelName);
    }

    private static boolean isValidURL(String hotelUrl) {
        try {
            URL url = new URL(hotelUrl);
            url.toURI();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    private static boolean isValidHotelRating(String hotelRating) {
        double r = Integer.parseInt(hotelRating);
        if(r > 5 || r < 0) return false;
        return true;
    }

    public static boolean isValidListing(String hotelName, String hotelUrl, String hotelRating) {
        return isValidHotelName(hotelName) && isValidURL(hotelUrl) && isValidHotelRating(hotelRating);
    }
}

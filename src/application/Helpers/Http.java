package application.Helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Http {
	private static String apiServer = "http://192.168.1.1/";
	public static String apiHost = apiServer+"serversim/api/";
	public static boolean checkConnection() {
        try {
            URL url = new URL(apiServer+"api/general/checkConnection");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            
            if (conn.getResponseCode() != 200) {
	                Warning.showWarning("Failed : HTTP error code : "
	                        + conn.getResponseCode()); 
	                return false;
//	                    throw new RuntimeException("Failed : HTTP error code : "
//	                                    + conn.getResponseCode());
            }else {
                return true;
            }
//	            conn.disconnect();

        } catch (MalformedURLException e) {
            return false;
        } catch (IOException e) {
            return false;
        }
    }
	public static String getDataJSON(String targetUrl) {
		if(checkConnection()) {
	        try {
	            URL url = new URL(targetUrl);
	            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

	            conn.setRequestMethod("GET");
	            conn.setRequestProperty("Accept", "application/json");
	            
	            if (conn.getResponseCode() != 200) {
	                Warning.showWarning("Failed : HTTP error code : "
	                        + conn.getResponseCode()); 
	            }
	            BufferedReader br = new BufferedReader(new InputStreamReader(
	                    (conn.getInputStream())));
	            String output;
	            while ((output = br.readLine()) != null) {
	        		return output;
	            }
	            conn.disconnect();

	        } catch (MalformedURLException e) {
	        } catch (IOException e) {
	        }
		}
		return targetUrl;
	}
	public static boolean doAction(String targetUrl) {
        try {
            URL url = new URL(apiServer+targetUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
//	            System.out.println(url);
//	            System.out.println(conn.getResponseCode());
            if (conn.getResponseCode() != 200) {
	                Warning.showWarning("Failed : HTTP error code : "
	                        + conn.getResponseCode()); 
	                return false;
            }else {

	            BufferedReader br = new BufferedReader(new InputStreamReader(
	                    (conn.getInputStream())));
	            String output;
	            while ((output = br.readLine()) != null) {
	            	System.out.println(output);
	                return true;
	            }
            }

        } catch (MalformedURLException e) {
            return false;
        } catch (IOException e) {
            return false;
        }
		return false;
	}
	public static boolean isJSONValid(String test) {
	    try {
	        new JSONObject(test);
	    } catch (JSONException ex) {
	        // edited, to include @Arthur's comment
	        // e.g. in case JSONArray is valid as well...
	        try {
	            new JSONArray(test);
	        } catch (JSONException ex1) {
	            return false;
	        }
	    }
	    return true;
	}
}

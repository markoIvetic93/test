package controllers;

import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;


public class SendPushNotification {
	
	public final static String AUTH_KEY_FCM = "AAAAcKWYAKk:APA91bHa4xFSBXaBdfHmOR4wvVOd-9G6mrJWkWWd54TEo6Wj9KjsP-k6SFmNV7MhUHNFITQeCkGp9Px6ZYE4YwjeHBaAHukUE5M21gfaovd1hIF4cTK1UD50FeWpMUOaOvart5Q5kEP5";
	public final static String API_URL_FCM = "https://fcm.googleapis.com/fcm/send";

	// userDeviceIdKey is the device id you will query from your database

	public static String pushFCMNotification(String token, String time) throws Exception{

	   String authKey = AUTH_KEY_FCM; // You FCM AUTH key
	   String FMCurl = API_URL_FCM; 

	   URL url = new URL(FMCurl);
	   HttpURLConnection conn = (HttpURLConnection) url.openConnection();

	   conn.setUseCaches(false);
	   conn.setDoInput(true);
	   conn.setDoOutput(true);

	   conn.setRequestMethod("POST");
	   conn.setRequestProperty("Authorization","key="+authKey);
	   conn.setRequestProperty("Content-Type","application/json");
	   
	   //cdQvJB3tpJk:APA91bEvXt6T6TfJpin1BkG2ZfCJD-g0aPq8x27PU69FIYal2u1nXrqwkoJNaTykUjgXqOUV_xi0t2W7ULPutHZvjKFSjQchOQ9QjAXP-GcQp3BMQQD5R-MVZ1ZX3GQmbzhXHG6aJrwe
	   
	   String notification = String.format("{\"to\":\"{0}\",\"notification\":{\"title\":\"Kraj rezervacije parkinga\",\"body\":\"Vas parking istice za {1} minuta.\"}}", token, time);

	   OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
	   wr.write(notification);
	   wr.flush();
	   conn.getInputStream();
	   return notification;
	}
	
}
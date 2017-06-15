package controllers;

import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;


public class SendPushNotification {
	
	public final static String AUTH_KEY_FCM = "AIzaSyD9JpLppgR-9ujxz16NWSi8SP4KlhrLmkc";
	public final static String API_URL_FCM = "https://fcm.googleapis.com/fcm/send";

	// userDeviceIdKey is the device id you will query from your database

	public static void pushFCMNotification() throws Exception{

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

	   Gson json = new Gson();
	   String to = "/topics/reservation";
	   json.toJson(to);
	   Gson info = new Gson();
	   String title = "Notificatoin Title";
	   info.toJson(title); // Notification title
	   String body = "Hello Test notification";
	   info.toJson(body); // Notification body
	   Gson notification = info;
	   json.toJson(notification);

	   OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
	   wr.write(json.toString());
	   wr.flush();
	   conn.getInputStream();
	}
	
}
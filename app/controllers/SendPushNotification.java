package controllers;

import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import models.PushNotificationBody;
import models.PushNotificationHeader;

import com.google.gson.Gson;


public class SendPushNotification {
	
	public final static String AUTH_KEY_FCM = "AIzaSyA3PkNCDYHupclVdvlI3i-7yH2_Oq4gqP8";
	public final static String API_URL_FCM = "https://fcm.googleapis.com/fcm/send";

	// userDeviceIdKey is the device id you will query from your database

	public static void pushFCMNotification(String deviceToken) throws Exception{

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
	   
	   PushNotificationBody notBody = new PushNotificationBody("Hello", "First push notification from backedn!!!", "message");
	   PushNotificationHeader notHeader = new PushNotificationHeader("/topics/reservation", new Gson().toJson(notBody));
	   
	   
/*	   json.put("to", deviceToken);
	   info.put("title", "Hello"); // Notification title
	   info.put("body", "First push notification from backedn!!!"); // Notification body
	   info.put("type", "message");
	   json.put("data", info);*/
	   System.out.println(new Gson().toJson(notHeader));


	   OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
	   wr.write(new Gson().toJson(notHeader));
	   wr.flush();
	   conn.getInputStream();
	}
	
}
package controllers;

import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import models.PushNotificationBody;
import models.PushNotificationHeader;

import com.google.gson.Gson;


public class SendPushNotification {
	
	public final static String AUTH_KEY_FCM = "AAAAcKWYAKk:APA91bHa4xFSBXaBdfHmOR4wvVOd-9G6mrJWkWWd54TEo6Wj9KjsP-k6SFmNV7MhUHNFITQeCkGp9Px6ZYE4YwjeHBaAHukUE5M21gfaovd1hIF4cTK1UD50FeWpMUOaOvart5Q5kEP5";
	public final static String API_URL_FCM = "https://fcm.googleapis.com/fcm/send";

	// userDeviceIdKey is the device id you will query from your database

	public static String pushFCMNotification() throws Exception{

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
	   
	   //PushNotificationBody notBody = new PushNotificationBody("Hello", "First push notification from backedn!!!", "message");
	   //PushNotificationHeader notHeader = new PushNotificationHeader("/topics/reservation", new Gson().toJson(notBody));
	   
	   
/*	   json.put("to", deviceToken);
	   info.put("title", "Hello"); // Notification title
	   info.put("body", "First push notification from backedn!!!"); // Notification body
	   info.put("type", "message");
	   json.put("data", info);*/
	   //System.out.println(new Gson().toJson(notHeader));
	   
	   String notification = "{\"to\":\"/topics/reservation\",\"notification\":{\"title\":\"messageFromServer\",\"body\":\"first notification from server\"}}";

	   OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
	   wr.write(notification);
	   wr.flush();
	   conn.getInputStream();
	   return notification;
	}
	
}
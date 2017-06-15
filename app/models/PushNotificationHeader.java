package models;

import java.util.HashMap;

public class PushNotificationHeader {

	String to;
	protected HashMap<String, String> header = new HashMap<String, String>();
	
	public PushNotificationHeader(String to, PushNotificationBody body)
	{
		header.put("to", to);
		header.put("data", body.toString());
	}
}

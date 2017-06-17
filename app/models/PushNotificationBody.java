package models;

import java.util.HashMap;

public class PushNotificationBody {

	String title;
	String body;
	String type;
	protected HashMap<String, String> data = new HashMap<String, String>();
	public PushNotificationBody(String title, String body, String type)
	{
		data.put("title", title);
		data.put("body", body);
		data.put("type", type);
	}
}

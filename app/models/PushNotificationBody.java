package models;

import java.util.HashMap;

public class PushNotificationBody {

	String title;
	String body;
	String type;
	protected HashMap<String, String> bodyMap = new HashMap<String, String>();
	public PushNotificationBody(String title, String body, String type)
	{
		bodyMap.put("title", title);
		bodyMap.put("body", body);
		bodyMap.put("type", type);
	}
}

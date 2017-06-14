package controllers;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import play.mvc.Controller;

public class Comments extends Controller{

	public static void listCommentsByParking(String title){
		try{
			List<models.Comment> comments = models.Comment.find("byParkingname", title).fetch();
			models.Comment comment = comments.get(0);
			renderJSON(comment);
		}catch(Exception e){
			error("Unable to read entities!");
		}
	}
	
	public static void create(){
		String jsonAsString = params.get("body");
		JsonParser jsonParser = new JsonParser();
		JsonObject jsonObject = (JsonObject)jsonParser.parse(jsonAsString);
		models.Comment newComment = new Gson().fromJson(jsonObject, models.Comment.class);
		
		try{
			Boolean success = newComment.validateAndCreate();
			if (success){
				renderJSON(newComment);
			}else{
				badRequest("Unable to validate and create entity!");
			}
		}catch(Exception e){
			error("Unable to create entity!");
		}
	}
	
}

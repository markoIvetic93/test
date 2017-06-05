package controllers;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import play.mvc.Controller;

public class Users extends Controller{
	
	public static void all(){
		try{
			List<models.User> users = models.User.findAll();
			renderJSON(users);
		}catch(Exception e){
			error("Unable to read entities!");
		}
	}
	
	public static void get(long id){
		try{
			models.User user = models.User.findById(id);
			renderJSON(user);
		}catch(Exception e){
			error("Unable to read entity!");
		}
	}
	
	public static void update(){
		try{
			String jsonAsString = params.get("body");
			JsonParser jsonParser = new JsonParser();
			JsonObject jsonObject = (JsonObject)jsonParser.parse(jsonAsString);
			models.User newUser = new Gson().fromJson(jsonObject, models.User.class);
			
			models.User oldUser = models.User.findById(newUser.id);

			oldUser.username = newUser.username;
			
			oldUser.save();
			renderJSON(oldUser);
			
		}catch(Exception e){
			error("Unable to update entity!");
		}
	}
	
	public static void create(){
		String jsonAsString = params.get("body");
		JsonParser jsonParser = new JsonParser();
		JsonObject jsonObject = (JsonObject)jsonParser.parse(jsonAsString);
		models.User newUser = new Gson().fromJson(jsonObject, models.User.class);
		
		newUser.password = newUser.password;
		
		try{
			Boolean success = newUser.validateAndCreate();
			if (success){
				renderJSON(newUser);
			}else{
				badRequest("Unable to validate and create entity!");
			}
		}catch(Exception e){
			error("Unable to create entity!");
		}
	}
	
	public static void delete(Long id){
		try{
			models.User user = models.User.findById(id);
			
			user.delete();
			ok();
		}catch(Exception e){
			error("Unable to delete entity!");
		}
	}

}

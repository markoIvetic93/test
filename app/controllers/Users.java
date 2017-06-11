package controllers;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import play.mvc.Controller;

public class Users extends Controller{
	
	public static void all(){
		try{
			List<models.MyUser> users = models.MyUser.findAll();
			renderJSON(users);
		}catch(Exception e){
			error("Unable to read entities!");
		}
	}
	
	public static void get(long id){
		try{
			models.MyUser user = models.MyUser.findById(id);
			renderJSON(user);
		}catch(Exception e){
			error("Unable to read entity!");
		}
	}
	
	public static void getByUsername(String username){
		try{
			List<models.MyUser> users = models.MyUser.find("byUsername", username).fetch();
			models.MyUser user = users.get(0);
//			for(int i = 0; i <= users.size(); i++){
//				user = users.get(i);
//			}
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
			models.MyUser newUser = new Gson().fromJson(jsonObject, models.MyUser.class);
			
			models.MyUser oldUser = models.MyUser.findById(newUser.id);

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
		models.MyUser newUser = new Gson().fromJson(jsonObject, models.MyUser.class);
		
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
			models.MyUser user = models.MyUser.findById(id);
			
			user.delete();
			ok();
		}catch(Exception e){
			error("Unable to delete entity!");
		}
	}

}

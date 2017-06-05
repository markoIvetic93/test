package controllers;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import play.mvc.Controller;

public class Parkings extends Controller{
	
	public static void all(){
		try{
			List<models.Parking> parkings = models.Parking.findAll();
			renderJSON(parkings);
		}catch(Exception e){
			error("Unable to read entities!");
		}
	}
	
	public static void get(long id){
		try{
			models.Parking parking = models.Parking.findById(id);
			renderJSON(parking);
		}catch(Exception e){
			error("Unable to read entity!");
		}
	}
	
	public static void update(){
		try{
			String jsonAsString = params.get("body");
			JsonParser jsonParser = new JsonParser();
			JsonObject jsonObject = (JsonObject)jsonParser.parse(jsonAsString);
			models.Parking newParking = new Gson().fromJson(jsonObject, models.Parking.class);
			
			models.Parking oldParking = models.User.findById(newParking.id);
			oldParking.em().merge(newParking);
			
			Boolean success = oldParking.validateAndSave();

			if (success){
				renderJSON(oldParking);
			}else{
				badRequest("Unable to validate and update entity!");
			}
			
		}catch(Exception e){
			error("Unable to update entity!");
		}
	}
	
	public static void create(){
		String jsonAsString = params.get("body");
		JsonParser jsonParser = new JsonParser();
		JsonObject jsonObject = (JsonObject)jsonParser.parse(jsonAsString);
		models.Parking newParking = new Gson().fromJson(jsonObject, models.Parking.class);
		
		try{
			Boolean success = newParking.validateAndCreate();
			if (success){
				renderJSON(newParking);
			}else{
				badRequest("Unable to validate and create entity!");
			}
		}catch(Exception e){
			error("Unable to create entity!");
		}
	}
	
	public static void delete(Long id){
		try{
			models.Parking parking = models.Parking.findById(id);
			
			parking.delete();
			ok();
		}catch(Exception e){
			error("Unable to delete entity!");
		}
	}

}

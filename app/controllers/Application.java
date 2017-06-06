package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.MyUser;

public class Application extends Controller {

    public static void index() {
        render();
    }
    
    public static void users() {
        List<MyUser> users = MyUser.findAll();
        renderJSON(users);
    }

}
package model;
import servlet.newServlet;


public class LoginModel {

    public static boolean checkuser(String id, String pass) {
    	
    	 return newServlet.isValidUser(id, pass);
    }
}

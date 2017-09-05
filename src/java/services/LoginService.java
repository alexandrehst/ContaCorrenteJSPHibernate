/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.HashMap;
import models.User;

/**
 *
 * @author alexandretorres
 */
public class LoginService {
    
    private HashMap<String, User> users = new HashMap<>();
    
    public LoginService(){
        users.put("jose",new User("José Antonio", "jose", "jose"));
        users.put("manoel", new User("Manoel Benedito", "manoel", "manoel"));
        users.put( "tobias", new User("Tobias Joaquim", "tobias", "tobias"));
    }
    
    public boolean authenticate(String userId, String password){
        if (password == null || password.trim().equals(""))
            return false; 
        User u = users.get(userId);
        
        // Se usuário não existe na lista
        if (u == null)
            return false;
        
        
        // Se a senha é diferente
        if (!u.getPassword().equals(password))
            return false;
        
        return true;
    }
    
    public User getUser(String userId ){

        return users.get(userId);
    }
}

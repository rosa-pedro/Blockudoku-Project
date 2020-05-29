/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import static game.FileHandler.readSerializedFile;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Storm
 */
public class Users implements Serializable{

    private static final long serialVersionUID = 4L;
    ArrayList<User> users = new ArrayList<>();

    public User getUser(String name) {
        
        User user = null;
        
        Iterator it = users.iterator();
        
                while(it.hasNext()){
                    
                    User current = (User) it.next();
                    
                    if(current.getName().equalsIgnoreCase(name)){
                        
                        return current;
                    }
                    
                }
                
        return user;
    }
    
    public void loadUsersFromFile(Users loadedUsers){
        
        ArrayList<User> loadedUsersList = loadedUsers.getUsers();
        
        users.addAll(loadedUsersList);
    }
    
    public void addUser(User user){
        
        users.add(user);
    }
    
    public ArrayList<User> getUsers(){
        
        return users;
    }
    
    
    
    public static User getExistingUser(String selectedUser){
        
        Users users1 = new Users();
        
            users1.loadUsersFromFile(readSerializedFile("poggers1.bin"));
        
            User user = users1.getUser(selectedUser);
        
        return user;
    }
    
    public static boolean checkExistingUser(String selectedUser){
        User user = getExistingUser(selectedUser);
        return user != null;
    }
    
    public static Game getGameFromUser(String selectedUser){
        
        Game game = null;
        
            game = getExistingUser(selectedUser).getGame();
            
        return game;
    }

    @Override
    public String toString(){
        
        return "working!!!";
    }
}

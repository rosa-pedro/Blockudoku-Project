/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import static game.Users.*;



/**
 *
 * @author Storm
 */
public class MenuPrint {
    
    
    public static void mainMenu(){
        System.out.println("\n1 - Iniciate New Game");
        System.out.println("2 - Load Game");
        System.out.println("3 - Show Personal Scores");
        System.out.println("4 - TOP 10 Ranks");
        System.out.println("0 - Exit");
    }   
    
    public static void welcomeMenu(User user){
        System.out.println("Hello " + user.getName());
        mainMenu();
    } 
    
    
    public static void newGameMenu(){
        System.out.println("1 - Basic mode");
        System.out.println("2 - Advanced mode");
        System.out.println("0 - Return");
    }
    
    public static void requestUserName(){
        System.out.println("Welcome to Blocku Doku\n\n");
        System.out.print("Enter your User name: ");
    }
    
    
    public static void top10Menu(){
    
    }
    
    public static void personalScoresMenu(){
        
    }
    
    public static User selectUser(String userName){
    
        User user = null;
        
    if(checkExistingUser(userName)){
            System.out.println("Loading User...");
            user = getExistingUser(userName);
            
        } else {
            System.out.println("Creating new User...");
            User newUser = new User(userName);
            return newUser;
        }
    
        return user;
    }
}

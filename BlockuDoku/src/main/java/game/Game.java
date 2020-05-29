/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.Serializable;
import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;

/**
 *
 * @author Storm
 */
public class Game implements Serializable{
    
    private static final long serialVersionUID = 4L;
    //private E element;
    private String name;
    private LocalDateTime date;
    
    
    public Game(){
        name = "gamezao";
    }
    
    
    public Game(String name){
        this.name = name;
    }
    
     public void play(){
         System.out.println("playing!!!!!!!!!!!!!!!!!!!!!!!");
    }
    
    public void setTime(LocalDateTime date){
        this.date = date;
    }
    
    public String getTime(){
        return date.getDayOfMonth() + "/" + date.getMonthValue() + "  " + date.getHour()+ ":"+ date.getMinute();
    }
    
    public String getName(){
        return name;
    }
    
   @Override  
    public String toString(){
        return name;
    }
}

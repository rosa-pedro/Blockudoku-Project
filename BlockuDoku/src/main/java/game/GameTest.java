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
public class GameTest implements Serializable{
    
    private static final long serialVersionUID = 9873268974234L;
    String test;
    private LocalDateTime date;
    //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("m/dd HH:mm");
    
    public GameTest(){
        this.test =  "Testing testing";
    }
    
    
    
    @Override
    public String toString(){
        return test;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ips.blockudoku.game;
import java.util.Scanner;

/**
 *
 * @author Storm
 */
public class Parser {
    Scanner sc;
    
    public Parser(){
        sc = new Scanner(System.in);    
    }
    
    public String readInput(){
        return sc.nextLine();
    }
    
    
}

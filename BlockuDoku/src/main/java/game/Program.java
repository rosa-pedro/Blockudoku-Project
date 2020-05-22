/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author rosap
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        IBlock iBlock = new IBlock();
        System.out.println(iBlock);
        
        
        
        boolean finished = false;
        
        Parser p1 = new Parser();
        User user = new User("Maleque");
        ProcessCommand pc = new ProcessCommand();
        Menu m1 = new Menu();
        m1.welcomeMenu(user);
        
        while(!finished){
           finished = pc.processCommand(user, p1.readInput(), m1.getMenuState());
        }
        
        
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/** This class helps with the serialization of the list of Users
 * contains a save and read method
 * 
 *
 * @author Pedro Rosa - 190221015
 * @author Joao Cetano - 190221010
 */
public class UsersFileHandler {

    /**
     * Saves the Users obj to the filename 
     * 
     * @param obj obj to be saved
     * @param filename filename where it'll be saved
     */
    public static void saveFile(Users listOfUsers, String filename) {
    
        try {

            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream(filename));
            oos.writeObject(listOfUsers);

            oos.flush();
            oos.close();

        } catch (IOException e) {

            System.out.println(e.getMessage());
        }
    }
    
    
    /**
     * Method that reads the Users file and returns its contents
     * 
     * @param filename filename where Users is located
     * @return Users read from file
     */

    public static Users readFile(String filename) {

        Users listOfUsers = null;
        try {

            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(filename));
            listOfUsers = (Users) ois.readObject();

            ois.close();

        } catch (IOException e) {

            System.out.println(e.getMessage());
            listOfUsers = new Users();

        } catch (ClassNotFoundException e) {

            System.out.println(e.getMessage());
            listOfUsers = new Users();

        }
        return listOfUsers;
    }
}

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
public class FileHandler {

    /**
     * Saves the Users obj to the filename 
     * 
     * @param obj obj to be saved
     * @param filename filename where it'll be saved
     */
    public static void saveFile(Users obj, String filename) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream(filename));
            oos.writeObject(obj);
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
    public static Users readSerializedFile(String filename) {
        Users obj = new Users();
        try {
            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(filename));
            obj = (Users)ois.readObject();
            ois.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return obj;
    }
}

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

/**
 *
 * @author Storm
 */
public class FileHandler {

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

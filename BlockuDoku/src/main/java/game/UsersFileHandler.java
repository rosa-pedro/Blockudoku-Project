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
 * @author rosap
 */
public class UsersFileHandler {

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

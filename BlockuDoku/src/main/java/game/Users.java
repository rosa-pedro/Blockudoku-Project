/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.Serializable;
import java.util.ArrayList;

/** This class extends ArrayList<User> in order to create a List of Users
 * 
 *
 * @author Pedro Rosa - 190221015 - 190221015@estudantes.ips.pt
 * @author Joao Cetano - 190221010 - 190221010@estudantes.ips.pt
 */

public class Users extends ArrayList<User> implements Serializable {

    /**
     * Constructor of User using super()
     */
    public Users() {
        super();
    }

    /**
     * Getter for User, checks if a User with matching userName exists and returns it if it does
     * 
     * @return User if matched, null if no match found
     */
    public User getUser(String userName) {

        return this.stream().filter(u -> u.getName().equalsIgnoreCase(userName)).findFirst().orElse(null);
    }
    
}

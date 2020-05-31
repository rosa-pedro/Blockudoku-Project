/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Storm
 */
public class Users extends ArrayList<User> implements Serializable {

    public Users() {
        super();
    }

    public User getUser(String userName) {

        return this.stream().filter(u -> u.getName().equalsIgnoreCase(userName)).findFirst().orElse(null);
    }
}

package com.epam.lab.game.view;

public class Login {
    public static boolean authenticate(String username, String password) {
        // hardcoded username and password
        if (username.equals("bob") && password.equals("secret")) {
            return false;
        }
        return true;
    }
}

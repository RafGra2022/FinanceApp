package main.model.register;


import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class UserData {


    private String _ID;
    private String _password;


    public HashMap<String, String> users = new HashMap<String, String>();

    public String get_ID() {
        return _ID;
    }

    public String get_password() {
        return _password;
    }


}

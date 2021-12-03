package main.services;

import java.util.List;


import main.entities.User;
import org.apache.velocity.exception.ResourceNotFoundException;

public interface UserService {

    public List<User> getUsers();

    public void saveUser(User theUser);

    public User getUser(String user) throws ResourceNotFoundException;

    public void deleteUser(String user) throws ResourceNotFoundException;

}
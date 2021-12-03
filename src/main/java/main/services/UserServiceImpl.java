package main.services;

import main.controller.Service;
import main.entities.User;
import main.repositories.UserRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public class UserServiceImpl implements UserService {

    @Qualifier("userRepository")
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public void saveUser(User theUser) {
        userRepository.save(theUser);
    }

    @Override
    @Transactional
    public User getUser(String user) throws ResourceNotFoundException {
        return userRepository.findById(user).orElseThrow(
                () -> new ResourceNotFoundException(user));
    }

    @Override
    @Transactional
    public void deleteUser(String user) {
        userRepository.deleteById(user);
    }
}


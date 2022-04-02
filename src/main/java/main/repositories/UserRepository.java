package main.repositories;

import main.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByUser(String user);
    List<User> findByPassword(String password);

}
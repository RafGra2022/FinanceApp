package main.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<UserEntity, Long> {

    List<UserEntity> findByUser(String user);
    List<UserEntity> findByPassword(String password);
    Optional<UserEntity> findByUserAndPassword(String username, String password);


}
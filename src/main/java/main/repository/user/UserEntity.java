package main.repository.user;

import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "username")
    private String user;

    @Column(name = "password")
    private String password;


    public UserEntity(String user, String password){
        this.user=user;
        this.password=password;

    }

}


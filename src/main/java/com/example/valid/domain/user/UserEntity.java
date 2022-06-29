package com.example.valid.domain.user;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name="user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;

//    @Builder(access = AccessLevel.PRIVATE)
//    UserEntity(UserEntity id, UserEntity username){
//        this.id = id;
//        this.username = username;
//    }
//
//    public static UserEntity of(UserEntity userEntity){
//        return UserEntity.builder().build();
//    }

}

package com.example.vaibhav.k_login;


import android.arch.persistence.room.Dao;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.vaibhav.k_login.User;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("SELECT * FROM user WHERE fname LIKE :firstName AND lname LIKE :lastName ")
    User findByName(String firstName, String lastName);

    @Query("SELECT COUNT(*) FROM user ")
    int userCount();


    @Insert
    void insertAll(User... users);

    @Delete
    void delete(User user);



}

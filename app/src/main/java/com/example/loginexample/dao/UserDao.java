package com.example.loginexample.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.loginexample.User;

@Dao
public interface UserDao {

    @Query("SELECT * FROM User WHERE email = :email AND password = :password")
    User getUser(String email, String password);

    @Insert
    void insert(User user);
}

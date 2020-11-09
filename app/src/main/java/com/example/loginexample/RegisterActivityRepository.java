package com.example.loginexample;

import android.app.Application;

import com.example.loginexample.dao.UserDao;
import com.example.loginexample.database.AppExecutors;
import com.example.loginexample.database.UserDatabase;

public class RegisterActivityRepository {

    private UserDao mUserDao;

    public RegisterActivityRepository(Application application) {
        UserDatabase userDatabase = UserDatabase.getInstance(application);
        mUserDao = userDatabase.getUserDao();
    }

    public void insertUser(User user) {
        AppExecutors.getInstance().getDiskIO().execute(new Runnable() {
            @Override
            public void run() {
                mUserDao.insert(user);
            }
        });
    }
}

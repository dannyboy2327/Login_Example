package com.example.loginexample;

import android.app.Application;

import com.example.loginexample.dao.UserDao;
import com.example.loginexample.database.AppExecutors;
import com.example.loginexample.database.UserDatabase;

public class MainActivityRepository {

    private UserDao mUserDao;
    private User mUser;

    public MainActivityRepository(Application application) {
        UserDatabase userDatabase = UserDatabase.getInstance(application);
        mUserDao = userDatabase.getUserDao();
    }

    public User getUser(String email, String password) {
        AppExecutors.getInstance().getDiskIO().execute(new Runnable() {
            @Override
            public void run() {
                mUser = mUserDao.getUser(email, password);
            }
        });

        return mUser;
    }
}

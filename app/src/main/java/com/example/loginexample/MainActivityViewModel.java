package com.example.loginexample;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

public class MainActivityViewModel extends AndroidViewModel {

    private MainActivityRepository mMainActivityRepository;

    public MainActivityViewModel(Application application) {
        super(application);
        mMainActivityRepository = new MainActivityRepository(application);
    }

    public User getUser(String email, String password) {
        return mMainActivityRepository.getUser(email, password);
    }
}

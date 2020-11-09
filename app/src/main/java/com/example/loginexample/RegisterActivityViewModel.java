package com.example.loginexample;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class RegisterActivityViewModel extends AndroidViewModel {

    private RegisterActivityRepository mRepository;

    public RegisterActivityViewModel(@NonNull Application application) {
        super(application);
        mRepository = new RegisterActivityRepository(application);
    }

    public void insertUser(User user) {
        mRepository.insertUser(user);
    }
}

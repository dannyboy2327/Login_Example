package com.example.loginexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.loginexample.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {

    private ActivityRegisterBinding mBinding;
    private RegisterActivityViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_register);
        mViewModel = new ViewModelProvider(this, new RegisterViewModelFactory(this.getApplication())).get(RegisterActivityViewModel.class);

        onLoginClick();
        onRegisterClick();
    }

    private void onRegisterClick() {
        mBinding.buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = mBinding.editTextUsername.getText().toString().trim();
                String email = mBinding.editTextEmail.getText().toString().trim();
                String password = mBinding.editTextPassword.getText().toString().trim();
                String passwordConf = mBinding.editTextCnfPassword.getText().toString().trim();

                if (password.equals(passwordConf)) {
                    User user = new User(userName, password, email);
                    mViewModel.insertUser(user);
                    startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                } else {
                    Toast.makeText(RegisterActivity.this, "Password doesn't match", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void onLoginClick() {
        mBinding.textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, MainActivity.class));
            }
        });
    }

}
package com.example.loginexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.loginexample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;
    private MainActivityViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mViewModel = new ViewModelProvider(this, new MyViewModelFactory(this.getApplication())).get(MainActivityViewModel.class);
        onRegisterClick();
        onLoginClick();
    }

    private void onLoginClick() {
        mBinding.buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mBinding.editTextEmail.getText().toString().trim();
                String password = mBinding.editTextPassword.getText().toString().trim();

                User user = mViewModel.getUser(email, password);

                if (user != null) {
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    intent.putExtra("User", user);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Email or password is not recognizable", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void onRegisterClick() {
        mBinding.textViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });
    }
}
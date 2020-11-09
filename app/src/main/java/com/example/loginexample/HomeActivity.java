package com.example.loginexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.loginexample.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_home);

        resetPassword();
    }

    private void resetPassword() {
        String email = mBinding.editTextEmail.getText().toString().trim();
        if (email != null) {
            mBinding.buttonReset.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent emailIntent = new Intent(Intent.ACTION_SEND);
                    emailIntent.setType("*/*");
                    emailIntent.putExtra(Intent.EXTRA_EMAIL, email);
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Password rest link");
                    emailIntent.putExtra(Intent.EXTRA_TEXT, "http://www.login-app.com");
                    startActivity(Intent.createChooser(emailIntent, "Send email..."));
                }
            });
        } else {
            Toast.makeText(this, "Email has not been set", Toast.LENGTH_SHORT).show();
        }

    }
}
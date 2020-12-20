package com.example.orahiassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Random;

public class OtpActivity extends AppCompatActivity {

    ConstraintLayout constraintLayout;

    TextInputEditText etOtp;

    MaterialButton btnSubmit;

    Random random = new Random();
    int otp = +random.nextInt(10000);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);


        constraintLayout = findViewById(R.id.constraintLayout);
        etOtp = findViewById(R.id.etOtp);
        btnSubmit = findViewById(R.id.btnSubmit);


        displayOtp();
        checkOtp();
    }

    public void displayOtp() {


        Snackbar snackbar = Snackbar.make(constraintLayout, "OTP is: " + String.valueOf(otp), Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    public void moveToHomeScreen() {
        Intent intent = new Intent(OtpActivity.this, HomeActivity.class);
        startActivity(intent);
    }

    public void checkOtp() {
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!etOtp.getText().toString().equals(String.valueOf(otp))) {
                    etOtp.setError("Enter Correct Otp");
                }
                else {
                    moveToHomeScreen();
                }
            }
        });


    }
}
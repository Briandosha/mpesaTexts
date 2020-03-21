package com.example.mpesatexts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class SignUp extends AppCompatActivity {
    public TextInputEditText emailTx, passwordTx, confirmTx;
    public MaterialButton btnSignup;
    public String email, password, confirmPassword;
    TextView tXLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        emailTx =  findViewById(R.id.ed_email);
        passwordTx =  findViewById(R.id.ed_pass);
        confirmTx =  findViewById(R.id.ed_confirmpass);
        tXLogin =  findViewById(R.id.link_login);
        btnSignup = findViewById(R.id.btn_signup);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = emailTx.getText().toString().trim();
                password = passwordTx.getText().toString().trim();

                if (validateLogin()){
                    Intent intent =  new Intent(SignUp.this,Login.class);
                    startActivity(intent);
                    finish();

                }


                else {
                    Toast.makeText(SignUp.this, "correct all the fields and try again", Toast.LENGTH_SHORT).show();
                }


            }
        });

        tXLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(SignUp.this,Login.class);
                startActivity(intent);
                finish();
            }
        });




    }


    public boolean validateLogin(){
        boolean valid = true;
        if (email == null){
            valid = false;
            emailTx.setError("email cannot be null");

        }

        if(password == null){
            valid = false;
            passwordTx.setError("password cannot be null");

        }

        if(email!= null && email.equals("")){
            valid = false;
            emailTx.setError("email cannot be empty");


        }

        if(password!= null && password.equals("")){
            valid = false;
            passwordTx.setError("password cannot be empty");


        }


        if(confirmPassword == null){
            valid = false;
            confirmTx.setError("confirm password cannot be null");

        }


        if(confirmPassword!= null && confirmPassword.equals("")){
            valid = false;
            confirmTx.setError("confirm password cannot be empty");


        }

        return valid;
    }

}

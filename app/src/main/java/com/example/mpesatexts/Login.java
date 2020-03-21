package com.example.mpesatexts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class Login extends AppCompatActivity {

    public TextInputEditText emailTx, passwordTx;
    public MaterialButton btnLogin;
    public String email, password;
    LinearLayout linearLayoutSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailTx =  findViewById(R.id.ed_email);
        passwordTx =  findViewById(R.id.ed_pass);
        linearLayoutSignup =  findViewById(R.id.layoutSignup);
        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = emailTx.getText().toString().trim();
                password = passwordTx.getText().toString().trim();

                if (validateLogin()){
                    Intent intent =  new Intent(Login.this,MainActivity.class);
                    startActivity(intent);
                    finish();

                }


                else {
                    Toast.makeText(Login.this, "correct all the fields and try again", Toast.LENGTH_SHORT).show();
                }


            }
        });

        linearLayoutSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(Login.this,SignUp.class);
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

        return valid;
    }

}

package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText et_email,et_password;
    Button btn_login, btn_register;
    MyDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_email = findViewById(R.id.login_et_email);
        et_password = findViewById(R.id.login_et_password);
        btn_login = findViewById(R.id.login_btn_login);
        btn_register = findViewById(R.id.login_bn_register);

        db= new MyDatabase(this);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = et_email.getText().toString();
                String password = et_password.getText().toString();
                if (password.length()>6) {
                    Toast.makeText(Login.this, "Suacces", Toast.LENGTH_SHORT).show();
//

                Intent intent_next=new Intent(Login.this,MainActivity.class);
                startActivity(intent_next);
                finish();
            }
            else
                    Toast.makeText(Login.this, "أقل من 6", Toast.LENGTH_SHORT).show();
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent_next=new Intent(Login.this,Register.class);
                startActivity(intent_next);
                finish();

            }
        });
    }
}
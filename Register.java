package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    EditText et_name, et_email, et_password;
    Button btn_register;
    MyDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et_email = findViewById(R.id.register_et_email);
        et_name = findViewById(R.id.register_et_name);
        et_password = findViewById(R.id.register_et_password);
        btn_register = findViewById(R.id.register_bn_register);

        db = new MyDatabase(this);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = et_email.getText().toString();
                String name = et_name.getText().toString();
                int password = Integer.parseInt(et_password.getText().toString());

                ACCOUNT account = new ACCOUNT(name, email, password);

                boolean res = db.insert(account);
                if (res) {
                    Toast.makeText(Register.this, "Success ", Toast.LENGTH_SHORT).show();
                    Intent intent_next = new Intent(Register.this, Login.class);
                    startActivity(intent_next);
                    finish();
                } else
                {
                    Toast.makeText(Register.this, "اسم المستخدم وكلمة المرور خاطئة", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
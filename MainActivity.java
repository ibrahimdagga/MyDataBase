package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView tv_name;
    ListView list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_name = findViewById(R.id.main_tv_name);
        list = findViewById(R.id.main_list_view);

        MyDatabase myDatabase = new MyDatabase(MainActivity.this);
        List<ACCOUNT> accountList = myDatabase.getAllNames();

        AdpaterListNames adpaterListNames = new AdpaterListNames(accountList, MainActivity.this);
        if (accountList != null)
            list.setAdapter(adpaterListNames);
        else
            Toast.makeText(this, "لا يوجد اسماء", Toast.LENGTH_SHORT).show();

       ACCOUNT account = (ACCOUNT) adpaterListNames.getItem(0);
       tv_name.setText(account.getName());

    }
}
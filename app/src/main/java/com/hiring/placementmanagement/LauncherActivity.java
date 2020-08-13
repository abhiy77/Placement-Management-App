package com.hiring.placementmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LauncherActivity extends AppCompatActivity {
    Button student_login;
    Button company_login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        student_login = findViewById(R.id.student_login);
        company_login = findViewById(R.id.company_login);

        student_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LauncherActivity.this,StudentLoginActivity.class);
                startActivity(intent);
            }
        });

        company_login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(LauncherActivity.this,CompanyLoginActivity.class);
                startActivity(intent);
            }
        });
    }
}

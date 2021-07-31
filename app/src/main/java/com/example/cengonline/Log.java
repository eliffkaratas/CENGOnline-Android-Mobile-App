package com.example.cengonline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Log extends AppCompatActivity {
    EditText studentıd,studentLogName,studentLogSurname;
    EditText password;

    Button log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

        studentıd = findViewById(R.id.editstudent);
        password = findViewById(R.id.editpassword);
        studentLogName= findViewById(R.id.studentLogName);
        studentLogSurname= findViewById(R.id.studentLogSurname);

        log = findViewById(R.id.editlog);

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x = studentıd.getText().toString();
                String y = password.getText().toString();
                String z = studentLogName.getText().toString();
                String w = studentLogSurname.getText().toString();


                if (TextUtils.isEmpty(x)) {
                    Toast.makeText(Log.this, "Error. Enter the student ID.", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(y)) {
                    Toast.makeText(Log.this, "Error. Enter the password.", Toast.LENGTH_SHORT).show();
                } else {
                    Databasehelper databasehelper = new Databasehelper(Log.this);
                    boolean success = databasehelper.searchlogStudent(x);
                    if (success == false) {
                        Intent intent = new Intent(Log.this,Student_Menu.class);
                        String ıd = x;
                        String ıd2=z;
                        String ıd3=w;
                        intent.putExtra("ClickedCourse",ıd);
                        intent.putExtra("ClickedCourse2",ıd2);
                        intent.putExtra("ClickedCourse3",ıd3);
                        startActivity(intent);
                    } else {
                        Toast.makeText(Log.this, "There is no student with this ID.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
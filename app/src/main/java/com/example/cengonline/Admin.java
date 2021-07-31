package com.example.cengonline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Admin extends AppCompatActivity {
    Button teacher,student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        teacher=findViewById(R.id.teacher);
        student=findViewById(R.id.student);

        teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTeacher();
            }
        });
        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStudent();
            }
        });
    }

    public void openTeacher(){
        Intent intent = new Intent(this,Teacher_Page.class);
        startActivity(intent);
    }
    public void openStudent(){
        Intent intent = new Intent(this,StudentPage.class);
        startActivity(intent);
    }
}
package com.example.cengonline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Teacher_Login extends AppCompatActivity {
    EditText teacherıd,password,teacherLogName,teacherLogSurname;
    Button log_teacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher__login);

        teacherıd=findViewById(R.id.teacher_ıd);
        password=findViewById(R.id.teacher_password);
        teacherLogName=findViewById(R.id.teacherLogName);
        teacherLogSurname=findViewById(R.id.teacherLogSurname);
        log_teacher=findViewById(R.id.log_teacher);

        log_teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x = teacherıd.getText().toString();
                String y = password.getText().toString();
                String w = teacherLogName.getText().toString();
                String a = teacherLogSurname.getText().toString();


                if (TextUtils.isEmpty(x)){
                    Toast.makeText(Teacher_Login.this,"Error. Enter the teacher ID.",Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(y)){
                    Toast.makeText(Teacher_Login.this,"Error. Enter the password.",Toast.LENGTH_SHORT).show();
                }
                else{
                    Databasehelper databasehelper=new Databasehelper(Teacher_Login.this);
                    boolean success = databasehelper.searchlogteacher(x);
                    if (success==false){
                        Intent intent = new Intent(Teacher_Login.this,teachermenu.class);
                        String ıd = x;
                        String ıd2= w;
                        String ıd3 = a;
                        intent.putExtra("ClickedCourse",ıd);
                        intent.putExtra("ClickedCourse2",ıd2);
                        intent.putExtra("ClickedCourse3",ıd3);
                        startActivity(intent);

                    }
                    else
                    {
                        Toast.makeText(Teacher_Login.this,"There is no teacher with this ID.",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
    public void TeacherMenu(){
        Intent intent = new Intent(this,teachermenu.class);
        startActivity(intent);
    }
}
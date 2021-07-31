package com.example.cengonline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button admin,login_teacher,login_student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        admin=(Button)findViewById(R.id.btn_admin);
        login_teacher=(Button)findViewById(R.id.btn_teacher);
        login_student=(Button)findViewById(R.id.btn_student);

        admin.setOnClickListener(new Clik());
        login_teacher.setOnClickListener(new Clik());
        login_student.setOnClickListener(new Clik());

    }
    public class Clik implements View.OnClickListener{

            //CRTL + O
            @Override
            public void onClick(View v) {

                switch (v.getId()){
                    case R.id.btn_admin:
                        openAdmin();
                        break;
                    case R.id.btn_teacher:
                       openLoginTeacher();
                        break;
                    case R.id.btn_student:
                        openLoginStudent();
                        break;
                    default:
                }
            }
        }

        /*
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAdmin();
            }
        });
        login_teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLoginTeacher();
            }
        });
        login_student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLoginStudent();
            }
        });

         */

    public void openAdmin(){
        Intent intent = new Intent(this,Admin.class);
        startActivity(intent);
    }
    public void openLoginTeacher(){
        Intent intent = new Intent(this,Teacher_Login.class);
        startActivity(intent);
    }
    public void openLoginStudent(){
        Intent intent = new Intent(this,Log.class);
        startActivity(intent);
    }
}
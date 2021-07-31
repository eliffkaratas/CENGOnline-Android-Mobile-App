package com.example.cengonline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Teacher_Page extends AppCompatActivity {
    EditText teacher_name;
    EditText teacher_surname;

    Button add_teacher,list_teacher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher__page);
        teacher_name=findViewById(R.id.txt_teacher_name);
        teacher_surname=findViewById(R.id.txt_teacher_surname);

        list_teacher=findViewById(R.id.list_teacher);
        add_teacher=findViewById(R.id.add_teacher);

        add_teacher.setOnClickListener(new View.OnClickListener() {
            Teacher teacher = null;
            @Override
            public void onClick(View v) {
                String x = teacher_name.getText().toString();
                String y = teacher_surname.getText().toString();


                if (TextUtils.isEmpty(x)){
                    Toast.makeText(Teacher_Page.this,"Error. Enter the name.",Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(y)){
                    Toast.makeText(Teacher_Page.this,"Error. Enter the surname.",Toast.LENGTH_SHORT).show();
                }
                else{
                    try {
                        teacher = new Teacher(-1,teacher_name.getText().toString(),teacher_surname.getText().toString());
                        Toast.makeText(Teacher_Page.this,teacher.toString(),Toast.LENGTH_SHORT).show();
                    }
                    catch (Exception e){
                        Toast.makeText(Teacher_Page.this,"Error.",Toast.LENGTH_SHORT).show();
                    }
                    Databasehelper databaseHelper = new Databasehelper(Teacher_Page.this);
                    boolean success = databaseHelper.addTeacher(teacher);
                    Toast.makeText(Teacher_Page.this,"Adding successful.",Toast.LENGTH_SHORT).show();
                    teacher_name.setText("");
                    teacher_surname.setText("");

                }
            }
        });
        list_teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTeacher_List();
            }
        });
    }
    public void openTeacher_List(){
        Intent intent = new Intent(this,List_Teacher.class);
        startActivity(intent);
    }
}
package com.example.cengonline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StudentPage extends AppCompatActivity {
    EditText student_name,student_surname;
    Button add_student,list_student;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_page);

        student_name=findViewById(R.id.txt_student_name);
        student_surname=findViewById(R.id.txt_student_surname);

        add_student=findViewById(R.id.add_student);
        list_student=findViewById(R.id.list_student);
        list_student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListStudent();
            }
        });

        add_student.setOnClickListener(new View.OnClickListener() {
            Student student = null;
            @Override
            public void onClick(View v) {
                String x = student_name.getText().toString();
                String y = student_surname.getText().toString();

                if (TextUtils.isEmpty(x)){
                    Toast.makeText(StudentPage.this,"Error. Enter the name.",Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(y)){
                    Toast.makeText(StudentPage.this,"Error. Enter the surname.",Toast.LENGTH_SHORT).show();
                }
                else{
                    try {
                        student = new Student(-1,student_name.getText().toString(),student_surname.getText().toString());
                        Toast.makeText(StudentPage.this,student.toString(),Toast.LENGTH_SHORT).show();
                    }
                    catch (Exception e){
                        Toast.makeText(StudentPage.this,"Error.",Toast.LENGTH_SHORT).show();
                    }
                  Databasehelper databaseHelper = new Databasehelper(StudentPage.this);
                    boolean success = databaseHelper.addStudent(student);
                    Toast.makeText(StudentPage.this,"Adding successful.",Toast.LENGTH_SHORT).show();
                    student_name.setText("");
                    student_surname.setText("");

                }
            }
        });
    }

    public void ListStudent(){
        Intent intent = new Intent(this,List_Student.class);
        startActivity(intent);
    }
}
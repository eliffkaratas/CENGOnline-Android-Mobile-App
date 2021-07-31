package com.example.cengonline;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Course extends AppCompatActivity {
    EditText coursename,student1,student2,student3,courseıd;
    Button add,delete,edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        coursename=findViewById(R.id.course_name);
        student1=findViewById(R.id.student1);
        student2=findViewById(R.id.student2);
        student3=findViewById(R.id.student3);
        courseıd=findViewById(R.id.course_deleteıd);

        add=findViewById(R.id.course_add);
        delete=findViewById(R.id.course_delet);
        edit=findViewById(R.id.course_edit);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x = coursename.getText().toString();
                String y = student1.getText().toString();
                String z = student2.getText().toString();
                String w = student3.getText().toString();

                if (TextUtils.isEmpty(x)){
                    Toast.makeText(Course.this,"Error. Enter the course name.",Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(y)){
                    Toast.makeText(Course.this,"Error. Enter the first student ID.",Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(z)){
                    Toast.makeText(Course.this,"Error. Enter the second student ID.",Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(w)){
                    Toast.makeText(Course.this,"Error. Enter the third student ID.",Toast.LENGTH_SHORT).show();
                }
                else{
                    Databasehelper databaseHelper = new Databasehelper(Course.this);
                    boolean success =databaseHelper.addCourse(x,y,z,w);
                    Toast.makeText(Course.this,"Adding course successful.",Toast.LENGTH_SHORT).show();
                    coursename.setText("");
                    student1.setText("");
                    student2.setText("");
                    student3.setText("");

                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x = courseıd.getText().toString();
                int  delete  = Integer.parseInt (x);

                if (TextUtils.isEmpty(x)){
                    Toast.makeText(Course.this,"Error. Enter the course ID.",Toast.LENGTH_SHORT).show();
                }else {
                    Databasehelper databasehelper=new Databasehelper(Course.this);
                    Boolean succes = databasehelper.deleteCourse(delete);
                    if (succes==false){
                        Toast.makeText(Course.this,"Deleting course successful.",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(Course.this,"Deleting course not successful.",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x = coursename.getText().toString();
                String y = student1.getText().toString();
                String z = student2.getText().toString();
                String w = student3.getText().toString();
                String a= courseıd.getText().toString();

                if (TextUtils.isEmpty(x)){
                    Toast.makeText(Course.this,"Error. Enter the course name.",Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(y)){
                    Toast.makeText(Course.this,"Error. Enter the first student ID.",Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(z)){
                    Toast.makeText(Course.this,"Error. Enter the second student ID.",Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(w)){
                    Toast.makeText(Course.this,"Error. Enter the third student ID.",Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(a)){
                    Toast.makeText(Course.this,"Error. Enter the course ID.",Toast.LENGTH_SHORT).show();
                }
                else{

                    Databasehelper databaseHelper = new Databasehelper(Course.this);
                    boolean success =databaseHelper.updatecourse(a,x,y,z,w);
                    Toast.makeText(Course.this,"Editing course successful.",Toast.LENGTH_SHORT).show();
                    coursename.setText("");
                    student1.setText("");
                    student2.setText("");
                    student3.setText("");
                }
            }
        });
    }
}
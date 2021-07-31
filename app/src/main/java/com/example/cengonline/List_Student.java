package com.example.cengonline;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class List_Student extends AppCompatActivity {
    ListView list_student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list__student);
        list_student=findViewById(R.id.list_student);
        final Databasehelper databaseHelper=new Databasehelper(List_Student.this);
        final List<Student> everyone=databaseHelper.geteveryone();

        final ArrayAdapter studentArrayAdapter = new ArrayAdapter<Student>(List_Student.this,android.R.layout.simple_list_item_1,everyone);
        list_student.setAdapter(studentArrayAdapter);








    }
}
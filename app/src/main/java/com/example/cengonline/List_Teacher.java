package com.example.cengonline;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class List_Teacher extends AppCompatActivity {
    ListView list_teacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list__teacher);
        list_teacher=findViewById(R.id.list_teacher);
        final Databasehelper databaseHelper=new Databasehelper(List_Teacher.this);
        final List<Teacher> everyone=databaseHelper.geteveryone2();
        final ArrayAdapter teacherArrayAdapter = new ArrayAdapter<Teacher>(List_Teacher.this,android.R.layout.simple_list_item_1,everyone);
        list_teacher.setAdapter(teacherArrayAdapter);
    }
}
package com.example.cengonline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Student_Menu extends AppCompatActivity {
    Button message;
    ListView listView1,listView2;
    TextView textView1,textView2,textView3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__menu);

        message=findViewById(R.id.btn_message);
        listView1=findViewById(R.id.courselistviewwww);
        textView1=findViewById(R.id.textView3);
        textView2=findViewById(R.id.textView33);
        textView3=findViewById(R.id.textView39);

        String Temp=getIntent().getStringExtra("ClickedCourse");
        textView1.setText(Temp);

        String Temp2=getIntent().getStringExtra("ClickedCourse2");
        textView2.setText(Temp2);

        String Temp3=getIntent().getStringExtra("ClickedCourse3");
        textView3.setText(Temp3);

        final  String x = Temp ;
        final  String y = Temp2 ;
        final  String z = Temp3 ;


        final Databasehelper databaseHelper=new Databasehelper(Student_Menu.this);
         List<String> everyone=databaseHelper.StudentCourseListele1(Temp);
         List<String>everyone2=databaseHelper.StudentCourseListele2(Temp);
         List<String>everyone3=databaseHelper.StudentCourseListele3(Temp);

         final List<String> everyone4 = new ArrayList<String>();
        for (int i=0;i<everyone.size();i++){
            everyone4.add(everyone.get(i));
        }
        for (int i=0;i<everyone2.size();i++){
            everyone4.add(everyone2.get(i));
        }
        for (int i=0;i<everyone3.size();i++){
            everyone4.add(everyone3.get(i));
        }

        final ArrayAdapter studentcourseadapter = new ArrayAdapter<String>(Student_Menu.this,android.R.layout.simple_list_item_1,everyone4);
        listView1.setAdapter(studentcourseadapter);


        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final int which_item = position;
                String templistview = everyone4.get(which_item).toString();
                String ıd = templistview.substring(11,12);
                Intent intent = new Intent(Student_Menu.this,Assigment_List.class);
                intent.putExtra("ClickedCourse2",ıd);
                startActivity(intent);
            }
        });


        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Student_Menu.this,MessageStudent.class);
                String ıd = x;
                String ıd2=y;
                String ıd3=z;
                intent.putExtra("ClickedCourse",ıd);
                intent.putExtra("ClickedCourse2",ıd2);
                intent.putExtra("ClickedCourse3",ıd3);
                startActivity(intent);
            }
        });
    }
}
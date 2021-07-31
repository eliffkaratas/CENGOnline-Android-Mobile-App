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

import java.util.List;

public class teachermenu extends AppCompatActivity {
    Button course,message,submit;
    ListView listview_teacher;
    TextView textView,textView2,textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teachermenu);

        course=findViewById(R.id.button4);
        message = findViewById(R.id.button5);
        submit=findViewById(R.id.button6);
        textView=findViewById(R.id.textView19);
        textView2=findViewById(R.id.textView46);
        textView3=findViewById(R.id.textView48);

        String Temp=getIntent().getStringExtra("ClickedCourse");
        textView.setText(Temp);

        String Temp2=getIntent().getStringExtra("ClickedCourse2");
        textView2.setText(Temp2);

        String Temp3=getIntent().getStringExtra("ClickedCourse3");
        textView3.setText(Temp3);


        final String x = Temp;
        final String x1=Temp2;
        final String x2=Temp3;

        listview_teacher = findViewById(R.id.listview1);
        final Databasehelper databaseHelper=new Databasehelper(teachermenu.this);
        final List<String> everyone=databaseHelper.CourseListele();

        final ArrayAdapter courseadapter = new ArrayAdapter<String>(teachermenu.this,android.R.layout.simple_list_item_1,everyone);
        listview_teacher.setAdapter(courseadapter);

       listview_teacher.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               final int which_item = position;
                String templistview = everyone.get(which_item).toString();
                String ıd = templistview.substring(11,12);
                Intent intent = new Intent(teachermenu.this,Course_Menu.class);
                intent.putExtra("ClickedCourse",ıd);
                startActivity(intent);
           }
       });
       submit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               submit();
           }
       });
        course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCourse();
            }
        });

        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(teachermenu.this,MessageTeacher.class);
                String ıd = x;
                String ıd2 = x1;
                String ıd3 = x2;
                intent.putExtra("ClickedCourse",ıd);
                intent.putExtra("ClickedCourse2",ıd2);
                intent.putExtra("ClickedCourse3",ıd3);
                startActivity(intent);
            }
        });

    }

    public void openMessageTeacher(){
        Intent intent = new Intent(this,MessageTeacher.class);
        startActivity(intent);
    }

    public void openCourse(){
        Intent intent = new Intent(this,Course.class);
        startActivity(intent);
    }
    public void submit(){
        Intent intent = new Intent(this,Submit_List.class);
        startActivity(intent);
    }
}
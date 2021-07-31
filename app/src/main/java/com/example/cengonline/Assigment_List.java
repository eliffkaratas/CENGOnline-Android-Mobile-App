package com.example.cengonline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class Assigment_List extends AppCompatActivity {
    TextView textView6;
    ListView assignment,announcment,post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assigment__list);

        textView6=findViewById(R.id.textView22);

        assignment=findViewById(R.id.assign);
        announcment=findViewById(R.id.anooooo);
        post=findViewById(R.id.posttttt);

        String Temp=getIntent().getStringExtra("ClickedCourse2");
        textView6.setText(Temp);

        String x = Temp;

        Databasehelper databasehelper = new Databasehelper(Assigment_List.this);
        final List<String> everyone=databasehelper.AssingmentListele(x);

        final ArrayAdapter assingmentttttArrayAdapter = new ArrayAdapter<String>(Assigment_List.this,android.R.layout.simple_list_item_1,everyone);
        assignment.setAdapter(assingmentttttArrayAdapter);

        final List<String> everyone2=databasehelper.AnnoucmentListele(x);

        final ArrayAdapter annooooArrayAdapter = new ArrayAdapter<String>(Assigment_List.this,android.R.layout.simple_list_item_1,everyone2);
        announcment.setAdapter(annooooArrayAdapter);

        final List<String> everyone3=databasehelper.PostListele(x);

        final ArrayAdapter posttttArrayAdapter = new ArrayAdapter<String>(Assigment_List.this,android.R.layout.simple_list_item_1,everyone3);
        post.setAdapter(posttttArrayAdapter);

        assignment.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final int which_item = position;
                String templistview = everyone.get(which_item).toString();
                String ıd = templistview.substring(0,1);
                Intent intent = new Intent(Assigment_List.this,Upload_Assignment.class);
                intent.putExtra("ClickedCourse3",ıd);
                startActivity(intent);
            }
        });
        post.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final int which_item = position;
                String templistview = everyone3.get(which_item).toString();
                String ıd = templistview.substring(9,10);
                Intent intent = new Intent(Assigment_List.this,Post_Comment.class);
                intent.putExtra("ClickedCourse4",ıd);
                startActivity(intent);
            }
        });
    }
}
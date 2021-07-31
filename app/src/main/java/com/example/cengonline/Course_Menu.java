package com.example.cengonline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Course_Menu extends AppCompatActivity {
    private static final String TAG = "string";
    Button post,annoucmnet,assignment;
    ListView listView2,listView3,listView4;
    TextView textView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course__menu);
        post=findViewById(R.id.post);
        annoucmnet=findViewById(R.id.annoucment);
        assignment=findViewById(R.id.Assigment);
        listView2=findViewById(R.id.listview2);
        listView3=findViewById(R.id.listview3);
        listView4=findViewById(R.id.listview4);
        textView1=findViewById(R.id.textView1);
        String Temp=getIntent().getStringExtra("ClickedCourse");
        textView1.setText(Temp);
        final Databasehelper databaseHelper=new Databasehelper(Course_Menu.this);
        final List<String> everyone=databaseHelper.PostListele(Temp);
        final ArrayAdapter postadapter = new ArrayAdapter<String>(Course_Menu.this,android.R.layout.simple_list_item_1,everyone);

        for (String item: everyone) {
            Log.d(TAG, item);
        }

        listView2.setAdapter(postadapter);
        final List<String> everyone2=databaseHelper.AnnoucmentListele(Temp);
        final ArrayAdapter announcmentadapter = new ArrayAdapter<String>(Course_Menu.this,android.R.layout.simple_list_item_1,everyone2);
        listView3.setAdapter(announcmentadapter);
        final List<String> everyone3=databaseHelper.AssingmentListele(Temp);
        final ArrayAdapter assingmentadapter = new ArrayAdapter<String>(Course_Menu.this,android.R.layout.simple_list_item_1,everyone3);
        listView4.setAdapter(assingmentadapter);
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openpost();
            }
        });
        annoucmnet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAnnoucment();
            }
        });
        assignment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAssingment();
            }
        });


        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final int which_item = position;
                String templistview = everyone.get(which_item).toString();
                String ıd = templistview.substring(9,10);
                Intent intent = new Intent(Course_Menu.this,Post_Comment.class);
                intent.putExtra("ClickedCourse4",ıd);
                startActivity(intent);
            }
        });
    }
    public void openpost(){
        Intent intent = new Intent(this,Post.class);
        startActivity(intent);
    }
    public void openAnnoucment(){
        Intent intent=new Intent(this,Announcment.class);
        startActivity(intent);
    }
    public void openAssingment(){
        Intent intent = new Intent(this,Assigment.class);
        startActivity(intent);
    }
}
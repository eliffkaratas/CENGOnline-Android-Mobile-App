package com.example.cengonline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class Post_Comment extends AppCompatActivity {
    TextView textView;
    Button add;
    ListView listviewww;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post__comment);
        textView=findViewById(R.id.postıdddd55);
        add=findViewById(R.id.addcomentttt);
        listviewww=findViewById(R.id.postcomment_list);
        String Temp=getIntent().getStringExtra("ClickedCourse4");
        textView.setText(Temp);
        final Databasehelper databaseHelper=new Databasehelper(Post_Comment.this);
        final List<String> everyone=databaseHelper.PostCommentListele3(Temp);
        final ArrayAdapter postcommentadapter = new ArrayAdapter<String>(Post_Comment.this,android.R.layout.simple_list_item_1,everyone);
        listviewww.setAdapter(postcommentadapter);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addComment();
            }
        });
    }
    public void addComment(){
        Intent intent=new Intent(this,Add_Comment.class);
        startActivity(intent);
    }
}
package com.example.cengonline;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Post extends AppCompatActivity {
    Button add,delete,edit;
    EditText courseıd,postname,postcontent,postıd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        add=findViewById(R.id.post_add);
        delete=findViewById(R.id.post_delete);
        edit =findViewById(R.id.post_edit);
        courseıd=findViewById(R.id.courseıdddd);
        postname=findViewById(R.id.postnameeee);
        postcontent=findViewById(R.id.postcontenttttt);
        postıd=findViewById(R.id.postıddddd);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x = courseıd.getText().toString();
                String y = postname.getText().toString();
                String z = postcontent.getText().toString();
                if (TextUtils.isEmpty(x)){
                    Toast.makeText(Post.this,"Error. Enter the course ID.",Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(y)){
                    Toast.makeText(Post.this,"Error. Enter the post name.",Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(z)){
                    Toast.makeText(Post.this,"Error. Enter the post content.",Toast.LENGTH_SHORT).show();
                }
                else{
                    Databasehelper databaseHelper = new Databasehelper(Post.this);
                    boolean success =databaseHelper.addPost(x,y,z);
                    Toast.makeText(Post.this,"Adding post successful.",Toast.LENGTH_SHORT).show();
                    courseıd.setText("");
                    postname.setText("");
                    postcontent.setText("");
                }
            }
        });
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x = courseıd.getText().toString();
                String y = postname.getText().toString();
                String z = postcontent.getText().toString();
                String w = postıd.getText().toString();
                if (TextUtils.isEmpty(x)){
                    Toast.makeText(Post.this,"Error. Enter the course ID.",Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(y)){
                    Toast.makeText(Post.this,"Error. Enter the post name.",Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(z)){
                    Toast.makeText(Post.this,"Error. Enter the post content.",Toast.LENGTH_SHORT).show();
                }
                else{
                    Databasehelper databaseHelper = new Databasehelper(Post.this);
                    boolean success =databaseHelper.updatePost(w,x,y,z);
                    Toast.makeText(Post.this,"Editing post successful.",Toast.LENGTH_SHORT).show();
                    courseıd.setText("");
                    postname.setText("");
                    postcontent.setText("");
                }
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x = postıd.getText().toString();
                int  delete  = Integer.parseInt (x);

                if (TextUtils.isEmpty(x)){
                    Toast.makeText(Post.this,"Error. Enter the post ID.",Toast.LENGTH_SHORT).show();
                }else {
                    Databasehelper databasehelper=new Databasehelper(Post.this);
                    Boolean succes = databasehelper.deletePost(delete);
                    if (succes==false){
                        Toast.makeText(Post.this,"Deleting post successful.",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(Post.this,"Deleting post not successful.",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
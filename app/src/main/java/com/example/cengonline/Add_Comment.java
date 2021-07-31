package com.example.cengonline;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Add_Comment extends AppCompatActivity {
    EditText x1,y1,z1,w1,a1;
    Button add_commnet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__comment);

        x1=findViewById(R.id.edittext10);
        y1=findViewById(R.id.edittext11);
        z1=findViewById(R.id.edittext12);
        w1=findViewById(R.id.edittext13);
        a1=findViewById(R.id.edittext14);

        add_commnet=findViewById(R.id.add_commentttt);

        add_commnet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x = x1.getText().toString();
                String y = y1.getText().toString();
                String z = z1.getText().toString();
                String w = w1.getText().toString();
                String a = a1.getText().toString();

                if (TextUtils.isEmpty(x)){
                    Toast.makeText(Add_Comment.this,"Error. Enter the course ID.",Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(y)){
                    Toast.makeText(Add_Comment.this,"Error. Enter the post ID.",Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(z)){
                    Toast.makeText(Add_Comment.this,"Error. Enter the post comment.",Toast.LENGTH_SHORT).show();
                }

                else{

                    Databasehelper databaseHelper = new Databasehelper(Add_Comment.this);
                    boolean success =databaseHelper.addPostComment(x,y,z,w,a);
                    Toast.makeText(Add_Comment.this,"Adding comment successful.",Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
}
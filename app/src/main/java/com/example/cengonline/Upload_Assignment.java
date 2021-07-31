package com.example.cengonline;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Upload_Assignment extends AppCompatActivity {
    TextView textView;
    EditText courseıd,assignmentıd,uploadname;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload__assignment);
        courseıd=findViewById(R.id.editText555);
        assignmentıd=findViewById(R.id.editText66);
        uploadname=findViewById(R.id.editText77);
        button=findViewById(R.id.button);
        String Temp=getIntent().getStringExtra("ClickedCourse3");
        textView.setText(Temp);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x = courseıd.getText().toString();
                String y = assignmentıd.getText().toString();
                String z = uploadname.getText().toString();

                if (TextUtils.isEmpty(x)){
                    Toast.makeText(Upload_Assignment.this,"Error. Enter the course ID.",Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(y)){
                    Toast.makeText(Upload_Assignment.this,"Error. Enter the assignment ID.",Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(z)){
                    Toast.makeText(Upload_Assignment.this,"Error. Upload a file.",Toast.LENGTH_SHORT).show();
                }
                else{
                    Databasehelper databaseHelper = new Databasehelper(Upload_Assignment.this);
                    boolean success =databaseHelper.addFile(x,y,z);
                    Toast.makeText(Upload_Assignment.this,"Uploading successful.",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
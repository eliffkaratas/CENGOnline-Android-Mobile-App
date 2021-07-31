package com.example.cengonline;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Announcment extends AppCompatActivity {
    EditText annocourseıd,anno_name,anno_content,anno_ıd;
    Button add,delete,edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcment);

        annocourseıd=findViewById(R.id.edit_courseıd);
        anno_name=findViewById(R.id.announcment_name);
        anno_content=findViewById(R.id.announcment_content);
        anno_ıd=findViewById(R.id.announcmentıd);

        add=findViewById(R.id.anno_add);
        delete=findViewById(R.id.anno_delete);
        edit=findViewById(R.id.anno_edit);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x = annocourseıd.getText().toString();
                String y = anno_name.getText().toString();
                String z = anno_content.getText().toString();

                if (TextUtils.isEmpty(x)){
                    Toast.makeText(Announcment.this,"Error. Enter the course ID.",Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(y)){
                    Toast.makeText(Announcment.this,"Error. Enter the announcement name.",Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(z)){
                    Toast.makeText(Announcment.this,"Error. Enter the announcement content.",Toast.LENGTH_SHORT).show();
                }

                else{
                    Databasehelper databaseHelper = new Databasehelper(Announcment.this);
                    boolean success =databaseHelper.addAnnoucment(x,y,z);
                    Toast.makeText(Announcment.this,"Adding announcement successful.",Toast.LENGTH_SHORT).show();
                   annocourseıd.setText("");
                    anno_name.setText("");
                    anno_content.setText("");
                }
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x = annocourseıd.getText().toString();
                String y = anno_name.getText().toString();
                String z = anno_content.getText().toString();
                String w = anno_ıd.getText().toString();

                if (TextUtils.isEmpty(x)){
                    Toast.makeText(Announcment.this,"Error. Enter the course ID.",Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(y)){
                    Toast.makeText(Announcment.this,"Error. Enter the announcement name.",Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(z)){
                    Toast.makeText(Announcment.this,"Error. Enter the announcement content.",Toast.LENGTH_SHORT).show();
                }
                else{

                    Databasehelper databaseHelper = new Databasehelper(Announcment.this);
                    boolean success =databaseHelper.updateAnnoucment(w,x,y,z);
                    Toast.makeText(Announcment.this,"Editing announcement successful.",Toast.LENGTH_SHORT).show();
                    annocourseıd.setText("");
                    anno_name.setText("");
                    anno_content.setText("");
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x = anno_ıd.getText().toString();
                int  delete  = Integer.parseInt (x);

                if (TextUtils.isEmpty(x)){
                    Toast.makeText(Announcment.this,"Error. Enter the announcement ID.",Toast.LENGTH_SHORT).show();
                }else {
                    Databasehelper databasehelper=new Databasehelper(Announcment.this);
                    Boolean succes = databasehelper.deleteAnnouncment(delete);
                    if (succes==false){
                        Toast.makeText(Announcment.this,"Deleting announcement successful. ",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(Announcment.this,"Deleting announcement not successful.",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}
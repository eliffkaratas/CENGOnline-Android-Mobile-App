package com.example.cengonline;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Assigment extends AppCompatActivity {

    EditText asssing_courseıd,assing_name,assing_content,assing_ıd,deudate;
    Button add,delete,edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assigment);

        asssing_courseıd=findViewById(R.id.assign_courseıd);
        assing_name=findViewById(R.id.assign_name);
        assing_content=findViewById(R.id.assing_content);
        deudate=findViewById(R.id.duedate);
        assing_ıd=findViewById(R.id.assing_ıd);

        add=findViewById(R.id.assing_add);
        delete=findViewById(R.id.assing_delete);
        edit=findViewById(R.id.assing_edit);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x = asssing_courseıd.getText().toString();
                String y = assing_name.getText().toString();
                String z = assing_content.getText().toString();
                String w = deudate.getText().toString();

                if (TextUtils.isEmpty(x)){
                    Toast.makeText(Assigment.this,"Error. enter the course ID.",Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(y)){
                    Toast.makeText(Assigment.this,"Error. Enter the assignment name.",Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(z)){
                    Toast.makeText(Assigment.this,"Error. Enter the assignment content.",Toast.LENGTH_SHORT).show();
                }

                else{

                    Databasehelper databaseHelper = new Databasehelper(Assigment.this);
                    boolean success =databaseHelper.addAssignment(x,y,z,w);
                    Toast.makeText(Assigment.this,"Adding assignmment successful.",Toast.LENGTH_SHORT).show();
                    asssing_courseıd.setText("");
                    assing_name.setText("");
                    assing_content.setText("");
                    deudate.setText(" ");
                }
            }
        });
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x = asssing_courseıd.getText().toString();
                String y = assing_name.getText().toString();
                String z = assing_content.getText().toString();
                String w = deudate.getText().toString();
                String a = assing_ıd.getText().toString();

                if (TextUtils.isEmpty(x)){
                    Toast.makeText(Assigment.this,"Error. Enter the course ID.",Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(y)){
                    Toast.makeText(Assigment.this,"Error. Enter the assignment name.",Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(z)){
                    Toast.makeText(Assigment.this,"Error. Enter the assignment content.",Toast.LENGTH_SHORT).show();
                }

                else{

                    Databasehelper databaseHelper = new Databasehelper(Assigment.this);
                    boolean success =databaseHelper.updateAssingment(a,x,y,z,w);
                    Toast.makeText(Assigment.this,"Editing assignmment successful.",Toast.LENGTH_SHORT).show();
                    asssing_courseıd.setText("");
                    assing_name.setText("");
                    assing_content.setText("");
                    deudate.setText(" ");
                }
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x = assing_ıd.getText().toString();
                int  delete  = Integer.parseInt (x);

                if (TextUtils.isEmpty(x)){
                    Toast.makeText(Assigment.this,"Error. Enter the course ID.",Toast.LENGTH_SHORT).show();
                }else {
                    Databasehelper databasehelper=new Databasehelper(Assigment.this);
                    Boolean succes = databasehelper.deleteAssingment(delete);
                    if (succes==false){
                        Toast.makeText(Assigment.this,"Deleting assignmment successful.",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(Assigment.this,"Deleting assignmment not successful.",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
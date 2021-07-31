package com.example.cengonline;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MessageStudent extends AppCompatActivity {
    TextView textView,textView2,textView3;
    EditText x2,y2,z2,w2,a2,b2;
    Button addmessage;
    ListView studentInbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_student);

        textView=findViewById(R.id.textView35);
        textView2=findViewById(R.id.textView42);
        textView3=findViewById(R.id.textView44);
        x2=findViewById(R.id.receiverTeacherD);
        y2=findViewById(R.id.senderTeacherName);
        z2=findViewById(R.id.senderTeacherSurname);
        w2=findViewById(R.id.receiverTeacherName);
        a2=findViewById(R.id.receiverStudentSurname);
        b2=findViewById(R.id.messageStudentContent);
        studentInbox=findViewById(R.id.studentInbox);

        addmessage=findViewById(R.id.sendTeacherMessageButton);


        final String Temp=getIntent().getStringExtra("ClickedCourse");
        textView.setText(Temp);
        final String Temp2=getIntent().getStringExtra("ClickedCourse2");
        textView2.setText(Temp2);
        final String Temp3=getIntent().getStringExtra("ClickedCourse3");
        textView3.setText(Temp3);



         Databasehelper databaseHelper=new Databasehelper(MessageStudent.this);
        final List<String> everyone5=databaseHelper.SurnameSearch1(Temp3);
        final ArrayAdapter studentttttt = new ArrayAdapter<String>(MessageStudent.this,android.R.layout.simple_list_item_1,everyone5);
        studentInbox.setAdapter(studentttttt);






        addmessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x = x2.getText().toString();
                String y = y2.getText().toString();
                String z = z2.getText().toString();
                String w = w2.getText().toString();
                String a = a2.getText().toString();
                String b = b2.getText().toString();

                if (TextUtils.isEmpty(x)){
                    Toast.makeText(MessageStudent.this,"Error. Enter the receiver ID.",Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(y)){
                    Toast.makeText(MessageStudent.this,"Error. Enter the sender name.",Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(z)){
                    Toast.makeText(MessageStudent.this,"Error. Enter the sender surname.",Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(w)){
                    Toast.makeText(MessageStudent.this,"Error. Enter the receiver name.",Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(a)){
                    Toast.makeText(MessageStudent.this,"Error. Enter the receiver surname.",Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(b)){
                    Toast.makeText(MessageStudent.this,"Error. Enter the message content.",Toast.LENGTH_SHORT).show();
                }
                else{

                    Databasehelper databaseHelper = new Databasehelper(MessageStudent.this);
                    boolean success =databaseHelper.addStudentMessage(x,y,z,w,a,b);
                    Toast.makeText(MessageStudent.this,"Sending message successful.",Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
}
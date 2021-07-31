package com.example.cengonline;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class Submit_List extends AppCompatActivity {
    ListView submitt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit__list);
        submitt=findViewById(R.id.submitttt);
        final Databasehelper databaseHelper=new Databasehelper(Submit_List.this);
        final List<String> everyone=databaseHelper.SubmitListele();
        final ArrayAdapter studentArrayAdapter = new ArrayAdapter<String>(Submit_List.this,android.R.layout.simple_list_item_1,everyone);
        submitt.setAdapter(studentArrayAdapter);
    }
}
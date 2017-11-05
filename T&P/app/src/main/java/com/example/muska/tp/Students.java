package com.example.muska.tp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Students extends AppCompatActivity {

    ListView lv;
    List<String> l=new ArrayList<>();
    DatabaseHelper helper=new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lv=(ListView)findViewById(R.id.list);
        l=helper.getAllContacts();
        ArrayAdapter adapter=new ArrayAdapter(Students.this,android.R.layout.simple_list_item_1,l);

        lv.setAdapter(adapter);


    }

}

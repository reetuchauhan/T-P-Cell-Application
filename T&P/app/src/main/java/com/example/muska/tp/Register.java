package com.example.muska.tp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    EditText rname,remail,runame,rpass,rcpass;
    DatabaseHelper helper=new DatabaseHelper(this);
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
         rname=(EditText)findViewById(R.id.FullName);
         remail=(EditText)findViewById(R.id.Email);
         runame=(EditText)findViewById(R.id.RegisterUsername);
         rpass=(EditText)findViewById(R.id.RegisterPassword);
        rcpass=(EditText)findViewById(R.id.ConfirmPassword);

    }
    public void register(View V)
    {

        String sname= rname.getText().toString();
        String semail= remail.getText().toString();
        String suname= runame.getText().toString();
        String spass= rpass.getText().toString();
        String supass= rcpass.getText().toString();
        if(!spass.equals(supass))
        {
            Toast.makeText(Register.this,"You have not registered",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Contact c= new Contact();
            c.setEmail(semail);
            c.setName(sname);
            c.setPass(spass);
            c.setUname(suname);
            helper.insertContact(c);
            Toast.makeText(this,"Hee",Toast.LENGTH_SHORT).show();
        }


    }

}

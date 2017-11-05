package com.example.muska.tp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper helper=new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void login(View v)
    {
        EditText a= (EditText)findViewById(R.id.RegisterUsername);
        EditText b= (EditText)findViewById(R.id.RegisterPassword);
        String str1=a.getText().toString();
        String str2 = b.getText().toString();
        String password=helper.searchPass(str1);
        if(str2.equals(password))
        {
            Intent i =new Intent(MainActivity.this,TnP.class);
            i.putExtra("Username",str1);
            startActivity(i);
        }
        else
        {
            Toast.makeText(this,"Not registered",Toast.LENGTH_LONG).show();
        }
    }
    public void signUp(View v)
    {
        Intent i=new Intent(MainActivity.this,Register.class);
        startActivity(i);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

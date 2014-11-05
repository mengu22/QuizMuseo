package com.example.quizmuseo;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // llamada a la base de datos
        
        DataBaseManager manager = new DataBaseManager(this);
        
        Button b1 = (Button) findViewById(R.id.Button01);
        Button b2 = (Button) findViewById(R.id.Button02);
        Button b3 = (Button) findViewById(R.id.Button03);
        Button b4 = (Button) findViewById(R.id.Button04);
        
        
        // Boton insertar en la base de datos
        b3.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this, Activity1.class);
               startActivity(intent);
            }});
      
        		
        
           }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

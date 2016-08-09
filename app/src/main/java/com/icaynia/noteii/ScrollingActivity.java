package com.icaynia.noteii;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ScrollingActivity extends AppCompatActivity {
    EditText textContentView;
    Toolbar toolbar;

    String filename = "note.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */



        textContentView = (EditText) findViewById(R.id.textContentView);


        setTitleText("www");
        setContentText(loadmemo());




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
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
        } else if (id == R.id.action_save) {
            savememo();
        }
        return super.onOptionsItemSelected(item);
    }

    public void setTitleText(String text) {
        setTitle(text);
    }

    public void setContentText(String textContent) {
        textContentView.setText(textContent);

    }

    public void savememo() {
        FileManager mFilemnger = new FileManager();


        String str = textContentView.getText().toString().replace(System.getProperty("line.separator"), "\\n");

        mFilemnger.saveFile(filename, str);

        Log.e("Noteii", "File Saved : " + str);
        Toast.makeText(getApplicationContext(), "saved", Toast.LENGTH_SHORT).show();
    }

    public String loadmemo() {
        FileManager mFilemnger = new FileManager();

        return mFilemnger.loadFile(filename).replace("\\n", System.getProperty("line.separator"));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        savememo();
    }
}

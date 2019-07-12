package com.example.macavintarodelquiz4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Activity3 extends AppCompatActivity {

    TextView txtEmail;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        txtEmail = findViewById(R.id.tvEmail);
    }


    public void goPrevious(View v) {
        Intent i = new Intent(this, Activity2.class);
        startActivity(i);
    }

    public void displayExternal(View v) {
        FileInputStream fis = null;
        StringBuffer buffer = new StringBuffer();
        int letter = 0;
        try {
            File file = new File(getExternalFilesDir(null), "user2.txt");
            fis = new FileInputStream(file);
            while ((letter = fis.read()) != -1) {
                buffer.append((char) letter);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //Toast.makeText(this, buffer.toString(), Toast.LENGTH_LONG).show();
        String name, password, str;
        str = buffer.toString();
        name = buffer.toString().substring(0, str.indexOf(","));
        password = str.substring(str.indexOf(",") + 1);
        txtEmail.setText(name);

    }


}

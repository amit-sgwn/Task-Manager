package com.taskmanager.sangwan.taskmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button add,view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add = (Button)findViewById(R.id.button);
        view =(Button)findViewById(R.id.button2);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTask();
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewTask();
            }
        });
    }

    private void viewTask() {
        Intent view = new Intent(MainActivity.this,View_Activity.class);
        startActivity(view);
    }

    private void addTask() {
        Intent in = new Intent(MainActivity.this,Add_Task.class);
        startActivity(in);
    }


}

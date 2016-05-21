package com.taskmanager.sangwan.taskmanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class View_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_);
        DataBase info = new DataBase(this);
        info.open();


    }

}

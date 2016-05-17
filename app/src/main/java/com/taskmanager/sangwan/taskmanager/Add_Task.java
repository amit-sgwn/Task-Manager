package com.taskmanager.sangwan.taskmanager;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Add_Task extends Activity implements View.OnClickListener,RadioGroup.OnCheckedChangeListener{

    public Button btn_save,btn_cancel;
    private RadioGroup priority;
    public RadioButton normal_Priority,high_Priority,low_Priority;
    public CheckBox done_checkbox,not_done_checkbox;
    public EditText id_,subject,data,start_date,end_date;
    public String task_priority;
    Task myTask = new Task();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add__task);
        initialize();
       /* Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/


    }

    private void initialize() {
        btn_save = (Button)findViewById(R.id.button4);
        btn_cancel = (Button)findViewById(R.id.button3);

        done_checkbox = (CheckBox)findViewById(R.id.checkBox);
        not_done_checkbox = (CheckBox)findViewById(R.id.checkBox2);

        id_ = (EditText)findViewById(R.id.editText);
        subject = (EditText)findViewById(R.id.editText2);
        start_date = (EditText)findViewById(R.id.editText3);
        end_date = (EditText)findViewById(R.id.editText4);
        data =(EditText)findViewById(R.id.data) ;
        priority.setOnCheckedChangeListener( this);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myTask.setData(data.getText().toString());
                myTask.setId(id_.getText().toString());
                myTask.setStart_date(start_date.getText().toString());

            }
        });
    }


    @Override
    public void onClick(View v) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.radioButton:
                task_priority="High";
                break;
            case R.id.radioButton2:
                task_priority="Normal";
                break;
            case R.id.radioButton3:
                task_priority="low";
                break;
        }
    }
}

package com.taskmanager.sangwan.taskmanager;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Add_Task extends Activity implements View.OnClickListener,RadioGroup.OnCheckedChangeListener{

    public Button btn_save,btn_cancel;
    private RadioGroup priority;
    public RadioButton normal_Priority,high_Priority,low_Priority;
    public CheckBox done_checkbox,not_done_checkbox;
    public EditText id_,subject,data,start_date,end_date;
    public String task_priority="Normal";
    Task myTask = new Task();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add__task);
        btn_save = (Button)findViewById(R.id.button4);
        btn_cancel = (Button)findViewById(R.id.button3);

        done_checkbox = (CheckBox)findViewById(R.id.checkBox);
        not_done_checkbox = (CheckBox)findViewById(R.id.checkBox2);

        id_ = (EditText)findViewById(R.id.editText);
        subject = (EditText)findViewById(R.id.editText2);
        start_date = (EditText)findViewById(R.id.editText3);
        end_date = (EditText)findViewById(R.id.editText4);
        data =(EditText)findViewById(R.id.data) ;
        priority =(RadioGroup)findViewById(R.id.radioGroup);
        priority.setOnCheckedChangeListener( this);
        AddListenerRadioGroup();
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myTask =setData(myTask);
                boolean done=true;
                try{
                    DataBase entry = new DataBase(Add_Task.this);
                    entry.open();
                    entry.createEntry(myTask);
                    entry.close();
                }catch (Exception e){
                    done =false;
                }
                finally {
                    if(done){
                        Dialog d = new Dialog(Add_Task.this);
                        d.setTitle("Heck yea!");
                        TextView tv = new TextView(Add_Task.this);
                        tv.setText("Success");
                        d.setContentView(tv);
                        d.show();
                    }
                    else{
                        Dialog d = new Dialog(Add_Task.this);
                        d.setTitle("Hell NO!");
                        TextView tv = new TextView(Add_Task.this);
                        tv.setText("Failed");
                        d.setContentView(tv);
                        d.show();
                    }
                }
            }
        });
    }

    private void AddListenerRadioGroup() {

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button4:

                break;
            case R.id.button3:

        }
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
    private Task setData(final Task myTask){
        myTask.setData(data.getText().toString());
        myTask.setStart_date(start_date.getText().toString());
        myTask.setEnd_date(end_date.getText().toString());
        myTask.setSubject(subject.getText().toString());
        myTask.setPriority(task_priority);
        done_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    myTask.setStatus("Done");
                }
            }
        });
        return myTask;
    }
}

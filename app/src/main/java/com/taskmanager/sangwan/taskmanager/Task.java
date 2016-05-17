package com.taskmanager.sangwan.taskmanager;

/**
 * Created by Amit Sangwan on 14-05-2016.
 */
public class Task {
    private int id;
    private String data;
    private String subject;
    private String start_date;
    private String end_date;
    private String status;
    private String priority;

    public Task(int id, String data, String sub, String start_date, String end_date, String status, String priority) {

        this.data = data;
        subject = sub;
        this.start_date = start_date;
        this.end_date = end_date;
        this.status = status;
        this.priority = priority;
    }
    public Task(){

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

}

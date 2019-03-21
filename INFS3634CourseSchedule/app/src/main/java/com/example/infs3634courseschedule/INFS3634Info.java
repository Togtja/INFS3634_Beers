package com.example.infs3634courseschedule;

import android.app.Activity;

import java.util.ArrayList;
import java.util.Date;

public class INFS3634Info {
    private String name;
    private Date date; //Maybe a String would be better
    private String activity; //These two maybe as an array
    private String topic;    //These two maybe as an array
    private int weekNr;

    public INFS3634Info(String name, Date date, String activity, String topic, int weekNr){
        this.name = name;
        this.date = date;
        this.activity = activity;
        this.topic = topic;
        this.weekNr = weekNr;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }
    public void setActivity(String activity){
        this.activity = activity;
    }
    public String getActivity() {
        return activity;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }

    public void setWeekNr(int weekNr) {
        this.weekNr = weekNr;
    }

    public int getWeekNr() {
        return weekNr;
    }

    public static ArrayList<INFS3634Info> getSchedule(){
        ArrayList<INFS3634Info> schedule = new ArrayList<>();
        schedule.add(new INFS3634Info("unknown", new Date("2019-02-18"),"Lecture","Introduction & Android Fundamentals", 1));
        schedule.add(new INFS3634Info("unknown", new Date("2019-02-18"),"Lab","Android Studio, Git & App basics", 1));
        schedule.add(new INFS3634Info("unknown", new Date("2019-02-25"),"Lecture","Activities, Lifecycle & Intents", 2));
        schedule.add(new INFS3634Info("unknown", new Date("2019-02-25"),"Lab","Activities & Intents", 2));
        schedule.add(new INFS3634Info("unknown", new Date("2019-03-04"),"Lecture","Layouts & UI", 3));
        schedule.add(new INFS3634Info("unknown", new Date("2019-03-04"),"Lab","Designing a UI", 3));
        schedule.add(new INFS3634Info("unknown", new Date("2019-03-11"),"Lecture","Lists & Adapters", 4));
        schedule.add(new INFS3634Info("unknown", new Date("2019-03-11"),"Lab","Displaying Items in a List", 4));
        schedule.add(new INFS3634Info("unknown", new Date("2019-03-18"),"Lecture","Fragments & Multi-layout Apps", 5));
        schedule.add(new INFS3634Info("unknown", new Date("2019-03-18"),"Lab","Fragments for Multi-layout Apps", 5));
        schedule.add(new INFS3634Info("unknown", new Date("2019-03-25"),"Lecture","APIs, Permissions & Libraries", 6));
        schedule.add(new INFS3634Info("unknown", new Date("2019-03-25"),"Lab","APIs & JSON", 6));
        schedule.add(new INFS3634Info("unknown", new Date("2019-04-01"),"Lecture","Networking", 7));
        schedule.add(new INFS3634Info("unknown", new Date("2019-04-01"),"Lab","Networking", 7));
        schedule.add(new INFS3634Info("unknown", new Date("2019-04-08"),"Lecture","Threads & Async Tasks", 8));
        schedule.add(new INFS3634Info("unknown", new Date("2019-04-08"),"Lab","Async Tasks", 7));
        schedule.add(new INFS3634Info("unknown", new Date("2019-04-15"),"Lecture","Data Saving", 9));
        schedule.add(new INFS3634Info("unknown", new Date("2019-04-15"),"Lab","Database", 9));
        schedule.add(new INFS3634Info("unknown", new Date("2019-04-22"),"Lecture","Outlook & Course Summary", 10));
        schedule.add(new INFS3634Info("unknown", new Date("2019-04-22"),"Lab","Revision", 10));


        return schedule;
    }
}

package com.example.infs3634courseschedule;

import android.app.Activity;
import android.util.Pair;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class INFS3634Info implements Serializable {
    private String name;
    private Date date; //Maybe a String would be better
    private ArrayList<Pair> actTop;
    private int weekNr;

    public INFS3634Info(String name, Date date, ArrayList<Pair> actTop, int weekNr){
        this.name = name;
        this.date = date;
        this.actTop = actTop;
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

    public void setActTop(ArrayList<Pair> actTop) {
        this.actTop = actTop;
    }

    public ArrayList<Pair> getActTop() {
        return actTop;
    }

    public void setWeekNr(int weekNr) {
        this.weekNr = weekNr;
    }

    public int getWeekNr() {
        return weekNr;
    }

    public static ArrayList<INFS3634Info> getSchedule() throws ParseException {
        ArrayList<INFS3634Info> schedule = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //Activities and topics for week 1
        ArrayList<Pair> actTop = new ArrayList<>();
        actTop.add(new Pair("Lecture","Introduction & Android Fundamentals"));
        actTop.add(new Pair("Lab", "Android Studio, Git & App basics"));
        schedule.add(new INFS3634Info("unknown", format.parse( "2019-02-18"),actTop, 1));
        //Activities and topics for week 2
        actTop = new ArrayList<>();
        actTop.add(new Pair("Lecture","Activities, Lifecycle & Intents"));
        actTop.add(new Pair("Lab", "Activities & Intents"));
        schedule.add(new INFS3634Info("unknown", format.parse("2019-02-25"),actTop, 2));
        //Activities and topics for week 3
        actTop = new ArrayList<>();
        actTop.add(new Pair("Lecture","Layouts & UI"));
        actTop.add(new Pair("Lab", "Designing a UI"));
        schedule.add(new INFS3634Info("unknown", format.parse("2019-03-04"),actTop, 3));
        //Activities and topics for week 4
        actTop = new ArrayList<>();
        actTop.add(new Pair("Lecture","Lists & Adapters"));
        actTop.add(new Pair("Lab", "Displaying Items in a List"));
        schedule.add(new INFS3634Info("unknown", format.parse("2019-03-11"),actTop, 4));
        //Activities and topics for week 5
        actTop = new ArrayList<>();
        actTop.add(new Pair("Lecture","Fragments & Multi-layout Apps"));
        actTop.add(new Pair("Lab", "Fragments for Multi-layout Apps"));
        schedule.add(new INFS3634Info("unknown", format.parse("2019-03-18"),actTop, 5));
        //Activities and topics for week 6
        actTop = new ArrayList<>();
        actTop.add(new Pair("Lecture","APIs, Permissions & Libraries"));
        actTop.add(new Pair("Lab", "APIs & JSON"));
        schedule.add(new INFS3634Info("unknown", format.parse("2019-03-25"),actTop, 6));
        //Activities and topics for week 7
        actTop = new ArrayList<>();
        actTop.add(new Pair("Lecture","Networking"));
        actTop.add(new Pair("Lab", "Networking"));
        schedule.add(new INFS3634Info("unknown", format.parse("2019-04-01"),actTop, 7));
        //Activities and topics for week 8
        actTop = new ArrayList<>();
        actTop.add(new Pair("Lecture","Threads & Async Tasks"));
        actTop.add(new Pair("Lab", "Async Tasks"));
        schedule.add(new INFS3634Info("unknown", format.parse("2019-04-08"),actTop, 8));
        //Activities and topics for week 9
        actTop = new ArrayList<>();
        actTop.add(new Pair("Lecture","Data Saving"));
        actTop.add(new Pair("Lab", "Database"));
        schedule.add(new INFS3634Info("unknown", format.parse("2019-04-15"),actTop, 9));
        //Activities and topics for week 10
        actTop = new ArrayList<>();
        actTop.add(new Pair("Lecture","Outlook & Course Summary"));
        actTop.add(new Pair("Lab", "Revision"));
        schedule.add(new INFS3634Info("unknown", format.parse("2019-04-22"),actTop, 10));

        return schedule;
    }
}

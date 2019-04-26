package com.example.eventreminder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

public class SendInv extends AppCompatActivity {

    ArrayList<Event> e;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        e=getIntent().getParcelableArrayListExtra("e");
        setup();
    }

    void setup(){
        setContentView(R.layout.activity_send_inv);
        final Button mDefinitionsButton = findViewById(R.id.confirm);
        mDefinitionsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                createEvent();
                setup();
            }
        });
        final Button mInterpretationsButton = findViewById(R.id.back);
        mInterpretationsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i= new Intent(SendInv.this,MainActivity.class);
                i.putParcelableArrayListExtra("e",e);
                startActivity(i);
            }
        });
    }


    void createEvent(){
        Log.e("create","start");
        EditText edit=findViewById(R.id.name);
        String n=edit.getText().toString();
        edit=findViewById(R.id.date);
        String d=edit.getText().toString();
        Log.e("create","date start");
        if(d.length()!=10){
            TextView textView =findViewById(R.id.status);
            String text="Invalid date";
            textView.setText(text);
            return;
        }
        int month=Integer.parseInt(d.substring(0,2));
        int day=Integer.parseInt(d.substring(3,5));
        int year=Integer.parseInt(d.substring(6));
        if(month<1||month>12){
            TextView textView =findViewById(R.id.status);
            String text="Invalid date";
            textView.setText(text);
            return;
        }
        if(month==9||month==4||month==6||month==11) {
            if (day < 1 || day > 30) {
                TextView textView =findViewById(R.id.status);
                String text="Invalid date";
                textView.setText(text);
                return;
            }
        }
        else{
            if(day<1||day>31){
                TextView textView =findViewById(R.id.status);
                String text="Invalid date";
                textView.setText(text);
                return;
            }
        }
        if(year<2019){
            TextView textView =findViewById(R.id.status);
            String text="Invalid date";
            textView.setText(text);
            return;
        }
        Log.e("create","date end");
        edit=findViewById(R.id.time);
        String t=edit.getText().toString();
        Log.e("create","time start");
        if(t.length()!=5){
            TextView textView =findViewById(R.id.status);
            String text="Invalid time";
            textView.setText(text);
            return;
        }
        int hour=Integer.parseInt(t.substring(0,2));
        int minute=Integer.parseInt(t.substring(3));
        if(hour<0||hour>24){
            TextView textView =findViewById(R.id.status);
            String text="Invalid time";
            textView.setText(text);
            return;
        }
        if(minute<0||minute>59){
            TextView textView =findViewById(R.id.status);
            String text="Invalid time";
            textView.setText(text);
            return;
        }
        Log.e("create","time end");
        Date date=new Date(year,month,day,hour,minute);
        e.add(new Event(n,date));
        TextView textView =findViewById(R.id.status);
        String text="New Event Created";
        textView.setText(text);
        Log.e("create","finish");
    }
}

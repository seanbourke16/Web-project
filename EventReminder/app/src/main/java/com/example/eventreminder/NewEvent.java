package com.example.eventreminder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

public class NewEvent extends AppCompatActivity {

    ArrayList<Event> e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event);
        e=getIntent().getParcelableArrayListExtra("e");
        final Button mDefinitionsButton = findViewById(R.id.confirm);
        mDefinitionsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                createEvent();
                setContentView(R.layout.activity_new_event);
            }
        });
        final Button mInterpretationsButton = findViewById(R.id.back);
        mInterpretationsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i= new Intent(NewEvent.this,MainActivity.class);
                i.putParcelableArrayListExtra("e",e);
                startActivity(i);
            }
        });
    }

    void fail(){

    }

    void createEvent(){
        EditText edit=findViewById(R.id.name);
        String n=edit.getText().toString();
        edit=findViewById(R.id.date);
        String d=edit.getText().toString();
        if(d.length()!=8){
            fail();
            return;
        }
        int month=Integer.parseInt(d.substring(0,2));
        int day=Integer.parseInt(d.substring(2,4));
        int year=Integer.parseInt(d.substring(4));
        if(month<1||month>12){
            fail();
            return;
        }
        if(month==9||month==4||month==6||month==11) {
            if (day < 1 || day > 30) {
                fail();
                return;
            }
        }
        else{
            if(day<1||day>31){
                fail();
                return;
            }
        }
        if(year<2019){
            fail();
            return;
        }
        edit=findViewById(R.id.time);
        String t=edit.getText().toString();
        if(t.length()!=5){
            fail();
            return;
        }
        int hour=Integer.parseInt(d.substring(0,2));
        int minute=Integer.parseInt(d.substring(3));
        if(hour<0||hour>24){
            fail();
            return;
        }
        if(minute<0||minute>59){
            TextView textView =findViewById(R.id.status);
            textView.setText("@string/status3");
            return;
        }
        Date date=new Date(year,month,day,hour,minute);
        e.add(new Event(n,date));
        TextView textView =findViewById(R.id.status);
        textView.setText("@string/status");

    }
}

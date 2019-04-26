package com.example.eventreminder;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    ArrayList<Event> e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(e==null)e=new ArrayList<>();
        if(getIntent().getParcelableArrayListExtra("e")!=null)e=getIntent().getParcelableArrayListExtra("e");
        nextEvent();
        final Button mDefinitionsButton = findViewById(R.id.newEvent);
        mDefinitionsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i= new Intent(MainActivity.this,NewEvent.class);
                i.putParcelableArrayListExtra("e",e);
                startActivity(i);
            }
        });
        final Button mInterpretationsButton = findViewById(R.id.checkEvents);
        mInterpretationsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i= new Intent(MainActivity.this,CheckEvents.class);
                i.putParcelableArrayListExtra("e",e);
                startActivity(i);
            }
        });
        final Button mManagementButton = findViewById(R.id.sendInv);
        mManagementButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i= new Intent(MainActivity.this,SendInv.class);
                i.putParcelableArrayListExtra("e",e);
                startActivity(i);
            }
        });

    }

    void nextEvent(){
        if(e.size()==0){
            TextView textView = findViewById(R.id.next);
            String text="No upcoming events";
            textView.setText(text);
            //setContentView(R.layout.activity_main);
            return;
        }
        Event ret=e.get(0);
        Date date = Calendar.getInstance().getTime();
        for(int x=1;x<e.size();x++){
            if(compareDates(date,e.get(x).date)==-1&&compareDates(ret.date,e.get(x).date)==1)ret=e.get(x);
        }
        TextView textView = findViewById(R.id.next);
        String text=ret.name+" at "+ret.date;
        textView.setText(text);
        //setContentView(R.layout.activity_main);
    }

    int compareDates(Date d1, Date d2){
        if(d1.getYear()>d2.getYear()){
            return 1;
        }
        if(d1.getYear()<d2.getYear()){
            return -1;
        }
        if(d1.getMonth()>d2.getMonth()){
            return 1;
        }
        if(d1.getMonth()<d2.getMonth()){
            return -1;
        }
        if(d1.getDate()>d2.getDate()){
            return 1;
        }
        if(d1.getDate()<d2.getDate()){
            return -1;
        }
        if(d1.getHours()>d2.getHours()){
            return 1;
        }
        if(d1.getHours()<d2.getHours()){
            return -1;
        }
        if(d1.getMinutes()>d2.getMinutes()){
            return 1;
        }
        if(d1.getMinutes()<d2.getMinutes()){
            return -1;
        }
        return 0;
    }
}

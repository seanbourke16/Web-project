package com.example.eventreminder;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Event> e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
}

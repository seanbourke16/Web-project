package com.example.eventreminder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button mDefinitionsButton = findViewById(R.id.newEvent);
        mDefinitionsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NewEvent.class));
            }
        });
        final Button mInterpretationsButton = findViewById(R.id.checkEvents);
        mInterpretationsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CheckEvents.class));
            }
        });
        final Button mManagementButton = findViewById(R.id.sendInv);
        mManagementButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SendInv.class));
            }
        });
    }
}

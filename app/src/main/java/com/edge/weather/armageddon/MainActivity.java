package com.edge.weather.armageddon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button buttonCreateRoomActivity, buttonReferenceActivity;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonReferenceActivity = (Button) findViewById(R.id.buttonReferenceActivity);
        buttonCreateRoomActivity = (Button) findViewById(R.id.buttonCreateRoomActivity);
        buttonCreateRoomActivity.setOnClickListener(this);
        buttonReferenceActivity.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonCreateRoomActivity:
                intent=new Intent(MainActivity.this,CreateRoomActivity.class);
                startActivity(intent);
                break;

            case R.id.buttonReferenceActivity:
                intent=new Intent(MainActivity.this,LookupGroupActivity.class);
                startActivity(intent);
                break;
        }
    }
}

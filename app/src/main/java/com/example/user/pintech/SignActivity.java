package com.example.user.pintech;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class SignActivity extends AppCompatActivity{

    CheckBox option1,option2;
    TextView textview1, textview2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        option1 = (CheckBox) findViewById(R.id.option1);
        option2 = (CheckBox) findViewById(R.id.option2);

        textview1 = (TextView) findViewById(R.id.textview1);
        textview2 = (TextView) findViewById(R.id.textview2);

        textview1.setMovementMethod(new ScrollingMovementMethod());
        textview2.setMovementMethod(new ScrollingMovementMethod());

        Button btnOk = (Button) findViewById(R.id.OK);
        btnOk.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                /*
                Toast.makeText(
                        SignActivity.this,
                        (CharSequence) ("Option1 = " + option1.isChecked()
                                + ", " + "Option2 = " + option2.isChecked()),
                        Toast.LENGTH_LONG).show();*/
                Intent intent = new Intent(getApplicationContext(),SignPadActivity.class);
                startActivity(intent);
            }

        });

    }
}

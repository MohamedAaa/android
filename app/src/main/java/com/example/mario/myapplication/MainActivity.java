package com.example.mario.myapplication;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URI;
import java.net.URL;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1,btn2,second,sendMail;
    TextView textMail,textMsg;
    private static int i =0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textMail = (TextView) findViewById(R.id.txtMail);
        textMsg = (TextView) findViewById(R.id.txtMsg);
        btn1 = (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(this);

        btn2 = (Button) findViewById(R.id.reset);
        // third method useing inner calss variable  .
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 1;
                Toast.makeText(MainActivity.this, "I =" +i, Toast.LENGTH_SHORT).show();
            }
        });

        second  = (Button) findViewById(R.id.second);
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,SecondActivity.class));
            }
        });
        sendMail  = (Button) findViewById(R.id.sendMail);
        sendMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL  , new String[]{textMail.getText().toString()});
                i.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
                i.putExtra(Intent.EXTRA_TEXT   ,textMsg.getText().toString());
                try {
                    startActivity(Intent.createChooser(i, "Send mail"));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(MainActivity.this, "There are no email applications installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d("MSG","orientaion Changes"+Configuration.ORIENTATION_PORTRAIT);
    }
    // SecondActivity method useing impelments onclicklestener inteface
    @Override
    public void onClick(View view) {
            Toast.makeText(this, "I = "+(++i), Toast.LENGTH_SHORT).show();

    }

    /* first method useing onclick in xml file
    public void addNum(View view) {
        if (view.getId() == R.id.button1){
            Toast.makeText(this, "I = "+(++i), Toast.LENGTH_SHORT).show();
        }else{
            i = 0;
            Toast.makeText(this, "I = "+(++i), Toast.LENGTH_SHORT).show();
        }
    }

    */

}

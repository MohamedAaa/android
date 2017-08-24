package com.example.mario.myapplication;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1,btn2,second;
    private static int i =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "OnCreate", Toast.LENGTH_SHORT).show();
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
                Intent i = new Intent(MainActivity.this,second.class);
                startActivity(i);
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();

    }




    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d("MSG","orientaion Changes"+Configuration.ORIENTATION_PORTRAIT);
    }
    // second method useing impelments onclicklestener inteface
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

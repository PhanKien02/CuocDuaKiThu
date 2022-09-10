package com.example.cuocduakithu;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageButton btnplay;
    TextView point;
    CheckBox cb1,cb2,cb3;
    SeekBar sb1,sb2,sb3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        point = (TextView) findViewById(R.id.point);
        cb1 = (CheckBox) findViewById(R.id.checkboxone);
        cb2 = (CheckBox) findViewById(R.id.checkboxtwo);
        cb3 = (CheckBox) findViewById(R.id.checkboxthree);
        sb1 = (SeekBar)  findViewById(R.id.seeknarone);
        sb2 = (SeekBar)  findViewById(R.id.seeknartwo);
        sb3 = (SeekBar)  findViewById(R.id.seeknarthree);
        btnplay = (ImageButton) findViewById(R.id.btnPlay);
        CountDownTimer countDownTimer = new CountDownTimer(60000,300) {
            @Override
            public void onTick(long l) {
                Random random = new Random();
                int one= random.nextInt(5);
                int two= random.nextInt(5);
                int three= random.nextInt(5);
                if (sb1.getProgress() >= sb1.getMax())
                {
                    this.cancel();
                    Toast.makeText(MainActivity.this,"One Win",Toast.LENGTH_LONG).show();
                    btnplay.setVisibility(View.VISIBLE);
                }
                if (sb2.getProgress() >= sb2.getMax())
                {
                    this.cancel();
                    Toast.makeText(MainActivity.this,"TWO Win",Toast.LENGTH_LONG).show();
                    btnplay.setVisibility(View.VISIBLE);
                }
                if (sb3.getProgress() >= sb3.getMax())
                {
                    this.cancel();
                    Toast.makeText(MainActivity.this,"Three Win",Toast.LENGTH_LONG).show();
                    btnplay.setVisibility(View.VISIBLE);
                }
                sb1.setProgress( sb1.getProgress() + one);
                sb2.setProgress( sb2.getProgress() + 5);
                sb2.setProgress( sb3.getProgress() + 5);
            }

            @Override
            public void onFinish() {

            }
        };
        btnplay.setOnClickListener(view -> {
            sb1.setProgress(0);
            sb2.setProgress(0);
            sb3.setProgress(0);
            countDownTimer.start();
            btnplay.setVisibility(View.INVISIBLE);
        });
    }



}
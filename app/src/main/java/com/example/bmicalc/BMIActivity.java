package com.example.bmicalc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.text.method.CharacterPickerDialog;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class BMIActivity extends AppCompatActivity {

    android.widget.Button mrecalculatebmi;

    TextView mbmidisplay,mbmicateogory,mgender;
    Intent intent;
    ImageView mimageview;
    String mbmi;
    float intbmi;

    String height;
    String weight;
    float intheight,intweight;
    RelativeLayout mbackground;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiactivity);
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"white\"></font>"));
        getSupportActionBar().setTitle("Result");
        ColorDrawable colorDrawable=new ColorDrawable(Color.parseColor("#1e1d1d"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);


        intent=getIntent();
        mbmidisplay=findViewById(R.id.bmidisplay);
        mbmicateogory=findViewById(R.id.bmicategory);
        mgender=findViewById(R.id.genderdisplay);
        mbackground=findViewById(R.id.contentlayout);
        mimageview=findViewById(R.id.imageview);
        mrecalculatebmi=findViewById(R.id.recalculatebmi);


        height=intent.getStringExtra("height");
        weight=intent.getStringExtra("weight");

        intheight=Float.parseFloat(height);
        intweight=Float.parseFloat(weight);

        intheight=intheight/100;
        intbmi=intweight/(intheight*intheight);

        mbmi=Float.toString(intbmi);
        System.out.println(mbmi);

        if (intbmi<16)
        {
            mbmicateogory.setText(("Sever thinness"));
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.crosss);
        }
        else if (intbmi<16.9 && intbmi>16)
        {
            mbmicateogory.setText(("Moderate thinness"));
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.warning);
        }
        else if (intbmi<18.4 && intbmi>17)
        {
            mbmicateogory.setText(("Mild thinness"));
            mbackground.setBackgroundColor(Color.YELLOW);
            mimageview.setImageResource(R.drawable.crosss);
        }
        else if (intbmi<25 && intbmi>18.4)
        {
            mbmicateogory.setText(("Normal BMI"));
            //mbackground.setBackgroundColor(Color.Green);
            mimageview.setImageResource(R.drawable.ok);
        }
        else if (intbmi<29.4 && intbmi>25)
        {
            mbmicateogory.setText(("Over weight"));
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.warning);
        }
        else
        {
            mbmicateogory.setText(("Obese"));
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.warning);
        }
        mgender.setText(intent.getStringExtra("gender"));
        mbmidisplay.setText(mbmi);







        mrecalculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iintent=new Intent(BMIActivity.this,MainActivity.class);
                startActivity(iintent);
                finish();
            }
        });
    }
}
package com.ankushinc.thereddragon.helpingshinchan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Round2 extends AppCompatActivity {

    Button onept;
    Button twoPt;
    Button threePt;
    Button fivePt;
    Button Result;
    Button reset;
    Button oneptR;
    Button twoPtR;
    Button threePtR;
    Button fivePtR;
    TextView last;

    final int P1one=1;
    final int P1two=2;
    final int P1three=3;
    final int P1five=5;
    int scoreP1;
    int finalscore1;

    final int P2one=1;
    final int P2two=2;
    final int P2three=3;
    final int P2five=5;
    int scoreP2;
    int finalscore2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round2);

        onept=(Button)findViewById(R.id.onePt);
        twoPt=(Button)findViewById(R.id.TwoPt);
        threePt=(Button)findViewById(R.id.threePt);
        fivePt=(Button)findViewById(R.id.fivePt);

        oneptR=(Button)findViewById(R.id.onePtR);
        twoPtR=(Button)findViewById(R.id.TwoPtR);
        threePtR=(Button)findViewById(R.id.threePtR);
        fivePtR=(Button)findViewById(R.id.fivePtR);

        Result=(Button)findViewById(R.id.Results);
        reset=(Button)findViewById(R.id.reset);

        //now we will form logics



      updateonclick();

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreP1=0;
                scoreP2=0;
                Toast.makeText(getApplicationContext(),"You successfully have reset scores\n"+ scoreP2+" "+scoreP1,Toast.LENGTH_SHORT).show();
            }
        });

        Result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(totalScore1()>totalScore2()){
                    AlertDialog.Builder mBuilder =new AlertDialog.Builder(Round2.this);
                    View mView=getLayoutInflater().inflate(R.layout.finalresult,null);


                    last=(TextView)mView.findViewById(R.id.last);

                    updateTextview(last,totalScore1());

                    mBuilder.setView(mView);
                    AlertDialog dialog=mBuilder.create();
                    dialog.show();
                }

                else{
                    AlertDialog.Builder mBuilder =new AlertDialog.Builder(Round2.this);
                    View mView=getLayoutInflater().inflate(R.layout.finalresult,null);


                    last=(TextView)mView.findViewById(R.id.last);

                    updateTextview2(last,totalScore2());

                    mBuilder.setView(mView);
                    AlertDialog dialog=mBuilder.create();
                    dialog.show();
                }
            }
        });

    }
    void updateonclick(){
        onept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addScore(P1one);
                Toast.makeText(getApplicationContext(),"1 point",Toast.LENGTH_SHORT).show();
            }
        });

        twoPt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addScore(P1two);
                Toast.makeText(getApplicationContext(),"2 points",Toast.LENGTH_SHORT).show();
            }
        });

        threePt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addScore(P1three);
                Toast.makeText(getApplicationContext(),"3 points",Toast.LENGTH_SHORT).show();
            }
        });

        fivePt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addScore(P1five);
                Toast.makeText(getApplicationContext(),"5 points",Toast.LENGTH_SHORT).show();
            }
        });



        oneptR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addScore2(P2one);
                Toast.makeText(getApplicationContext(),"1 point",Toast.LENGTH_SHORT).show();
            }
        });

        twoPtR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addScore2(P2two);
                Toast.makeText(getApplicationContext(),"2 points",Toast.LENGTH_SHORT).show();
            }
        });

        threePtR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addScore2(P2three);
                Toast.makeText(getApplicationContext(),"3 point",Toast.LENGTH_SHORT).show();
            }
        });

        fivePtR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addScore2(P2five);
                Toast.makeText(getApplicationContext(),"5 point",Toast.LENGTH_SHORT).show();
            }
        });

    }


    void updateTextview(TextView view,int score){
        view.setText(String.valueOf(score)+" Winner is Player1");
    }
    void updateTextview2(TextView view,int score){
        view.setText(String.valueOf(score)+" Winner is Player 2");
    }


    void addScore(int score){

        if(score==1){
            this.scoreP1+=1;
        }

        if(score==2){
            this.scoreP1+=2;
        }

        if(score==3){
           this.scoreP1+=3;
        }

        if(score==5){
          this.scoreP1+=5;
        }
    }
    void addScore2(int score){

        if(score==1){
            this.scoreP2+=1;
        }

        if(score==2){
            this.scoreP2+=2;
        }

        if(score==3){
            this.scoreP2+=3;
        }

        if(score==5){
            this.scoreP2+=5;
        }
    }


    int totalScore1(){

        Intent intent=getIntent();

        int x=intent.getIntExtra("Score1",0);

        finalscore1=x+scoreP1;
        return finalscore1;
    }
    int totalScore2(){

        Intent intent=getIntent();

       int x=intent.getIntExtra("Score2",0);



       finalscore2=x+scoreP2;
        return finalscore2;
    }

}

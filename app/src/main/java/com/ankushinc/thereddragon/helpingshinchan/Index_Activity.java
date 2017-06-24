package com.ankushinc.thereddragon.helpingshinchan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Index_Activity extends AppCompatActivity {
    //Okay so our first step will be to intialise all the objects that we have like buttons and variables in this case
    Button onept;
    Button twoPt;
    Button threePt;
    Button fivePt;
    Button nextRound;
    Button reset;
    Button oneptR;
    Button twoPtR;
    Button threePtR;
    Button fivePtR;

    final int P1one=1;
    final int P1two=2;
    final int P1three=3;
    final int P1five=5;
    int scoreP1index=0;

    final int P2one=1;
    final int P2two=2;
    final int P2three=3;
    final int P2five=5;
    int scoreP2index=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index_);

        //The next step is to link the java objects to xml file, We use the R keyword for that. This creates usable objects for xml file in java

        onept=(Button)findViewById(R.id.onePt);
        twoPt=(Button)findViewById(R.id.TwoPt);
        threePt=(Button)findViewById(R.id.threePt);
        fivePt=(Button)findViewById(R.id.fivePt);

        oneptR=(Button)findViewById(R.id.onePtR);
        twoPtR=(Button)findViewById(R.id.TwoPtR);
        threePtR=(Button)findViewById(R.id.threePtR);
        fivePtR=(Button)findViewById(R.id.fivePtR);

        nextRound=(Button)findViewById(R.id.nextRound);
        reset=(Button)findViewById(R.id.reset);

        //now we will form logics



        //this method will be called every time we click any point for any player
        updateonclick();

        //The onclicklistener is an Interface which allows us to modify what happens after we click a button
        //Here I use an annonymous inner class to provide its body
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreP1index=0;
                scoreP2index=0;
                Toast.makeText(getApplicationContext(),"You successfully have reset scores\n"+ scoreP2index+" "+scoreP1index,Toast.LENGTH_SHORT).show();
            }
        });

        nextRound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //intents are used to travel from one activity to the other,below is the shortest method for that
               updateonclick();
                Intent intent=new Intent(Index_Activity.this,Round2.class);

                //we want our current score to go to next activity , we can do that using putExtra which sends extra data to next activity
                intent.putExtra("Score1",scoreP1index);
                intent.putExtra("Score2",scoreP2index);
                startActivity(intent);


            }
        });




    }



    void updateonclick(){
        onept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addScore(P1one);
                //Toasts are simple informative messages which help us know what happened
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


//we are adding scores here, for simplicity I seperated the player1 and player 2 methods
    void addScore(int score){

        if(score==1){
            scoreP1index+=1;
        }

        if(score==2){
            scoreP1index+=2;
        }

        if(score==3){
            scoreP1index+=3;
        }

        if(score==5){
            scoreP1index+=5;
        }
    }
    void addScore2(int score){

        if(score==1){
            scoreP2index+=1;
        }

        if(score==2){
            scoreP2index+=2;
        }

        if(score==3){
            scoreP2index+=3;
        }

        if(score==5){
            scoreP2index+=5;
        }
    }
}

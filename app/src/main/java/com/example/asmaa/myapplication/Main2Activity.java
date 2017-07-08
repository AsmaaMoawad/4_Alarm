package com.example.asmaa.myapplication;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class Main2Activity extends AppCompatActivity {
    MediaPlayer player ;
    int sum=0;
    TextView T1;
    EditText E1;
    Button B1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        player =  MediaPlayer.create(this,R.raw.hugr);
        T1=(TextView)findViewById(R.id.textView);
        E1=(EditText)findViewById(R.id.editText);
        B1=(Button) findViewById(R.id.button);
        run ();


    }



    public class Randomnum {
        Random random = new Random();
        int num1 = random.nextInt(9);
        int num2 = random.nextInt(9);

        public Randomnum(){
            sum = num1 + num2;
        }

        String ShowToUser = String.valueOf(num1).concat("+").concat(String.valueOf(num2));
        public int getsum() {

            return sum;
        }

        public String getShowToUser() {

            return ShowToUser;
        }
    }


    public  void run (){

        final Randomnum Randomnum = new Randomnum();

        T1.setText(Randomnum.getShowToUser());

        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int usersum = Integer.parseInt(E1.getText().toString());
                int Sum = Randomnum.getsum();
                if (usersum == Sum) {
                    player.stop();


                }

                else {
                    player.start();
                    Randomnum Randomnum = new Randomnum();
                    T1.setText(Randomnum.getShowToUser());


                }

            }
        });

    }


}

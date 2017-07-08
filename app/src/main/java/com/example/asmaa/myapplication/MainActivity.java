package com.example.asmaa.myapplication;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;

//import android.icu.util.GregorianCalendar;

//@RequiresApi(api = Build.VERSION_CODES.N)
public class MainActivity extends AppCompatActivity {

    Button button;
    EditText Timetxt;
    EditText Datetxt;
    Calendar now = Calendar.getInstance();
    int yearin= now.get(Calendar.YEAR);
    int hourin= now.get(Calendar.HOUR_OF_DAY);
    int dayin= now.get(Calendar.DAY_OF_MONTH);
    int monthin=now.get(Calendar.MONTH) ;
    int min=now.get(Calendar.MINUTE);








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //final AlarmManager alarm= (AlarmManager) getSystemService(ALARM_SERVICE);



        button=(Button)findViewById(R.id.button);
        Timetxt=(EditText)findViewById(R.id.time);
        Datetxt=(EditText)findViewById(R.id.date);
        Timetxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog tpd=new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Timetxt.setText(hourOfDay + ":" + minute);
                        hourin=hourOfDay;
                        min=minute;



                    }
                },hourin,min,true);
                tpd.setTitle("Set Time");
                tpd.show();
            }


        });

        Datetxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                DatePickerDialog Dpd=new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        Datetxt.setText(dayOfMonth +  "/" + (month+1) + "/" + year  );
                        yearin=year;
                        monthin=month;
                        dayin=dayOfMonth;


                    }
                },yearin,monthin,dayin);
                Dpd.setTitle("Set Date");
                Dpd.show();
            }


        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlarmManager alarm= (AlarmManager) getSystemService(ALARM_SERVICE);

                Intent intent = new Intent(MainActivity.this,Main2Activity.class);

                PendingIntent Pintent = PendingIntent.getActivity(MainActivity.this,0,intent,0);

                Calendar cal= new GregorianCalendar(yearin, monthin, dayin,hourin, min);

                long time = cal.getTimeInMillis();

                alarm.set(AlarmManager.RTC_WAKEUP,time,Pintent);
                Toast.makeText(MainActivity.this, "You Set Alarm ", Toast.LENGTH_SHORT).show();


            }
        });

}












}


















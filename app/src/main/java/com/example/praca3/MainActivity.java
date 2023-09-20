package com.example.praca3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText dateText, timeText;
    ImageButton dateBtn, timeBtn;
    Button applyBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateText = findViewById(R.id.date_txt);
        timeText = findViewById(R.id.time_txt);
        dateBtn = findViewById(R.id.dateBtn);
        timeBtn = findViewById(R.id.timeBtn);
        applyBtn = findViewById(R.id.apply_btn);

        dateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int year = 2021;
                int month = 11;
                int day = 14;

                DatePickerDialog.OnDateSetListener datePick = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

                        dateText.setText(i2+"-"+(i1+1)+"-"+i);

                    }
                };

                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, datePick, year, month, day);
                datePickerDialog.show();



            }
        });

        timeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int hour = 13;
                int minute = 24;
                boolean is24Hours = true;

                TimePickerDialog.OnTimeSetListener timePick = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        timeText.setText(i+":"+i1);
                    }
                };

                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, timePick, hour, minute, is24Hours);
                timePickerDialog.show();

            }
        });

        applyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Подтвержденie").setIcon(R.drawable.baseline_calendar_month_24)
                        .setMessage("Confirm?")
                        .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                                //something doing on button press
                            }
                        })
                        .setNegativeButton("unconfirm", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                                //
                            }
                        })
                        .create();
                builder.show();
            }
        });

    }
}
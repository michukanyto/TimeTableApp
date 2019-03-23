package com.lasalle.timetables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBarTimes;
    ListView listViewTimeTable;
    final int MAX = 99;
    int max = 150;
    int min = 51;
    int current = 100;
    int value = 0;
    ArrayList<Integer> numbers;
    ArrayAdapter<Integer> myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

//    private void initialize() {
//        seekBarTimes = findViewById(R.id.seekBarTime);
//        seekBarTimes.setOnSeekBarChangeListener(this);
//        listViewTimeTable = findViewById(R.id.listViewTimeTables);
//        seekBarTimes.setMax(max);
//        seekBarTimes.setProgress(min);
//        numbers = new ArrayList<>();
//        for(int i = 1; i < 11; i++){
//            numbers.add(i);
//        }
//        myAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,numbers);
//        listViewTimeTable.setAdapter(myAdapter);
//    }
//
//    @Override
//    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//       givenNumber(progress);
//
//    }
//
//
//    @Override
//    public void onStartTrackingTouch(SeekBar seekBar) {
//
//    }
//
//    @Override
//    public void onStopTrackingTouch(SeekBar seekBar) {
//
//    }
//
//    private void givenNumber(int progress) {
//
//        Log.i("--------->",String.valueOf(progress));
//    }


    private void initialize() {
        seekBarTimes = findViewById(R.id.seekBarTime);
        listViewTimeTable = findViewById(R.id.listViewTimeTables);
        seekBarTimes.setMax(10);
        seekBarTimes.setProgress(1);
        numbers = new ArrayList<>();
        for (int i = 1 ; i <= 10; i++){
            numbers.add(i);
        }
        myAdapter = new ArrayAdapter<Integer>(getApplicationContext(), android.R.layout.simple_list_item_1,numbers);
        listViewTimeTable.setAdapter(myAdapter);

        seekBarTimes.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                for (int i = 0 ; i < 10; i++){
                    value = i + 1;
                    numbers.set(i, value * progress);
                }
                myAdapter = new ArrayAdapter<Integer>(getApplicationContext(), android.R.layout.simple_list_item_1,numbers);
                listViewTimeTable.setAdapter(myAdapter);
                Toast.makeText(getApplicationContext(),String.valueOf(progress),Toast.LENGTH_LONG).show();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }


}

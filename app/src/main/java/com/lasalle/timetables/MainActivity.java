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
    ArrayList<Integer> numbers;
    ArrayAdapter<Integer> myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }
//////////////////// SOLUTION 1 ///////////////////////////
//    private void initialize() {  // To use this solutions you'll need implements SeekBar.OnSeekBarChangeListener to MainActivity
//        numbers = new ArrayList<Integer>();
//        seekBarTimes = findViewById(R.id.seekBarTime);
//        seekBarTimes.setOnSeekBarChangeListener(this);
//        listViewTimeTable = findViewById(R.id.listViewTimeTables);
//        seekBarTimes.setMax(10);
//        seekBarTimes.setProgress(1);
//        for(int i = 1; i < 11; i++){
//            numbers.add(i);
//        }
//        populateListView();
//    }
//
//    @Override
//    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//        for (int i = 0 ; i < numbers.size(); i++){
//            numbers.set(i, (i + 1) * progress);
//        }
//        populateListView();
////        givenNumber(progress);
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


//////////////////// SOLUTION 2 ///////////////////////////
    private void initialize() {
        numbers = new ArrayList<>();
        seekBarTimes = findViewById(R.id.seekBarTime);
        listViewTimeTable = findViewById(R.id.listViewTimeTables);
        seekBarTimes.setMax(10);
        seekBarTimes.setProgress(1);

        for (int i = 1 ; i <= 10; i++){
            numbers.add(i);
        }
        populateListView();

        seekBarTimes.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                for (int i = 0 ; i < numbers.size(); i++){
                    numbers.set(i, (i + 1) * progress);
                }
                populateListView();
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

    public void populateListView(){
        myAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,numbers);
        listViewTimeTable.setAdapter(myAdapter);
    }


}

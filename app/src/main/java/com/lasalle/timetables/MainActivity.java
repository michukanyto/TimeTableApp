package com.lasalle.timetables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    SeekBar seekBarTimes;
    ListView listViewTimeTable;
    final int MAX = 99;
    ArrayList<Integer> numbers;
    ArrayAdapter<Integer> myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        seekBarTimes = findViewById(R.id.seekBarTime);
        listViewTimeTable = findViewById(R.id.listViewTimeTables);
        seekBarTimes.setMax(MAX);
        numbers = new ArrayList<>();
        DisplayTimes();
    }

    private void DisplayTimes() {
        myAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,numbers);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        giveNumber(progress);
    }


    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    private void giveNumber(int progress) {
        for (int i = 1 ; i <= 10; i++){
            numbers.add(progress * i);
        }
    }
}

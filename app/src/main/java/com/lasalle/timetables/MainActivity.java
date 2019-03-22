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
        myAdapter = new ArrayAdapter<>();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        listViewTimeTable
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}

package com.example.shan.myapplication;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayAdapter<CharSequence> arrayAdapter =
                ArrayAdapter.createFromResource(this,
                R.array.phoneType, android.R.layout.simple_spinner_item);

        arrayAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner = findViewById(R.id.spinner);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(this);


        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        ToggleButton toggleButton = findViewById(R.id.toggleButton);

        Switch aSwitch = findViewById(R.id.switch1);

        aSwitch.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if(isChecked ) {
                            Toast.makeText(getApplicationContext(),
                                    "Switch ON", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(getApplicationContext(), "Switch OFF", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );


    }

    public void onCheckClick(View view){
        int checkId = view.getId();
        switch (checkId){
            case R.id.checkBoxApple:
                if(((CheckBox)view).isChecked() ) {
                    Toast.makeText(this, "Apple checked", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Apple unchecked", Toast.LENGTH_SHORT).show();
                }
                return;
            case R.id.checkBoxOrange:
                Toast.makeText(this, "Orange checked", Toast.LENGTH_SHORT).show();
                return;
        }
    }

    public void onRadioClick(View view){
        switch(view.getId()){
            case R.id.radioButtonColorBlue:
                Toast.makeText(this, "set color Blue", Toast.LENGTH_SHORT).show();
                return;
            case R.id.radioButtonColorRed:
                Toast.makeText(this, "set color Red", Toast.LENGTH_SHORT).show();
                return;
        }
    }


    public void onItemSelected(AdapterView<?> adapterView, View view,
                               int pos, long id) {
        String spinnerLabel = adapterView.getItemAtPosition(pos).toString();
        Toast.makeText(getApplicationContext(), spinnerLabel,
                Toast.LENGTH_SHORT).show();
    }

    public void onNothingSelected(AdapterView<?> parent) {

    }
}

package com.example.poketracker;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText nationalNumberInput;
    EditText nameInput;
    EditText speciesInput;
    EditText heightInput;
    EditText weightInput;
    EditText level;
    EditText hpInput;
    EditText attackInput;
    EditText defenseInput;
    RadioButton gender1;
    RadioButton gender2;
    RadioButton gender3;
    Button submitButton;
    Button openDatabaseButton;
    List<PokeData> data;
    MyTableAdapter adapter;

    View.OnClickListener openDatabaseListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            DatabaseList.showDialog(MainActivity.this, adapter, data);
        }
    };

    View.OnClickListener submitListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            boolean allPass = false;
            boolean check1 = false;
            boolean check2 = false;
            boolean check3 = false;
            boolean check4 = false;
            boolean check5 = false;
            boolean check6 = false;
            boolean check7 = false;
            boolean check8 = false;


            int nationalNumber = Integer.parseInt(nationalNumberInput.getText().toString());
            String name = nameInput.getText().toString();
            String species = speciesInput.getText().toString();
            Float height = Float.parseFloat(heightInput.getText().toString());
            Float weight = Float.parseFloat(weightInput.getText().toString());
            int hp = Integer.parseInt(hpInput.getText().toString());
            int attack = Integer.parseInt(attackInput.getText().toString());
            int defense = Integer.parseInt(defenseInput.getText().toString());


            //Check 1
            if(nationalNumber != (Integer.parseInt(getResources().getString(R.string.nationNumberDefault))) &&
                !name.matches(getResources().getString(R.string.nameDefault)) &&
                !species.matches(getResources().getString(R.string.speciesDefault)) &&
                !height.equals(Float.parseFloat(getResources().getString(R.string.heightDefault))) &&
                !weight.equals(Float.parseFloat(getResources().getString(R.string.weightDefault))) &&
                hp != 0 && attack != 0 && defense != 0 &&
                Integer.parseInt(level.getText().toString()) >= 0){
                    check1 = true;
            } else{
                Toast.makeText(getApplicationContext(), "One or more fields has not been filled out.", Toast.LENGTH_LONG).show();
            }

            //National Number Error
            if(nationalNumber == (Integer.parseInt(getResources().getString(R.string.nationNumberDefault)))){
                nationalNumberInput.setTextColor(Color.RED);
            }

            //Name Error
            if(name.matches(getResources().getString(R.string.nameDefault))){
                nameInput.setTextColor(Color.RED);
            }

            //Species Error
            if(species.matches(getResources().getString(R.string.speciesDefault))){
                speciesInput.setTextColor(Color.RED);
            }

            //Height Error
            if(height.equals(Float.parseFloat(getResources().getString(R.string.heightDefault)))){
                heightInput.setTextColor(Color.RED);
            }

            //Weight Error
            if(weight.equals(Float.parseFloat(getResources().getString(R.string.weightDefault)))){
                weightInput.setTextColor(Color.RED);
            }

            //Check 2
            if(name.length() >= 3 && name.length() <= 12){
                check2 = true;
            } else{
                Toast.makeText(getApplicationContext(),
               "Name is incorrect length. Length must be between 3 and 12 characters.",
                Toast.LENGTH_LONG).show();
                nameInput.setTextColor(Color.RED);
            }

            //Check 3
            check3 = true;
/*            if(gender.equals("Male") || gender.equals("Female") || gender.equals("Unknown")){
                check3 = true;
            } else{
                Toast.makeText(getApplicationContext(),
                "Please choose a gender.",
                 Toast.LENGTH_LONG).show();
            }*/

            //Check 4
            if(hp >= 1 && hp <= 362){
                check4 = true;
            } else{
                Toast.makeText(getApplicationContext(),
                "HP should be between 1 and 362.",
                Toast.LENGTH_LONG).show();
                hpInput.setTextColor(Color.RED);
            }

            //Check 5
            if(attack >= 5 && attack <= 526){
                check5 = true;
            }else{
                Toast.makeText(getApplicationContext(),
                        "Attack should be between 5 and 526.",
                        Toast.LENGTH_LONG).show();
                attackInput.setTextColor(Color.RED);
            }

            //Check 6
            if(defense >= 5 && defense <= 614){
                check6 = true;
            }else{
                Toast.makeText(getApplicationContext(),
                        "Defense should be between 5 and 614.",
                        Toast.LENGTH_LONG).show();
                defenseInput.setTextColor(Color.RED);
            }

            //Check 7
            if(height >= 0.3 && height <= 19.99){
                check7 = true;
            }else{
                Toast.makeText(getApplicationContext(),
                        "Height should be between 0.3m and 19.99m.",
                        Toast.LENGTH_LONG).show();
                heightInput.setTextColor(Color.RED);
            }

            //Check 8
            if(weight >= 0.1 && weight <= 820.0){
                check8 = true;
            }else{
                Toast.makeText(getApplicationContext(),
                        "Weight should be between 0.1 kg and 820.0 kg.",
                        Toast.LENGTH_LONG).show();
                weightInput.setTextColor(Color.RED);
            }

            //Check All
            if(check1 && check2 && check3 && check4 && check5 && check6 && check7 && check8){
                allPass = true;
            }

            //Submit Verification
            if(allPass){
                PokeData newPokemon = new PokeData(nationalNumber, name, species, height, weight, hp, attack, defense);
                data.add(newPokemon);
                adapter.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(), "Pokemon data stored in the Pokedex.", Toast.LENGTH_LONG).show();
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.constraint);

        data = new ArrayList<>();
        adapter = new MyTableAdapter(this, data);
        nationalNumberInput = findViewById(R.id.NationalNumber);
        nationalNumberInput.setText(R.string.nationNumberDefault);
        nameInput = findViewById(R.id.Name);
        nameInput.setText(R.string.nameDefault);
        speciesInput = findViewById(R.id.Species);
        speciesInput.setText(R.string.speciesDefault);
        heightInput = findViewById(R.id.Height);
        heightInput.setText(R.string.heightDefault);
        weightInput = findViewById(R.id.Weight);
        weightInput.setText(R.string.weightDefault);
        level = findViewById(R.id.Level);
        hpInput = findViewById(R.id.HP);
        hpInput.setText(R.string.hpDefault);
        attackInput = findViewById(R.id.Attack);
        attackInput.setText(R.string.attackDefault);
        defenseInput = findViewById(R.id.Defense);
        defenseInput.setText(R.string.defenseDefault);
        submitButton = findViewById(R.id.submitButton);
        submitButton.setOnClickListener(submitListener);
        openDatabaseButton = findViewById(R.id.databaseButton);
        openDatabaseButton.setOnClickListener(openDatabaseListener);
    }

}
package com.example.poketracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MyTableAdapter extends BaseAdapter {
    private List<PokeData> data;
    private LayoutInflater inflater;

    public MyTableAdapter(Context context, List<PokeData> data) {
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.table_row, null);
        }

        TextView textViewNumber = convertView.findViewById(R.id.textViewNN);
        TextView textViewName = convertView.findViewById(R.id.textViewName);
        TextView textViewSpecies = convertView.findViewById(R.id.textViewSpecies);
        TextView textViewHeight = convertView.findViewById(R.id.textViewHeight);
        TextView textViewWeight = convertView.findViewById(R.id.textViewWeight);
        TextView textViewHP = convertView.findViewById(R.id.textViewHP);
        TextView textViewAttack = convertView.findViewById(R.id.textViewAttack);
        TextView textViewDefense = convertView.findViewById(R.id.textViewDefense);

        PokeData item = data.get(position);
        textViewName.setText(item.getName());
        textViewNumber.setText(String.valueOf(item.getNumber()));
        textViewSpecies.setText(String.valueOf(item.getSpecies()));
        textViewHeight.setText(item.getHeight().toString());
        textViewWeight.setText(item.getWeight().toString());
        textViewHP.setText(String.valueOf(item.getHP()));
        textViewAttack.setText(item.getAttack());
        textViewDefense.setText(String.valueOf(item.getDefense()));


        // Set data for other columns

        return convertView;
    }
}
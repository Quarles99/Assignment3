package com.example.poketracker;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class DatabaseList extends MainActivity{
    Dialog dialog;

    View.OnClickListener openDatabaseListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            dialog.show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.constraint);

        View dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_layout, null);
        Button openDatabaseButton = findViewById(R.id.databaseButton);
        openDatabaseButton.setOnClickListener(openDatabaseListener);

        dialog = new Dialog(this);
        dialog.setContentView(dialogView);

        ListView listView = dialogView.findViewById(R.id.listView);
        listView.setAdapter(adapter);



        listView.setOnItemClickListener((parent, view, position, id) -> {
            // Handle item click
            // ...

            // Dismiss the Dialog
            dialog.dismiss();
        });
    }
}

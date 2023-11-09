package com.example.poketracker;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class DatabaseList{

    public static void showDialog(Context context, MyTableAdapter adapter, List<PokeData> data) {

        View dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_layout, null);

        Dialog dialog = new Dialog(context);
        dialog.setContentView(dialogView);

        ListView listView = dialogView.findViewById(R.id.listView);
        listView.setAdapter(adapter);

        dialog.show();

        listView.setOnItemClickListener((parent, view, position, id) -> {
            // Handle item click
            // ...

            // Dismiss the Dialog
            dialog.dismiss();
        });
    }
}

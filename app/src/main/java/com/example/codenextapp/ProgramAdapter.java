package com.example.codenextapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ProgramAdapter extends ArrayAdapter<Program> {
    public ProgramAdapter(@NonNull Context context, @NonNull ArrayList<Program> objects) {
        super(context, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        listItemView = LayoutInflater.from(getContext()).inflate(R.layout.program, parent, false);
        return super.getView(position, convertView, parent);
    }

}

package com.example.noteapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;

import io.realm.RealmResults;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewholder>{

    Context context;
    RealmResults<Note> notesList;

    public MyAdapter(Context context, RealmResults<Note> notesList) {
        this.context = context;
        this.notesList = notesList;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewholder(LayoutInflater.from(context).inflate(R.layout.item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {
        Note note = notesList.get(position);
        holder.titleOutput.setText(note.getTitle());
        holder.descriptionOutput.setText(note.getDescription());

        String formattedTime = DateFormat.getDateTimeInstance().format(note.createdTime);

        holder.timeOutput.setText(formattedTime);

    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }

    public class MyViewholder extends RecyclerView.ViewHolder{

        TextView titleOutput, descriptionOutput, timeOutput;

        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            titleOutput = itemView.findViewById(R.id.titleInput);
            timeOutput = itemView.findViewById(R.id.timeOutput);
            descriptionOutput = itemView.findViewById(R.id.descriptionOutput);

        }
    }
}

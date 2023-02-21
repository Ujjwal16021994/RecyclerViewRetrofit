package com.example.retrofitrecyclerview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

   Context context;
    ArrayList<SampleData> list;
   RecyclerViewAdapter(Context context,ArrayList<SampleData> list) {
       this.context = context;
       this.list = list;
   }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(context).inflate(R.layout.rowlayout,parent,false);
       ViewHolder itemView = new ViewHolder(v);
        return itemView;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

       Log.d("tag","-----------gotten------------"+list.get(position).title);
        holder.albumid.setText(list.get(position).albumid);
        holder.id.setText(list.get(position).id);
        holder.title.setText(list.get(position).title);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

       TextView albumid,id,title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            albumid = itemView.findViewById(R.id.idalbumid);
            id = itemView.findViewById(R.id.idid);
            title = itemView.findViewById(R.id.idtitle);
        }
    }
}

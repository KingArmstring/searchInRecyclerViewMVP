package com.armstring.searchinrecyclerview.home.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.armstring.searchinrecyclerview.R;
import com.armstring.searchinrecyclerview.beans.Country;

import java.util.ArrayList;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{
    private ArrayList<Country> countries = new ArrayList<>();

    //constructor
    public RecyclerAdapter(ArrayList<Country> countries){
        this.countries = countries;
    }

    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.MyViewHolder holder, int position) {
        holder.imgFlag.setImageResource(countries.get(position).getFlag());
        holder.countryName.setText(countries.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imgFlag;
        TextView countryName;

        public MyViewHolder(View itemView) {
            super(itemView);
            imgFlag = (ImageView)itemView.findViewById(R.id.flagImageView);
            countryName = (TextView)itemView.findViewById(R.id.countryNameId);
        }
    }

    public void setFilter(ArrayList<Country> newList){
        countries = new ArrayList<>();
        countries.addAll(newList);
        notifyDataSetChanged();
    }
}

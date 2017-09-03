package com.example.kapusta.travelexpress;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Kapusta on 03.09.2017.
 */

public class ResViewAdapter extends  RecyclerView.Adapter<ResViewAdapter.CountryViewHolder> {

    public static class CountryViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView countryName;
        TextView countryArea;
        ImageView countryFlag;

        CountryViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);
            countryName = (TextView) itemView.findViewById(R.id.country_name);
            countryArea = (TextView) itemView.findViewById(R.id.country_area);
            countryFlag = (ImageView) itemView.findViewById(R.id.country_flag);
        }
    }

    List<Country> countries;
    ResViewAdapter(List<Country> countries){
        this.countries = countries;
    }


    @Override
    public ResViewAdapter.CountryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        CountryViewHolder pvh = new CountryViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(CountryViewHolder holder, int position) {
        holder.countryName.setText(countries.get(position).name);
        holder.countryArea.setText(countries.get(position).area);
        holder.countryFlag.setImageResource(countries.get(position).flagId);
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }
}

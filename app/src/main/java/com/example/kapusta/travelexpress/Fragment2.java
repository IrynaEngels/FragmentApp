package com.example.kapusta.travelexpress;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kapusta on 03.09.2017.
 */

public class Fragment2 extends Fragment {

    private List<Country> countries;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.recycler,
                container, false);

        RecyclerView rv = (RecyclerView)view.findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);

        initializeData();

        ResViewAdapter adapter = new ResViewAdapter(countries);
        rv.setAdapter(adapter);

        return view;
    }

    private void initializeData(){
        countries = new ArrayList<>();
        countries.add(new Country("Unighted Kingdom", "242495 square km", R.drawable.ukflag));
        countries.add(new Country("USA", "9429091 square km", R.drawable.usaflag));
        countries.add(new Country("France", "643801 square km", R.drawable.franceflag));
        countries.add(new Country("Spain", "505990 square km", R.drawable.spainflag));
        countries.add(new Country("Germany", "357376 square km", R.drawable.germanflag));
        countries.add(new Country("Italy", "301338 square km", R.drawable.italyflag));

    }

}

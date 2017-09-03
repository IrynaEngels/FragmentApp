package com.example.kapusta.travelexpress;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by Kapusta on 03.09.2017.
 */

public class Fragment1 extends Fragment {

    TextInputEditText etCountry;
    TextInputEditText etCity;
    TextInputEditText etHotel;
    EditText etDate;
    EditText etDepDate;
    SharedPreferences preferences;
    FloatingActionButton button;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.test,
                container, false);

        etCountry = (TextInputEditText) view.findViewById(R.id.edit_country);
        etCity = (TextInputEditText) view.findViewById(R.id.edit_city);
        etHotel = (TextInputEditText) view.findViewById(R.id.edit_hotel);
        etDate = (EditText) view.findViewById(R.id.edit_date);
        etDepDate = (EditText) view.findViewById(R.id.edit_dep_date);
        button = (FloatingActionButton) view.findViewById(R.id.fab_photo);

        TextWatcher tw1 = new MyTextWatcher(etDate);
        etDate.addTextChangedListener(tw1);

        TextWatcher tw2 = new MyTextWatcher(etDepDate);
        etDepDate.addTextChangedListener(tw2);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String location = etCountry.getText().toString() + ", " + etCity.getText().toString();
                String hotel = etHotel.getText().toString();
                String date = etDate.getText().toString() + " - " + etDepDate.getText().toString();

                preferences = getActivity().getSharedPreferences("Prefs1", Context.MODE_WORLD_WRITEABLE);
                SharedPreferences.Editor ed = preferences.edit();
                ed.putString("Location", location);
                ed.putString("Hotel", hotel);
                ed.putString("Date", date);
                ed.commit();
            }
        });

        return view;
    }

}

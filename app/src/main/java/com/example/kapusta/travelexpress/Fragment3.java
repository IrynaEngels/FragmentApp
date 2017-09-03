package com.example.kapusta.travelexpress;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Kapusta on 03.09.2017.
 */

public class Fragment3 extends Fragment {
    TextView tv1;
    TextView tv2;
    TextView tv3;
    SharedPreferences preferences;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.info,
                container, false);

        tv1 = (TextView) view.findViewById(R.id.textView1);
        tv2 = (TextView) view.findViewById(R.id.textView2);
        tv3 = (TextView) view.findViewById(R.id.textView3);

        preferences = getActivity().getSharedPreferences("Prefs1", Context.MODE_WORLD_READABLE);
        tv1.setText(preferences.getString("Location", "Country, City"));
        tv2.setText(preferences.getString("Hotel", "Hotel"));
        tv3 .setText(preferences.getString("Date", "Date"));
        return view;
    }
}

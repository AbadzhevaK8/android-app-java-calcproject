package com.startandroid.calcproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class HistoryFragment extends Fragment {

    TextView historyView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View historyFragmentView = inflater.inflate(R.layout.fragment_history, container, false);

        historyView = historyFragmentView.findViewById(R.id.recycler_view);
        return historyFragmentView;
    }
}
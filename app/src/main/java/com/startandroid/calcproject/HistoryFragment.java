package com.startandroid.calcproject;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;
import java.util.Objects;


public class HistoryFragment extends Fragment {

    public static final String TAG = "HistoryFragment";

    private final LinkedList<String> mWordList = new LinkedList<>();
    RecyclerView mRecyclerView;
    WordListUpdater mAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View historyFragmentView = inflater.inflate(R.layout.fragment_history, container, false);

        mRecyclerView = historyFragmentView.findViewById(R.id.recycler_view);
        mAdapter = new WordListUpdater(requireContext(), mWordList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        return historyFragmentView;
    }

    public void updateRecyclerView(String newData) {
        Log.v(TAG, newData);
        int wordListSize = mWordList.size();
        mWordList.addLast(newData);
        Objects.requireNonNull(mRecyclerView.getAdapter()).notifyItemInserted(wordListSize);
        mRecyclerView.smoothScrollToPosition(wordListSize);
    }
}
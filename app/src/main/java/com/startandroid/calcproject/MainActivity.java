package com.startandroid.calcproject;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity implements RecyclerViewUpdater {
    private static final String TAG = "MainActivity";
    HistoryFragment historyFragment;
    SharedViewModel viewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        historyFragment = (HistoryFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_history);

        viewModel = new ViewModelProvider(this).get(SharedViewModel.class);
    }

    public Boolean updateRecyclerViewData(String newData) {
        if (historyFragment != null) {
            Log.v(TAG, newData + " MainActivity");
            historyFragment.updateRecyclerView(newData);
            return true;
        } else {
            Log.v(TAG, newData + " MainActivity historyFragment is null!!!");
            return false;
        }
    }
}
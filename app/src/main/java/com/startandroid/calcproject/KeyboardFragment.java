package com.startandroid.calcproject;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class KeyboardFragment extends Fragment implements View.OnClickListener {

    SharedViewModel viewModel;
    MediaPlayer mediaPlayer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View keyboardView = inflater.inflate(R.layout.fragment_keyboard,
                container, false);

        viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        mediaPlayer = MediaPlayer.create(getContext(), R.raw.sound_click);
        Button divisionBtn = keyboardView.findViewById(R.id.division);
        Button multiplyBtn = keyboardView.findViewById(R.id.multiply);
        Button subtractionBtn = keyboardView.findViewById(R.id.subtraction);
        Button sumBtn = keyboardView.findViewById(R.id.sum);
        Button sevenBtn = keyboardView.findViewById(R.id.seven);
        Button eightBtn = keyboardView.findViewById(R.id.eight);
        Button nineBtn = keyboardView.findViewById(R.id.nine);
        Button rootBtn = keyboardView.findViewById(R.id.root);
        Button fourBtn = keyboardView.findViewById(R.id.four);
        Button fiveBtn = keyboardView.findViewById(R.id.five);
        Button sixBtn = keyboardView.findViewById(R.id.six);
        Button squareBtn = keyboardView.findViewById(R.id.square);
        Button oneBtn = keyboardView.findViewById(R.id.one);
        Button twoBtn = keyboardView.findViewById(R.id.two);
        Button threeBtn = keyboardView.findViewById(R.id.three);
        Button equalsBtn = keyboardView.findViewById(R.id.equals);
        Button dotBtn = keyboardView.findViewById(R.id.dot);
        Button zeroBtn = keyboardView.findViewById(R.id.zero);
        Button percentBtn = keyboardView.findViewById(R.id.percent);
        Button calcBtn = keyboardView.findViewById(R.id.clear);

        divisionBtn.setOnClickListener(this);
        multiplyBtn.setOnClickListener(this);
        subtractionBtn.setOnClickListener(this);
        sumBtn.setOnClickListener(this);
        sevenBtn.setOnClickListener(this);
        eightBtn.setOnClickListener(this);
        nineBtn.setOnClickListener(this);
        rootBtn.setOnClickListener(this);
        fourBtn.setOnClickListener(this);
        fiveBtn.setOnClickListener(this);
        sixBtn.setOnClickListener(this);
        squareBtn.setOnClickListener(this);
        oneBtn.setOnClickListener(this);
        twoBtn.setOnClickListener(this);
        threeBtn.setOnClickListener(this);
        equalsBtn.setOnClickListener(this);
        dotBtn.setOnClickListener(this);
        zeroBtn.setOnClickListener(this);
        percentBtn.setOnClickListener(this);
        calcBtn.setOnClickListener(this);

        return keyboardView;
    }

    @Override
    public void onClick(View view) {
        mediaPlayer.start();
//        mediaPlayer.release();
        String buttonId = getResources().getResourceEntryName(view.getId());
        // Toast.makeText(getActivity(), buttonId, Toast.LENGTH_SHORT).show();
        viewModel.setDataToPass(buttonId);
    }
}
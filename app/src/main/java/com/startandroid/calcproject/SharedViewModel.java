package com.startandroid.calcproject;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    private final MutableLiveData<String> dataToPass = new MutableLiveData<>();

    public MutableLiveData<String> getDataToPass() {
        return dataToPass;
    }

    public void setDataToPass(String data) {
        dataToPass.setValue(data);
    }

}

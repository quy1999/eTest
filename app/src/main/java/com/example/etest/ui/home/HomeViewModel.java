package com.example.etest.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Chào mừng bạn đến với đề kiểm tra tiếng anh. " +
                "Vui lòng ấn phím Home để chọn dạng  đề");

    }

    public LiveData<String> getText() {
        return mText;
    }
}
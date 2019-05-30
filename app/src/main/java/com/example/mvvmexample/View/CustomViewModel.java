package com.example.mvvmexample.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmexample.Model.ApiInterface;
import com.example.mvvmexample.Model.PhonePojoResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CustomViewModel extends ViewModel {
    private MutableLiveData<PhonePojoResult> dataSetContacts = new MutableLiveData<>();

    public LiveData<PhonePojoResult> initRetrofit() {
        new Retrofit.Builder()
                .baseUrl("https://api.androidhive.info/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiInterface.class)
                .getContacts()
                .enqueue(new Callback<PhonePojoResult>() {
                    @Override
                    public void onResponse(Call<PhonePojoResult> call, Response<PhonePojoResult> response) {
                        dataSetContacts.setValue(response.body());
                    }

                    @Override
                    public void onFailure(Call<PhonePojoResult> call, Throwable t) {

                    }
                });
        return dataSetContacts;
    }
}

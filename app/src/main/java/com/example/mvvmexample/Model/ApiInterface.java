package com.example.mvvmexample.Model;


import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("contacts/")
    Call<PhonePojoResult> getContacts();
    //https://api.androidhive.info/contacts/
}

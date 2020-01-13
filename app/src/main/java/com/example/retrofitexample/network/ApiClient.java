package com.example.retrofitexample.network;

import com.example.retrofitexample.model.LoginResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static final String BASE_URL = "http://3.83.179.95:3000";
    private static Retrofit retrofit = null;


    public static ApiInterface getClient(){

        if (retrofit==null){
            retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
        }
        //creating object for our interface
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        return apiInterface;

    }


   /* public static Retrofit getClient(){
    if (retrofit==null){
        retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
    }
        //Creating object for our interface
       // ApiInterface api = retrofit.create(ApiInterface.class);
        return retrofit; // return the APIInterface object
}*/
}

package com.example.retrofitexample.network;

import com.example.retrofitexample.model.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded  //anotation used to POST type request
    @POST("/users/userLogin")
        //Api's End Point

    Call<LoginResponse> loginUser(@Field("email") String name,
                                  @Field("userPassword") String password);




    // In loginUser method @Field used to set the keys and String data type is representing its a string type value and
    // callback is used to get the response from api and it will set it in our POJO class
}

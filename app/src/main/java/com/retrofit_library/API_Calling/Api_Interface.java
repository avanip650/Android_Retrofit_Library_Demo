package com.retrofit_library.API_Calling;

import com.retrofit_library.Model.Contact;
import com.retrofit_library.Model.Example;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;

public interface Api_Interface {

    @GET("contacts/")
    public Call<Example> getResponse();

}

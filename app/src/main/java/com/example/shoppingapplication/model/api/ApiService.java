package com.example.shoppingapplication.model.api;

import android.arch.lifecycle.LiveData;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {


    @GET("api/values?url=<NewDataSet><Table><ver>1_02.01.06</ver><proc>001LOCALSELECT</proc><P1>010001</P1><P2></P2><P3></P3><P4>1</P4></Table></NewDataSet>")
    Flowable<List<JsonResponse>> getJSON();

    @GET("api/values?url=<NewDataSet><Table><ver>1_02.01.06</ver><proc>003TOTALSELECT</proc><P1>ADMIN</P1><P2>123456</P2><P3>MBLTYPEVISIT1</P3></Table></NewDataSet>")
    Single<JSONUserResponse> getUsersJSON();





}

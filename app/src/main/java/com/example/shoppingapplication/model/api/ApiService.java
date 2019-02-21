package com.example.shoppingapplication.model.api;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {


    @GET("values?url=<NewDataSet><Table><ver>1_02.01.06</ver><proc>001LOCALSELECT</proc><P1>010001</P1><P2></P2><P3></P3><P4>1</P4></Table></NewDataSet>")
    Call<JsonResponse> getJSON();

    @GET("values?url=<NewDataSet><Table><ver>1_02.01.06</ver><proc>003TOTALSELECT</proc><P1>ADMIN</P1><P2>123456</P2><P3>MBLTYPEVISIT1</P3></Table></NewDataSet>")
    Call<JSONUserResponse> getUsersJSON();
//
//    @FormUrlEncoded
//    @POST("values?url=<NewDataSet><Table><ver>1_02.01.06</ver><proc>003TOTALSELECT</proc><P1> myUsername </P1><P2>myPassword</P2><P3> MBLTYPEVISIT1</P3></Table></NewDataSet>")
//    Single<PRSMBL009> getUser(
//            @Field("username") String email,
//            @Field("password") String password);


}

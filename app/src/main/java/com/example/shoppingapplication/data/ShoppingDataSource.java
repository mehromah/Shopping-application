package com.example.shoppingapplication.data;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.example.shoppingapplication.model.api.JSONUserResponse;
import com.example.shoppingapplication.model.api.JsonResponse;

import java.util.List;

import io.reactivex.Single;

public interface ShoppingDataSource {

    LiveData<List<JsonResponse>> getJsonResponse();

    LiveData<List<JSONUserResponse>> getJsonUserResponse();


    LiveData<List<JsonResponse>> search(String keyword);

    LiveData<List<JSONUserResponse>> searchUser(String keyword);


}

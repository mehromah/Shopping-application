package com.example.shoppingapplication.main;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.example.shoppingapplication.data.ShoppingRepository;
import com.example.shoppingapplication.model.api.ApiService;
import com.example.shoppingapplication.model.api.JSONUserResponse;
import com.example.shoppingapplication.model.api.JsonResponse;
import com.example.shoppingapplication.providers.ApiServiceProvider;

import java.util.List;

public class MainViewModel {

    private ShoppingRepository shoppingRepository;
    private LiveData<List<JsonResponse>> jsonResponse;
    private LiveData<List<JSONUserResponse>> getJsonUserResponse;

    public MainViewModel(Application application){
        shoppingRepository = new ShoppingRepository(application);
        jsonResponse = shoppingRepository.getJsonResponse();
    }


    LiveData<List<JsonResponse>> getJsonResponse() {
        return jsonResponse;
    }
        void saveJsonResponseList(final JsonResponse jsonResponse) {
        shoppingRepository.insert(jsonResponse);
    }










}

package com.example.shoppingapplication.data;

import com.example.shoppingapplication.model.api.ApiService;
import com.example.shoppingapplication.model.api.JsonResponse;
import com.example.shoppingapplication.providers.ApiServiceProvider;

import java.util.List;

import io.reactivex.Flowable;

public class CloudDataSource implements ShoppingDataSource {

    private ApiService apiService;

    public CloudDataSource() {
        super();
        apiService = ApiServiceProvider.provideApiService();
    }


    @Override
    public Flowable<List<JsonResponse>> getJsonResponse() {
        return apiService.getJSON();
    }


}

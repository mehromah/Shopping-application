package com.example.shoppingapplication.main;

import com.example.shoppingapplication.model.api.ApiService;
import com.example.shoppingapplication.model.api.JSONUserResponse;
import com.example.shoppingapplication.model.api.JsonResponse;
import com.example.shoppingapplication.providers.ApiServiceProvider;

import retrofit2.Call;

public class MainViewModel {
    private ApiService apiService = ApiServiceProvider.provideApiService();

    Call<JsonResponse> call = apiService.getJSON();
    Call<JSONUserResponse> callUser = apiService.getUsersJSON();
}

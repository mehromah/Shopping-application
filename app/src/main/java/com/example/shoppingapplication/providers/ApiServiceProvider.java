package com.example.shoppingapplication.providers;

import com.example.shoppingapplication.model.api.ApiService;
import com.example.shoppingapplication.model.api.RetrofitSingleton;

public class ApiServiceProvider {
    private static ApiService apiService;

    public static ApiService provideApiService() {
        if (apiService == null) {
            apiService = RetrofitSingleton.getInstance().create(ApiService.class);
        }
        return apiService;
    }
}

package com.example.shoppingapplication.data;

import com.example.shoppingapplication.model.api.JsonResponse;

import java.util.List;

import io.reactivex.Flowable;

public interface ShoppingDataSource {

    Flowable<List<JsonResponse>> getJsonResponse();




}

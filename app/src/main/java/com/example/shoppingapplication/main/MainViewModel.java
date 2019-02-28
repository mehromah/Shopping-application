package com.example.shoppingapplication.main;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.shoppingapplication.data.ShoppingDataSource;
import com.example.shoppingapplication.data.ShoppingRepository;
import com.example.shoppingapplication.model.api.ApiService;
import com.example.shoppingapplication.model.api.JSONUserResponse;
import com.example.shoppingapplication.model.api.JsonResponse;
import com.example.shoppingapplication.providers.ApiServiceProvider;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.Call;

public class MainViewModel extends AndroidViewModel {
    private ShoppingRepository shoppingRepository ;
    private Flowable<List<JsonResponse>> allJsonResponse;
    private ApiService apiService  = ApiServiceProvider.provideApiService();


    public MainViewModel(@NonNull Application application) {
        super(application);
        shoppingRepository = new ShoppingRepository(application);
        allJsonResponse=shoppingRepository.getJsonResponse();
    }

    Flowable<List<JsonResponse>> getJsonResponse(){
        return allJsonResponse;
    }

//    public void insert(JsonResponse jsonResponse){
//        shoppingRepository.
//    }


    Call<JSONUserResponse> callUser = apiService.getUsersJSON();



//    public void insert(Word word) { mRepository.insert(word); }
}

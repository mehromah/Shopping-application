package com.example.shoppingapplication.data;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.os.AsyncTask;

import com.example.shoppingapplication.model.api.ApiService;
import com.example.shoppingapplication.model.api.JSONUserResponse;
import com.example.shoppingapplication.model.api.JsonResponse;
import com.example.shoppingapplication.providers.ApiServiceProvider;

import java.util.Arrays;
import java.util.List;


public class ShoppingRepository implements ShoppingDataSource {
    private ApiService apiService;
    private LocalDataSource localDataSource;
    public ShoppingRepository(Context context) {
        localDataSource = AppDatabase.getInstance(context).getLocalDataSource();
        apiService = ApiServiceProvider.provideApiService();

    }

    @Override
    public LiveData<List<JsonResponse>> getJsonResponse() {
        return localDataSource.getJsonResponse();
    }

    @Override
    public LiveData<List<JSONUserResponse>> getJsonUserResponse() {
        return localDataSource.getJsonUserResponse();
    }

    public void insert (JsonResponse jsonResponse) {
        new insertAsyncTask((LocalDataSource) apiService).execute(jsonResponse);
    }

    private static class insertAsyncTask extends AsyncTask<JsonResponse, Void, Void> {

        private LocalDataSource mAsyncTaskDao;

        insertAsyncTask(LocalDataSource dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final JsonResponse... jsonResponses) {
            mAsyncTaskDao.saveJsonResponseList(Arrays.asList(jsonResponses));
            return null;
        }
    }


    @Override
    public LiveData<List<JsonResponse>> search(String keyword) {
        return null;
    }

    @Override
    public LiveData<List<JSONUserResponse>> searchUser(String keyword) {
        return null;
    }


}

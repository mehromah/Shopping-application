package com.example.shoppingapplication.data;

import android.content.Context;
import android.util.Log;

import com.example.shoppingapplication.model.api.JsonResponse;

import org.reactivestreams.Subscription;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class ShoppingRepository implements ShoppingDataSource {
    private CloudDataSource cloudDataSource;
    private LocalDataSource localDataSource;


    public ShoppingRepository(Context context) {
        localDataSource = AppDatabase.getInstance(context).getLocalDataSource();
        cloudDataSource = new CloudDataSource();

    }


    @Override
    public Flowable<List<JsonResponse>> getJsonResponse() {
        cloudDataSource.getJsonResponse().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new FlowableSubscriber<List<JsonResponse>>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        s.request(Long.MAX_VALUE);
                    }

                    @Override
                    public void onNext(List<JsonResponse> jsonResponses) {
                        localDataSource.saveJsonResponseList(jsonResponses);
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.e("NewsRepo", "onError: " + t.toString());

                    }

                    @Override
                    public void onComplete() {

                    }
                });


        return localDataSource.getJsonResponse();
    }
}

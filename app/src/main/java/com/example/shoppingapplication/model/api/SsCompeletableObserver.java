package com.example.shoppingapplication.model.api;

import com.example.shoppingapplication.base.BaseActivity;
import com.example.shoppingapplication.exception.ExceptionMessageFactory;

import io.reactivex.CompletableObserver;

public abstract class SsCompeletableObserver implements CompletableObserver {
    private BaseActivity activity;

    public SsCompeletableObserver(BaseActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onError(Throwable e) {
        activity.showSnackBarMessage(ExceptionMessageFactory.getMessage(e));
    }


}

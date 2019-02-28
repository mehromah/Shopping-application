package com.example.shoppingapplication.providers;

import android.content.Context;

import com.example.shoppingapplication.data.ShoppingDataSource;
import com.example.shoppingapplication.data.ShoppingRepository;

public class ShoppingRepositoyProvider {

    public static ShoppingDataSource provideNewsDataSource(Context context) {
        return new ShoppingRepository(context);
    }
}

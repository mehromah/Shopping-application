package com.example.shoppingapplication.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.airbnb.lottie.L;
import com.example.shoppingapplication.model.PRSMBL003;
import com.example.shoppingapplication.model.PRSMBL004;
import com.example.shoppingapplication.model.PRSMBL005;
import com.example.shoppingapplication.model.api.JsonResponse;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public abstract class LocalDataSource implements ShoppingDataSource {


//    @Update
//    public abstract void update(List<JsonResponse> jsonResponseList);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public abstract void saveJsonResponseList(List<JsonResponse> jsonResponseList);
//    public abstract void saveJsonResponseList(List<PRSMBL003> prsmbl003s);


    @Query("SELECT * FROM tbl_PRSMBL003,tbl_PRSMBL004,tbl_PRSMBL005")
    @Override
    public Flowable<List<JsonResponse>> getJsonResponse() {
        return null;
    }


    @Query("DELETE FROM tbl_prsmbl003")
    public abstract void removeAllRows();


//    public abstract void insert(JsonResponse param);
}

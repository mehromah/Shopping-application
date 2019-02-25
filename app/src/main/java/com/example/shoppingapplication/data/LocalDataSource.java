package com.example.shoppingapplication.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.shoppingapplication.model.PRSMBL003;
import com.example.shoppingapplication.model.PRSMBL004;
import com.example.shoppingapplication.model.PRSMBL005;
import com.example.shoppingapplication.model.PRSMBL009;

import java.util.List;

import io.reactivex.Single;

//@android.arch.persistence.room.Dao
@Dao
public abstract class LocalDataSource implements NewsDataSource {

//    @Query("SELECT * FROM tbl_user")
//    @Override
//    public abstract Single<List<PRSMBL009>> getUser();
//
//
//    @Query("SELECT * FROM tbl_product")
//    @Override
//    public abstract Single<List<Product>> getProduct();
//
//    @android.arch.persistence.room.Insert(onConflict = OnConflictStrategy.IGNORE)
//    public abstract void saveUsersList(List<PRSMBL009> usersList);
//
//    @android.arch.persistence.room.Update
//    public abstract void addUser(PRSMBL009 user);
//
//
//    @android.arch.persistence.room.Query("SELECT * FROM tbl_user WHERE mCMBL009001 LIKE '%' || :keyword || '%'")
//    @Override
//    public abstract Single<List<PRSMBL009>> searchUser(String keyword);
//
//    @android.arch.persistence.room.Query("DELETE FROM tbl_user")
//    public abstract void removeAllRows();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public abstract void savePRSMBL003List(List<PRSMBL003> prsmbl003List);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public abstract void savePRSMBL004List(List<PRSMBL004> prsmbl004List);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public abstract void savePRSMBL005List(List<PRSMBL005> prsmbl005List);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public abstract void savePRSMBL009List(List<PRSMBL009> prsmbl009List);



    @Query("SELECT * FROM tbl_PRSMBL003")
    @Override
    public Single<List<PRSMBL003>> getPRSMBL003() {
        return null;
    }

    @Query("SELECT * FROM tbl_PRSMBL004")
    @Override
    public Single<List<PRSMBL004>> getPRSMBL004() {
        return null;
    }

    @Query("SELECT * FROM tbl_PRSMBL005")
    @Override
    public Single<List<PRSMBL005>> getPRSMBL005() {
        return null;
    }


    @Query("SELECT * FROM tbl_PRSMBL009")
    @Override
    public Single<List<PRSMBL009>> getPRSMBL009() {
        return null;
    }


    @Query("SELECT * FROM tbl_PRSMBL003 WHERE mCMBL003011 LIKE '%' || :keyword || '%'")
    @Override
    public abstract Single<List<PRSMBL003>> search(String keyword);

    @Query("DELETE FROM tbl_prsmbl003")
    public abstract void removeAllRows();












}

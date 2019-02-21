package com.example.shoppingapplication.model.api;


import com.example.shoppingapplication.model.PRSMBL009;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JSONUserResponse {


    @SerializedName("Table")
    @Expose
    private List<PRSMBL009> table = null;

    public List<PRSMBL009> getTable(){
        return table;
    }
}

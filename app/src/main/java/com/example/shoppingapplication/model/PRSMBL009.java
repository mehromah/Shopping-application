
package com.example.shoppingapplication.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "tbl_PRSMBL009")
public class PRSMBL009 {

    @SerializedName("BMBL009008")
    private  String mBMBL009008;

    @PrimaryKey
    @NonNull
    @SerializedName("CMBL009001")
    private int mCMBL009001;
    @SerializedName("CMBL009003")
    private String mCMBL009003;
    @SerializedName("CMBL009004")
    private String mCMBL009004;
    @SerializedName("CMBL009005")
    private String mCMBL009005;
    @SerializedName("CMBL009006")
    private String mCMBL009006;
    @SerializedName("CMBL009010")
    private String mCMBL009010;
    @SerializedName("CMBL009011")
    private String mCMBL009011;
    @SerializedName("NMBL009002")
    private String mNMBL009002;
    @SerializedName("NMBL009007")
    private String mNMBL009007;
    @SerializedName("NMBL009009")
    private String mNMBL009009;
    @SerializedName("NMBL009012")
    private String mNMBL009012;
    @SerializedName("NMBL009013")
    private String mNMBL009013;

    public String getBMBL009008() {
        return mBMBL009008;
    }

    public void setBMBL009008(String bMBL009008) {
        mBMBL009008 = bMBL009008;
    }

    public int getCMBL009001() {
        return mCMBL009001;
    }

    public void setCMBL009001(int cMBL009001) {
        mCMBL009001 = cMBL009001;
    }

    public String getCMBL009003() {
        return mCMBL009003;
    }

    public void setCMBL009003(String cMBL009003) {
        mCMBL009003 = cMBL009003;
    }

    public String getCMBL009004() {
        return mCMBL009004;
    }

    public void setCMBL009004(String cMBL009004) {
        mCMBL009004 = cMBL009004;
    }

    public String getCMBL009005() {
        return mCMBL009005;
    }

    public void setCMBL009005(String cMBL009005) {
        mCMBL009005 = cMBL009005;
    }

    public String getCMBL009006() {
        return mCMBL009006;
    }

    public void setCMBL009006(String cMBL009006) {
        mCMBL009006 = cMBL009006;
    }

    public String getCMBL009010() {
        return mCMBL009010;
    }

    public void setCMBL009010(String cMBL009010) {
        mCMBL009010 = cMBL009010;
    }

    public String getCMBL009011() {
        return mCMBL009011;
    }

    public void setCMBL009011(String cMBL009011) {
        mCMBL009011 = cMBL009011;
    }

    public String getNMBL009002() {
        return mNMBL009002;
    }

    public void setNMBL009002(String nMBL009002) {
        mNMBL009002 = nMBL009002;
    }

    public String getNMBL009007() {
        return mNMBL009007;
    }

    public void setNMBL009007(String nMBL009007) {
        mNMBL009007 = nMBL009007;
    }

    public String getNMBL009009() {
        return mNMBL009009;
    }

    public void setNMBL009009(String nMBL009009) {
        mNMBL009009 = nMBL009009;
    }

    public String getNMBL009012() {
        return mNMBL009012;
    }

    public void setNMBL009012(String nMBL009012) {
        mNMBL009012 = nMBL009012;
    }

    public String getNMBL009013() {
        return mNMBL009013;
    }

    public void setNMBL009013(String nMBL009013) {
        mNMBL009013 = nMBL009013;
    }

}

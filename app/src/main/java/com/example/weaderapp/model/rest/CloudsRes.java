package com.example.weaderapp.model.rest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class CloudsRes {
    @SerializedName("all")
    @Expose
    public int all;

    @Override
    public String toString() {
        return "CloudsRes{" +
                "all=" + all +
                '}';
    }
}

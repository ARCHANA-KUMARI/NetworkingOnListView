package com.robosoft.archanakumari.networkingonlistview.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;
/**
 * Created by archanakumari on 15/12/15.
 */
public class ListWrapper {

 @SerializedName("android")
    public List<ListItem> userList;
}


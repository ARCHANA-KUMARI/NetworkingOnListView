package com.robosoft.archanakumari.networkingonlistview.manager;

import android.content.Context;

import com.android.volley.Response;
import com.robosoft.archanakumari.networkingonlistview.dto.ListWrapper;
import com.robosoft.archanakumari.networkingonlistview.network.GsonRequest;
import com.robosoft.archanakumari.networkingonlistview.network.VolleyHelper;

/**
 * Created by archanakumari on 15/12/15.
 */
public class DownloadManager {

    public static void downloadData(Context ctx,String url,Response.Listener<ListWrapper> listener,Response.ErrorListener errorListener){
        GsonRequest<ListWrapper> request = new GsonRequest<ListWrapper>(url,ListWrapper.class,listener,errorListener);
        request.setTag(url);
        VolleyHelper.getInstance(ctx).addToRequestQueue(request);

    }


}

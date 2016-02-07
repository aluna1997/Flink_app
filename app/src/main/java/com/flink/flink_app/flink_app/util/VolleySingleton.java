package com.flink.flink_app.flink_app.util;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by ligorio on 06/02/16.
 */
public class VolleySingleton {

    private static  VolleySingleton singleton;
    private RequestQueue requestQueue;

    private static Context cnx;

    public VolleySingleton(Context context) {

        cnx = context;
        requestQueue = getRequestQueue();

    }

    public static synchronized VolleySingleton getInstance(Context context){
        if(singleton==null){
            singleton = new VolleySingleton(context);
        }
        return singleton;
    }

    private RequestQueue getRequestQueue() {
        if(requestQueue==null){
            requestQueue = Volley.newRequestQueue(cnx.getApplicationContext());
        }

        return  requestQueue;

    }

    public void addToRequestQueue (Request req){
        getRequestQueue().add(req);
    }
}

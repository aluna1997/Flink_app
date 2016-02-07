package com.flink.flink_app.flink_app.util;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

/**
 * Created by ligorio on 05/02/16.
 */
public class VolleyRequest {

    private String url ;
    private  Context cnx;
    public JSONObject data;
    public VolleyRequest(String url, Context context){
        this.url = url;
        this.cnx = context;
    }

    public  void  getRequest (final VolleyCallBack callBack){
        //Log.i("Jsonreq", "Hey estoy aqui"); // Test
        //Log.i("URLString",url);

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url,(String)null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        callBack.onSuccess(response);
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub
                        Log.i("Error json", error.toString());
                    }
                });
        VolleySingleton.getInstance(cnx).addToRequestQueue(jsObjRequest);

    }



}

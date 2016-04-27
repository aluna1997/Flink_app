package com.flink.flink_app.flink_app.util;

import android.content.Context;
import android.media.MediaRouter;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ligorio on 05/02/16.
 */
public class VolleyRequest {

    private String url ;
    private  Context cnx;
    private JSONObject data;


    public VolleyRequest(String url, Context context){
        this.url = url;
        this.cnx = context;
    }

    public VolleyRequest(Context cnx,String url, JSONObject data) {
        this.cnx = cnx;
        this.url = url;
        this.data = data;
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

    public void postLoginRequest(final VolleyCallBack callback){
       /* Toast t1 = null;

        try {
            t1 = Toast.makeText(cnx, "data: "+data.getString("username")+" \n otro: "+data.getString("password"),Toast.LENGTH_LONG);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        t1.show();*/

        //Log.i("URLString",url);
       JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,url, data, new Response.Listener<JSONObject>(){

            @Override
            public void onResponse(JSONObject response) {



                callback.onSuccess(response);

            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                    Log.i("Error json post : ",error.toString());
            }
        });

        VolleySingleton.getInstance(cnx).addToRequestQueue(jsonObjectRequest);



    }



}

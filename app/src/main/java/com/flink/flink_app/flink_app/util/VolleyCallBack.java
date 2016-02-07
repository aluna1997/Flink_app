package com.flink.flink_app.flink_app.util;

import org.json.JSONObject;

/**
 * Created by ligorio on 05/02/16.
 */
public interface VolleyCallBack {
    void onSuccess(JSONObject data);
    void customOnSuccess(JSONObject string);

}

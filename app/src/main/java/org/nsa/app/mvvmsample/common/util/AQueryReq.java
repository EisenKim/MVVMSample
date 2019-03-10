package org.nsa.app.mvvmsample.common.util;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.HashMap;
import org.nsa.app.mvvmsample.Constants;

public class AQueryReq {

    private Context context;
    private AQuery aquery;
    private Callback callback;

    public interface Callback {
        void onSuccess(String data, AjaxStatus status);
        void onError(String message);
        void onAjaxError(int code);
    }

    public AQueryReq(Context context, String url, Callback callback) {
        this(context, url, null, null, callback);
    }

    public AQueryReq(Context context, String url, HashMap<String, Object> params, Callback callback) {
        this(context, url, params, null, callback);
    }

    public AQueryReq(Context context, String url, String token, Callback callback) {
        this(context, url, null, token, callback);
    }

    public AQueryReq(Context context, String url, HashMap<String, Object> params, String token, Callback callback) {
        Log.i("AQueryReq URL : ",  url);

        this.context = context;
        this.aquery = new AQuery(context);
        this.callback = callback;

        ajaxCallback = ajaxCallback.header("Content-Type", "application/json; charset=utf-8" /*"application/x-www-form-urlencoded"*/);

        if (!TextUtils.isEmpty(token)) {
            ajaxCallback = ajaxCallback.header(Constants.REQ_HEADER_X_TOKEN, token);
        }
        ajaxCallback = ajaxCallback.timeout(Constants.CONNECTION_TIMEOUT);

        if (params == null) {
            aquery.ajax(url, String.class, ajaxCallback);
        }
        else {
            Log.d("AQueryReq params : " , params.toString());
            aquery.ajax(url, params, String.class, ajaxCallback);
        }
    }

    private AjaxCallback<String> ajaxCallback = new AjaxCallback<String>() {

        @Override
        public void callback(String url, String strJson, AjaxStatus status) {
            Log.d("AQueryReq Response : ", "" + strJson + ", Code = " + status.getCode());

            try {
                if(status.getCode() == 200) {
                    Log.d("Test", "SUCCESS");
                    callback.onSuccess(strJson, status);
                }
                else {
                    Log.d("Test", "Error");
                    callback.onAjaxError(status.getCode());
                }
            }
            catch (Exception e) {
                Log.e("Error : ", e.toString());
                e.printStackTrace();
            }
        }
    };

}

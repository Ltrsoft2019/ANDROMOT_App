package com.ltrsoft.andromotapp.pojoclass;


import android.content.Context;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ltrsoft.andromotapp.interfaces.CallBack;
import com.ltrsoft.andromotapp.javaclasses.User_crop_sensor;
import com.ltrsoft.andromotapp.javaclasses.User_detail;
import com.ltrsoft.andromotapp.javaclasses.User_pump_status;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserPump {
    public static final String createurl = "";
    public static final String updateurl = "";
    public static final String deleteurl = "";
    public static final String getallurl = "";
    public static final String getoneurl = "";
    public User_pump_status user_pump_status;
    private ArrayList<User_detail> list = new ArrayList<>();

    public void createUser(User_pump_status user_pump_status, Context context, CallBack callBack) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, createurl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                callBack.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            //            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.onError(error.toString());
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> map = new HashMap<>();
                map.put("pump_status", user_pump_status.getPump_status());

                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }

    public void updateUser(User_pump_status user_pump_status, Context context, CallBack callBack) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, updateurl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.contains("success")) {

                            callBack.onSuccess("success");
                        } else {
                            callBack.onError(response.toString());

                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.onError(error.toString());
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> map = new HashMap<>();
                map.put("pump_status", user_pump_status.getPump_status());

                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }

    public void getoneuserpump(String user_p_status_id, Context context, CallBack callBack) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, getoneurl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        String user_p_status_id = jsonObject.getString("user_p_status_id  ");
                        String user_id = jsonObject.getString("user_id ");
                        //User_pump_status user_pump_status=new User_pump_status(user_p_status_id,user_id);
                    }
                    callBack.onSuccess(list);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> map = new HashMap<>();
                map.put("user_id", user_p_status_id.toString());

                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);

    }

    public void getalluserdetail(String user_p_status_id, Context context, CallBack callBack) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, getallurl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        String user_p_status_id = jsonObject.getString("user_p_status_id  ");
                        String user_id = jsonObject.getString("user_id ");
                        String pump_status = jsonObject.getString("pump_status ");
                        User_pump_status user_pump_status = new User_pump_status(user_p_status_id, user_id, pump_status);
                    }
                    callBack.onSuccess(list);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> map = new HashMap<>();
                map.put("user_p_status_id ", user_p_status_id.toString());
                //map.put("user_id  ",user_id  .toString());
                // map.put("pump_status  ",pump_status  .toString());


                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);

    }

    public void deleteUser(User_pump_status user_pump_status, Context context, CallBack callBack) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, deleteurl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> map = new HashMap<>();
                map.put("User_id", user_pump_status.getUser_id());
                return map;
            }
        };
    }
}


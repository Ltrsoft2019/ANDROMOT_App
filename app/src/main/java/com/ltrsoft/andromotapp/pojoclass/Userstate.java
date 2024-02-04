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
import com.ltrsoft.andromotapp.javaclasses.State;
import com.ltrsoft.andromotapp.javaclasses.User_crop_sensor;
import com.ltrsoft.andromotapp.javaclasses.User_detail;
import com.ltrsoft.andromotapp.javaclasses.User_pump_status;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Userstate {
    public static final String  createurl="";
    public static final String updateurl="";
    public static final String deleteurl="";
    public  static  final String getallurl="";
    public static  final String getoneurl="";

    public State state ;

    private ArrayList<State> list = new ArrayList<>();
    public void createUser(State state , Context context , CallBack callBack){
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
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap <String , String>map =new HashMap<>();
                map.put("state_name", state.getState_name());
                map.put("country_id ", state.getCountry_id());



                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }

    public void updateUser(State state , Context context , CallBack callBack){

        StringRequest stringRequest= new StringRequest(Request.Method.POST, updateurl,
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
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap <String , String>map =new HashMap<>();
                map.put("state_name", state.getState_name());
                map.put("country_id ", state.getCountry_id());




                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }


    public void getoneuserstate( String state_id   , Context context , CallBack callBack) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, getoneurl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {




                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        String state_id =jsonObject.getString("state_id  ");


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
                HashMap <String , String>map =new HashMap<>();
                map.put("state_id",state_id.toString());

                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);

    }



    public void getalluserstate( String state_id  , Context context , CallBack callBack) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, getallurl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {




                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        String state_id =jsonObject.getString("state_id  ");
                        String state_name  = jsonObject.getString("state_name");
                        String country_id   = jsonObject.getString("country_id  ");
                        User_crop_sensor userCropSensor=new User_crop_sensor(state_id,state_name,country_id);
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
                HashMap <String , String>map =new HashMap<>();
                map.put("state_id ",state_id .toString());
                //map.put("state_name ",state_name .toString());
               // map.put("country_id  ",country_id  .toString());
                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);

    }





    public void deleteUser(State state , Context context , CallBack callBack){

        StringRequest stringRequest= new StringRequest(Request.Method.POST, deleteurl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String>map=new HashMap<>();
                map.put("State_id",state.getState_id());
                return map;
            }
        };
    }



}

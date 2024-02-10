package com.ltrsoft.andromotapp.pojoclass;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ltrsoft.andromotapp.interfaces.CallBack;
import com.ltrsoft.andromotapp.javaclasses.User_detail;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Userdao {

    public static final String  createurl="";
    public static final String updateurl="";
    public static final String deleteurl="";
    public  static  final String getallurl="";
    public static  final String getoneurl="https://andromot.ltr-soft.com/public/user_detail/read_user_id.php";

    public User_detail userDetail ;

private ArrayList<User_detail> list = new ArrayList<>();

    public void createUser(User_detail userDetail , Context context , CallBack callBack){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, createurl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callBack.onSuccess(response);
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
                map.put("",userDetail.getUser_fname());
                map.put("USER_FNAME",userDetail.getUser_fname());
                map.put("USER_MNAME",userDetail.getUser_fname());
                map.put("USER_LNAME",userDetail.getUser_fname());
                map.put("EMAIL+_ID",userDetail.getUser_fname());
                map.put("USER_PHONE",userDetail.getUser_fname());
                map.put("USER_IMAGE",userDetail.getUser_fname());
                map.put("USER_ADDRESS",userDetail.getUser_fname());
                map.put("STATE",userDetail.getUser_fname());
                map.put("CITY",userDetail.getUser_fname());
                map.put("COUNTRY",userDetail.getUser_fname());
                map.put("DISTRICT",userDetail.getUser_fname());

                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }


    public void updateUser(User_detail userDetail , Context context , CallBack callBack){

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
                    map.put("",userDetail.getUser_fname());
                    map.put("USER_FNAME",userDetail.getUser_fname());
                    map.put("USER_MNAME",userDetail.getUser_fname());
                    map.put("USER_LNAME",userDetail.getUser_fname());
                    map.put("EMAIL+_ID",userDetail.getUser_fname());
                    map.put("USER_PHONE",userDetail.getUser_fname());
                    map.put("USER_IMAGE",userDetail.getUser_fname());
                    map.put("USER_ADDRESS",userDetail.getUser_fname());
                    map.put("STATE",userDetail.getUser_fname());
                    map.put("CITY",userDetail.getUser_fname());
                    map.put("COUNTRY",userDetail.getUser_fname());
                    map.put("DISTRICT",userDetail.getUser_fname());

                    return map;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(context);
            requestQueue.add(stringRequest);
        }

    public void deleteUser(User_detail userDetail , Context context , CallBack callBack){


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
                map.put("User_id",userDetail.getUser_fname());
                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
        }

    public void getoneuserdetail( Context context , CallBack callBack) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, getoneurl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {




                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);


                        String USER_FNAME = jsonObject.getString("user_fname");
                        String USER_MNAME = jsonObject.getString("user_mname");
                        String USER_LNAME = jsonObject.getString("user_lname");
                        String EMAIL = jsonObject.getString("user_email");
                        String USER_PHONE = jsonObject.getString("user_phone");
                        String USER_IMAGE = jsonObject.getString("user_image");
                        String USER_ADDRESS = jsonObject.getString("user_address");
                        String STATE = jsonObject.getString("user_state");
                        String CITY = jsonObject.getString("user_city");
                        String COUNTRY = jsonObject.getString("user_country");
                        String DISTRICT = jsonObject.getString("user_district");
                        Toast.makeText(context, ""+USER_FNAME.toString(), Toast.LENGTH_SHORT).show();

                        list.add(new User_detail());
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
                map.put("user_id","7");

                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);

    }

    public void getalluserdetail( String user_id, Context context , CallBack callBack) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, getallurl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {




                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);


                        String USER_FNAME = jsonObject.getString("user_fname");
                        String USER_MNAME = jsonObject.getString("user_mname");
                        String USER_LNAME = jsonObject.getString("user_lname");
                        String EMAIL = jsonObject.getString("user_email");
                        String USER_PHONE = jsonObject.getString("user_phone");
                        String USER_IMAGE = jsonObject.getString("user_image");
                        String USER_ADDRESS = jsonObject.getString("user_address");
                        String STATE = jsonObject.getString("user_state");
                        String CITY = jsonObject.getString("user_city");
                        String COUNTRY = jsonObject.getString("user_country");
                        String DISTRICT = jsonObject.getString("user_district");

                        list.add(new User_detail());
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
                map.put("user_id",user_id);

                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);

    }



}



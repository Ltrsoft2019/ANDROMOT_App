package com.ltrsoft.andromotapp.pojoclass;


import android.content.Context;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.ltrsoft.andromotapp.interfaces.CallBack;
import com.ltrsoft.andromotapp.javaclasses.User_crop_sensor;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Usercrop {
    public static final String  createurl="";
    public static final String updateurl="";
    public static final String deleteurl="";
    public  static  final String INVESTIGATION_URL="https://andromot.ltr-soft.com/crop_detail/recent_crop.php";
    public static  final String userurl="https://andromot.ltr-soft.com/crop_detail/recent_crop.php";

    public User_crop_sensor user_crop_sensor ;

    private ArrayList<User_crop_sensor> list1 = new ArrayList<>();
    public void createUser(User_crop_sensor user_crop_sensor , Context context , CallBack callBack){
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
//                map.put("crop_id ", user_crop_sensor.getCrop_id());
//                map.put("sensor_id  ", user_crop_sensor.getSensor_id());


                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }

    public void updateUser(User_crop_sensor user_crop_sensor, Context context , CallBack callBack){

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
//                map.put("crop_id ", user_crop_sensor.getCrop_id());
//                map.put("sensor_id  ", user_crop_sensor.getSensor_id());


                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }



    public void getuser(final Context context , RecyclerView recyclerView, CallBack
            callBack) {
        StringRequest request = new StringRequest(Request.Method.POST, userurl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        String id = jsonObject.getString("crop_name");
                        String name = jsonObject.getString("description");
                        String vallue = jsonObject.getString("required_threshold_value");
                        String created_at = jsonObject.getString("created_at");
                        String des = jsonObject.getString("deleted_at");

                        Toast.makeText(context, "" + name, Toast.LENGTH_SHORT).show();

                        list1.add(new User_crop_sensor(id ,name ,des,vallue,created_at,""));

                    }
                } catch (JSONException ex) {
                    throw new RuntimeException(ex);
                }


                callBack.onSuccess(list1);
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(context, "Error: " + error, Toast.LENGTH_SHORT).show();
                callBack.onError(error.toString());
            }
        }){

            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String>map=new HashMap<>();
                map.put("user_id ", "4");
                return map;
            }

        };

        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(request);
    }





    public void getall(final Context context , CallBack
            callBack) {
        StringRequest request = new StringRequest(Request.Method.POST, INVESTIGATION_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                        JSONArray jsonArray = new JSONArray(response);
                              for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                                    String id = jsonObject.getString("crop_name");
                                    String name = jsonObject.getString("description");
                                    String vallue = jsonObject.getString("required_threshold_value");
                                    String created_at = jsonObject.getString("created_at");
                                    String des = jsonObject.getString("deleted_at");

                                Toast.makeText(context, "" + name, Toast.LENGTH_SHORT).show();

                                list1.add(new User_crop_sensor(id ,name ,des,vallue,created_at,""));

                            }
                    } catch (JSONException ex) {
                    throw new RuntimeException(ex);
                }


               callBack.onSuccess(list1);
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(context, "Error: " + error, Toast.LENGTH_SHORT).show();
               callBack.onError(error.toString());
            }
        }){


        };

        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(request);
    }





    public void deleteUser(User_crop_sensor user_crop_sensor, Context context , CallBack callBack){
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
                map.put("user_crop_sensor_id ", user_crop_sensor.getId());
                return map;
            }
     };
}



}

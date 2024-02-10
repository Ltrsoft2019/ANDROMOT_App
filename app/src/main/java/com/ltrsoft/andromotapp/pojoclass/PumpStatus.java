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
import com.ltrsoft.andromotapp.javaclasses.User_pump_status;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PumpStatus {

    public static final String CREATE_URL = "";
    public static final String UPDATE_URL = "";
    public static final String DELETE_URL = "";
    public static final String PUMP_STATUS_URL = "https://andromot.ltr-soft.com/user_pump_status/r_user_p_status.php";

    private ArrayList<User_pump_status> pumpStatusList = new ArrayList<>();

    public void createUserPumpStatus(User_pump_status userPumpStatus, Context context, CallBack callBack) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, CREATE_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callBack.onSuccess(response);
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
                // Add parameters specific to pump status creation
                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }

    public void updateUserPumpStatus(User_pump_status userPumpStatus, Context context, CallBack callBack) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, UPDATE_URL,
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
                // Add parameters specific to pump status update
                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }

    public void getUserPumpStatus(final Context context, RecyclerView recyclerView, CallBack callBack) {
        StringRequest request = new StringRequest(Request.Method.POST, PUMP_STATUS_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        String fname = jsonObject.getString("user_mname");
                        String pumpStatus = jsonObject.getString("pump_status");
                        String phone = jsonObject.getString("user_phone");
                        String address = jsonObject.getString("user_address");

                        Toast.makeText(context, "Your name: " + fname, Toast.LENGTH_SHORT).show();

                        pumpStatusList.add(new User_pump_status(fname, pumpStatus, phone, address));
                    }
                } catch (JSONException ex) {
                    throw new RuntimeException(ex);
                }

                callBack.onSuccess(pumpStatusList);
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.onError(error.toString());
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> map = new HashMap<>();
                map.put("user_id","7");
                return map;
            }
        };

        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(request);
    }

    public void deleteUserPumpStatus(User_pump_status userPumpStatus, Context context, CallBack callBack) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, DELETE_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Handle response after deleting pump status
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
             //   map.put("user_pump_status_id", userPumpStatus.getId());
                return map;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }
}

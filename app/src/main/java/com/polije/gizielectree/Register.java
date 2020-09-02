package com.polije.gizielectree;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.polije.gizielectree.Model.WebApiService;

import java.util.HashMap;
import java.util.Map;

import static com.android.volley.VolleyLog.TAG;

public class Register extends Activity {
String api;
Button register;
WebApiService webApiService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        webApiService = new WebApiService();
        api = webApiService.getApi_url();
        register = findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
    }
    public void register(){
        RequestQueue queue = Volley.newRequestQueue(Register.this);
        StringRequest sr = new StringRequest(Request.Method.POST,api+"User", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "onErrorResponse: ", error);
            }
        }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put("api","register");
                params.put("username","qqq");
                params.put("fullname","qwe");
                params.put("age","12");
                params.put("password","dd");
                params.put("email","ss");

                return params;
            }

        };
        queue.add(sr);
    }
}

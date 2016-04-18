package com.sqrl.sqrl_android.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.sqrl.sqrl_android.R;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button RegisterButton = (Button) findViewById(R.id.register_button);

        RegisterButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(myintent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void httpSend(View vew) {
        //Test the Volley HTTP library to send data
        Log.d("http test", "http test button pressed");

        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://requestb.in/wfou7pwf";
        Log.d("http test", "testing volley");

        // Request a string response from the provided URL.
        /*StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    public void onResponse(String response) {
                        // Display the frist 500 characters of the response string.
                        if(response.length() > 500) {
                            Log.d("response", "Response is: " + response.substring(0, 500));
                        } else {
                            Log.d("response", "Response is: " + response);
                        }

                    }
                }, new Response.ErrorListener() {
                    public void onErrorResponse(VolleyError error) {
                        Log.d("response err", "that didn't work!");
                    }
                });
                */

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    public void onResponse(String response) {
                        // Display the frist 500 characters of the response string.
                        if(response.length() > 500) {
                            Log.d("response", "Response is: " + response.substring(0, 500));
                        } else {
                            Log.d("response", "Response is: " + response);
                        }

                    }
                }, new Response.ErrorListener() {
                    public void onErrorResponse(VolleyError error) {
                        Log.d("response err", "that didn't work!");
                    }
            }
        ) {
            protected Map<String, String> getParams() throws com.android.volley.AuthFailureError {
              Map<String, String> params = new HashMap<String, String>();
                params.put("param1", "post param 1");
                params.put("param2", "post param 2");
                return params;
            };
        };

        queue.add(stringRequest);
        Log.d("http test", "tested volley");
    }
}

package com.example.labotech.labotech;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {

    Button btnLogin;
    EditText txtLogin, txtPassword;
    ProgressDialog loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = (Button) findViewById(R.id.btnlogin);
        txtLogin = (EditText)findViewById(R.id.txtlogin);
        txtPassword = (EditText)findViewById(R.id.txtpassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }


    private void login() {
        Toast.makeText(getApplicationContext(),"Veuillez Patienter...",Toast.LENGTH_SHORT).show();

        final String login = txtLogin.getText().toString();
        final String password = txtPassword.getText().toString();
        StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.1.13/labotech/login.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.contains("admin")) {
                            startActivity(new Intent(getApplicationContext(),AccueilAdmin.class));
                        }
                        else if (response.contains("user")) {
                            startActivity(new Intent(getApplicationContext(),AccueilUser.class));
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Echec de connexion: Identifiants invalides!",Toast.LENGTH_LONG).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("user_login",login);
                params.put("user_password",password);

                return params;
            }
        };

        Volley.newRequestQueue(this).add(request);

    }

}

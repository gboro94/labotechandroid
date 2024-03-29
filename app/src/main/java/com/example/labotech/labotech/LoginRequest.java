package com.example.labotech.labotech;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest extends StringRequest {

    private static final String URL = "http://192.168.1.13/login.php";
    private Map<String, String> params;

    public LoginRequest(String login, String password, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);
        params = new HashMap<>();
        params.put("user_login", login);
        params.put("user_password", password);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}

package com.example.study.api.execute;

import com.google.gson.JsonObject;
import java.net.HttpURLConnection;
import java.util.Map;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class ApiGetter implements ApiExecutor{

    protected final HttpURLConnection connection;

    protected final JsonObject json;

    protected final Map<String, Object> param;


}
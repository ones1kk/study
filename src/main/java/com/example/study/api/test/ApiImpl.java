package com.example.study.api.test;

import com.example.study.api.EntitySetter;
import java.util.Map;

public class ApiImpl extends TestGetter{

    public ApiImpl(EntitySetter setter) {
        super(setter);
    }

    @Override
    public ApiInterface put(Map<String, String> param) {
        return null;
    }
}

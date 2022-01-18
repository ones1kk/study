package com.example.study.refactor.execute;

import com.example.study.refactor.EntitySetterV2;
import java.util.Map;

public interface ApiExecutorV2 {

    public EntitySetterV2 put(Map<String, String> param);

}

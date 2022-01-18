package com.example.study.api.test;

import com.example.study.api.EntitySetter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public abstract class TestGetter implements ApiInterface {

    protected final EntitySetter setter;

    // protected final Apiproperty apiProperty

}

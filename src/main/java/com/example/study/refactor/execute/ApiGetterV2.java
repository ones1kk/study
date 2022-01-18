package com.example.study.refactor.execute;

import com.example.study.refactor.EntitySetterV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Component
public abstract class ApiGetterV2 implements ApiExecutorV2 {

    private final EntitySetterV2 entitySetterV2;

    private final RestTemplate restTemplate;

    // protected final Apiproperty apiProperty

    /* 임시 */
    protected String appKey;

    protected String url = url = "http://api.koreannet.or.kr/mobileweb/stdprd/loginAction.do";
    ;
}

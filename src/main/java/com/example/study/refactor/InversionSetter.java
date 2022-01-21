package com.example.study.refactor;

import com.example.study.refactor.model.ApiProperty;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InversionSetter {

    protected Map<String, String> body;

    protected final ApiProperty apiProperty;

    protected final ApiSender sender;

    protected String url;

    protected HttpHeaders setHeaders(String appKey) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("appKey", appKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        return headers;
    }

}

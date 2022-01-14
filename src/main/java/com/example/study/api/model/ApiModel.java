package com.example.study.api.model;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toMap;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.util.Assert;

@Getter
@AllArgsConstructor
public enum ApiModel {

    LOGIN("LOGIN_API"),

    TEST("TEST");

    private String code;

    private static final Map<String, ApiModel> $CODE_LOOKUP = EnumSet.allOf(ApiModel.class).stream()
        .collect(collectingAndThen(toMap(it -> it.code, it -> it), Collections::unmodifiableMap));

    public static boolean contains(String code) {
        return $CODE_LOOKUP.containsKey(code);
    }

    public static ApiModel from(String code) {
        Assert.doesNotContain(code, "Enumeration has no value");
        return $CODE_LOOKUP.get(code);
    }


}

package com.yukicris.baseUpgrade.Day1._01知识回顾;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public enum Demo2 {
    CREATED("1","CESHI1","CREATED"),

    CHARGING("2","CESHI2","CHARGING");
    @JsonValue
    private final String status;
    private final String mean;
    private final String ocStatus;

    private static final Map<String,Demo2> STATUS_MAPPING = Arrays.stream(values()).collect(Collectors.toMap(Demo2::getOcStatus, Function.identity()));

    @JsonCreator
    public static Demo2 byStatus(String ocStatus) { return STATUS_MAPPING.get(ocStatus);}

    private static final Map<String, Demo2> OMC_STATUS_MAPPING = Arrays.stream(values()).collect(Collectors.toMap(Demo2::getStatus,Function.identity()));

    @JsonCreator
    public static Demo2 byOmcStatus(String status) {return OMC_STATUS_MAPPING.get(status); }




}

package com.hiyen.datacollection.common.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonResponse<T> {

    private String msg;
    private T data;

    public CommonResponse(final String msg, final T data) {
        this.msg = msg;
        this.data = data;
    }

    public static<T> CommonResponse<T> from(final String msg, final T data) {
        return new CommonResponse<>(msg, data);
    }
}

package com.ericstoppel.mutants.model.dtos;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ApiResponse {
    enum Result {
        SUCCESS("success"),
        ERROR("error");

        private String description;

        Result (String description){
            this.description = description;
        }

    }

    @Builder.Default
    private String result = Result.SUCCESS.description;
    private Object body;

    public static ApiResponse error(){
        return ApiResponse.builder()
                .result(Result.ERROR.description)
                .build();
    }

    public ApiResponse setBody(Object body){
        this.body = body;
        return this;
    }



}

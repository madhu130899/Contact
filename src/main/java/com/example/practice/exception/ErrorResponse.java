package com.example.practice.exception;

import java.util.ArrayList;
import java.util.List;

public class ErrorResponse {
   private String field;
    private List<String> message=new ArrayList<>();
    public ErrorResponse(String field,List<String> message){
        super();
        this.field=field;
        this.message=message;
    }
}

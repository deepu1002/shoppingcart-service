package com.mindtree.model;

import lombok.Data;

@Data
public class ErrorItem {
    private String code;
    private String message;

    @Override
    public String toString() {
        return "ErrorItem{" + "code='" + code + '\'' + ", message='" + message + '\'' + '}';
    }
}

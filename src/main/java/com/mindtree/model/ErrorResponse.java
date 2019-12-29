package com.mindtree.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ErrorResponse {
    private List<ErrorItem> errors = new ArrayList<>();

    public void addError(ErrorItem error) {
        this.errors.add(error);
    }
}
package com.nimvb.app.model;

import lombok.Getter;

import java.util.HashMap;

public class ExpressionContext {
    @Getter
    private HashMap<String, Double> variables = new HashMap<>();
}

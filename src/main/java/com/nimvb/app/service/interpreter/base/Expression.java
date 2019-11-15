package com.nimvb.app.service.interpreter.base;

import com.nimvb.app.model.ExpressionContext;

public interface Expression {

    double interpret(ExpressionContext context);
}

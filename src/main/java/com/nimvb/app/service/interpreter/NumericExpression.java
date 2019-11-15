package com.nimvb.app.service.interpreter;

import com.nimvb.app.model.ExpressionContext;
import com.nimvb.app.service.interpreter.base.Expression;

public class NumericExpression implements Expression {

    private double number;

    public NumericExpression(double number) {

        this.number = number;
    }

    @Override
    public double interpret(ExpressionContext context) {
        return number;
    }
}

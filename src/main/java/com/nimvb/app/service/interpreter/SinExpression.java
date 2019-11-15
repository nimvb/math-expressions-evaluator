package com.nimvb.app.service.interpreter;

import com.nimvb.app.model.ExpressionContext;
import com.nimvb.app.service.interpreter.base.Expression;

public class SinExpression implements Expression {

    private Expression expression;

    public SinExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public double interpret(ExpressionContext context) {
        return Math.sin(expression.interpret(context));
    }
}

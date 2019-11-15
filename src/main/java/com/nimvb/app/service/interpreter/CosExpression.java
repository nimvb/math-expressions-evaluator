package com.nimvb.app.service.interpreter;

import com.nimvb.app.model.ExpressionContext;
import com.nimvb.app.service.interpreter.base.Expression;

public class CosExpression implements Expression {

    private Expression expression;

    public CosExpression(Expression expression) {

        this.expression = expression;
    }

    @Override
    public double interpret(ExpressionContext context) {
        return Math.cos(this.expression.interpret(context));
    }
}

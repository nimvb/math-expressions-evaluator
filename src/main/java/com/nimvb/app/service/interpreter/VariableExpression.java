package com.nimvb.app.service.interpreter;

import com.nimvb.app.model.ExpressionContext;
import com.nimvb.app.service.interpreter.base.Expression;

public class VariableExpression implements Expression {

    private String variable;

    public VariableExpression(String variable) {

        this.variable = variable;
    }

    @Override
    public double interpret(ExpressionContext context) {
        if (!context.getVariables().containsKey(this.variable)) {
            context.getVariables().put(this.variable, 0.0);
        }
        return context.getVariables().get(variable);
    }
}

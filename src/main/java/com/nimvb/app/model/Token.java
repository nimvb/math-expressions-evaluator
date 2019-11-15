package com.nimvb.app.model;

import com.nimvb.app.service.misc.Cloneable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Token implements Cloneable<Token> {
    private TokenType type;
    private String    value;

    @Override
    public Token clone() {
        return new Token(this.getType(), this.getValue());
    }
}

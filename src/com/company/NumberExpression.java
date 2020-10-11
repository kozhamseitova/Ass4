package com.company;

public class NumberExpression implements Expression {

    public int number;

    public NumberExpression(int number) {
        this.number = number;
    }

    @Override
    public int interpreter() {
        return number;
    }
}

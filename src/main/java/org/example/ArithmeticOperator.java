package org.example;

import java.util.Arrays;

public enum ArithmeticOperator {

    ADDITION("+") {
        @Override
        public int arithmeticCalculate(PositiveNumber operand1, PositiveNumber operand2) {
            return operand1.toint() + operand2.toint();
        }
    }, SUBSTRACTION("-") {
        @Override
        public int arithmeticCalculate(PositiveNumber operand1, PositiveNumber operand2) {
            return operand1.toint() - operand2.toint();
        }
    }, MULTIPLICATION("*") {
        @Override
        public int arithmeticCalculate(PositiveNumber operand1, PositiveNumber operand2) {
            return operand1.toint() * operand2.toint();
        }
    }, DIVISION("/") {
        @Override
        public int arithmeticCalculate(PositiveNumber operand1, PositiveNumber operand2) {
            return operand1.toint() / operand2.toint();
        }
    };

    private final String operator;

    ArithmeticOperator(String operator) {
        this.operator = operator;
    }

    public abstract int arithmeticCalculate(final PositiveNumber operand1, final PositiveNumber operand2);

    public static int calculate(PositiveNumber operand1, String operator, PositiveNumber operand2) {
        ArithmeticOperator arithmeticOperator = Arrays.stream(values())
                .filter(v -> v.operator.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));

        return arithmeticOperator.arithmeticCalculate(operand1, operand2);
    }
}

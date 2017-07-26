package ExpressionOP.Operations;

import ExpressionOP.Expressions.Core.Expression;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Sem on 25-Jul-17.
 */
public class Operation {

    protected OperationType type;
    protected float val;
    protected short precedence;

    public static final OperationType[] operators = {OperationType.DIVISION, OperationType.MULTIPLICATION, OperationType.SUBTRACTION, OperationType.SUMMATION};
    public static final OperationType[] nihilOperators = {OperationType.VALUE};
    public static final OperationType[] monoOperators = {};
    public static final OperationType[] binaryOperators = {OperationType.DIVISION, OperationType.MULTIPLICATION, OperationType.SUBTRACTION, OperationType.SUMMATION};

    public Operation(OperationType type, float val, short precedence) {
        this.type = type;
        this.val = val;
        this.precedence = precedence;
    }

    public float getVal() {
        return val;
    }

    public OperationType getType() {
        return type;
    }

    public short getPrecedence() {
        return precedence;
    }
}

package ExpressionOP.Factories;

import ExpressionOP.Operations.Operation;
import ExpressionOP.Operations.OperationType;

/**
 * Created by Sem on 25-Jul-17.
 */
public class OperationFactory {
    public static Operation createOperand(float val) {
        return new Operation(OperationType.VALUE, val, (short)90);
    }

    public static Operation createDivisionOperator() {
        return new Operation(OperationType.DIVISION, 0, (short)60);
    }

    public static Operation createMultiplicationOperator() {
        return new Operation(OperationType.MULTIPLICATION, 0, (short)60);
    }

    public static Operation createSubtractionOperator() {
        return new Operation(OperationType.SUBTRACTION, 0, (short)30);
    }

    public static Operation createSummationOperator() {
        return new Operation(OperationType.SUMMATION, 0, (short)30);
    }
}

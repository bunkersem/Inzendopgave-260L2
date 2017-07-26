package app;

import ExpressionOP.Operations.Operation;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by Sem on 25-Jul-17.
 */
public class Helpers {
    public static final NumberFormat nf = new DecimalFormat("##.#######");
    public static String getOperationName(Operation op) {
        switch (op.getType()){

            case DIVISION:
                return "/";
            case MULTIPLICATION:
                return "*";
            case SUBTRACTION:
                return "-";
            case SUMMATION:
                return "+";
            case VALUE:
                return nf.format( op.getVal() );
            default:
                throw new IllegalStateException("unrecognized operation type.");
        }
    }
}

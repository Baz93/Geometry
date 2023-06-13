package math.entities;

import java.util.List;

import math.functions.Function;
import math.types.PrimitiveType;
import math.types.Type;

public class RealNumber {
    public static final Type type = new PrimitiveType("RealNumber");

    public class Value implements math.values.Value {
        private double value;

        public Value(double value) {
            this.value = value;
        }
    }

    public class Sum implements Function {
        public math.values.Value apply(List<math.values.Value> inputs) {
            assert inputs.size() == 2;
            Value lhs = (Value)inputs.get(0);
            Value rhs = (Value)inputs.get(1);
            return new Value(lhs.value + rhs.value);
        }
    }
}

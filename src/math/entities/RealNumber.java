package math.entities;

import java.util.Arrays;
import java.util.List;

import math.functions.Function;
import math.types.PrimitiveType;
import math.types.Type;

public class RealNumber {
    public static final Type type = new PrimitiveType("RealNumber");

    public static class Value implements math.values.Value {
        private final double value;

        public Value(double value) {
            this.value = value;
        }
    }

    public static class UnaryMinus implements Function {    
        public List<Type> inputTypes() {
            return Arrays.asList(type);
        }
        public Type outputType() {
            return type;
        }
        public math.values.Value apply(List<math.values.Value> inputs) {
            assert inputs.size() == 1;
            Value val = (Value)inputs.get(0);
            return new Value(-val.value);
        }
    }

    public static class Plus implements Function {  
        public List<Type> inputTypes() {
            return Arrays.asList(type, type);
        }
        public Type outputType() {
            return type;
        }
        public math.values.Value apply(List<math.values.Value> inputs) {
            assert inputs.size() == 2;
            Value lhs = (Value)inputs.get(0);
            Value rhs = (Value)inputs.get(1);
            return new Value(lhs.value + rhs.value);
        }
    }

    public static class Minus implements Function {  
        public List<Type> inputTypes() {
            return Arrays.asList(type, type);
        }
        public Type outputType() {
            return type;
        }
        public math.values.Value apply(List<math.values.Value> inputs) {
            assert inputs.size() == 2;
            Value lhs = (Value)inputs.get(0);
            Value rhs = (Value)inputs.get(1);
            return new Value(lhs.value - rhs.value);
        }
    }

    public static class Multiply implements Function {  
        public List<Type> inputTypes() {
            return Arrays.asList(type, type);
        }
        public Type outputType() {
            return type;
        }
        public math.values.Value apply(List<math.values.Value> inputs) {
            assert inputs.size() == 2;
            Value lhs = (Value)inputs.get(0);
            Value rhs = (Value)inputs.get(1);
            return new Value(lhs.value * rhs.value);
        }
    }

    public static class Divide implements Function {  
        public List<Type> inputTypes() {
            return Arrays.asList(type, type);
        }
        public Type outputType() {
            return type;
        }
        public math.values.Value apply(List<math.values.Value> inputs) {
            assert inputs.size() == 2;
            Value lhs = (Value)inputs.get(0);
            Value rhs = (Value)inputs.get(1);
            return new Value(lhs.value / rhs.value);
        }
    }
}

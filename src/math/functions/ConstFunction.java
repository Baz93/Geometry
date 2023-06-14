package math.functions;

import java.util.Arrays;
import java.util.List;

import math.types.Type;
import math.values.Value;

public class ConstFunction implements Function {
    private final Type type;
    private final Value value;

    public ConstFunction(Type type, Value value) {
        this.type = type;
        this.value = value;
    }

    public List<Type> inputTypes() {
        return Arrays.asList();
    }

    public Type outputType() {
        return type;
    }

    public Value apply(List<Value> inputs) {
        assert inputs.size() == 0;
        return value;
    }
}

package math.functions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import math.types.CompositeType;
import math.types.Type;
import math.types.TupleType;
import math.values.Struct;
import math.values.Tuple;
import math.values.Value;

public class BuildTuple implements Function {
    private final List<Type> funcInputTypes;
    private final Type funcOutputTypes;

    public BuildTuple(List<Type> types) {
        this.funcInputTypes = types;
        this.funcOutputTypes = new math.types.TupleType(types);
    }

    public List<Type> inputTypes() {
        return funcInputTypes;
    }

    public Type outputType() {
        return funcOutputTypes;
    }

    public Value apply(List<Value> inputs) {
        assert inputs.size() == funcInputTypes.size() : "Number of arguments don't match";
        return new Tuple(inputs);
    }
}

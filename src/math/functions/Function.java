package math.functions;

import java.util.List;

import math.types.Type;
import math.values.Value;

public interface Function {
    List<Type> inputTypes();
    Type outputType();
    Value apply(List<Value> inputs);
}

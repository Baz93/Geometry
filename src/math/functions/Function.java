package math.functions;

import java.util.List;

import math.values.Value;

public interface Function {
    Value apply(List<Value> inputs);
}

package math.functions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import math.types.CompositeType;
import math.values.Struct;
import math.values.Value;

public class BuildStruct implements Function {
    private CompositeType type;

    public Value apply(List<Value> inputs) {
        List<String> keys = type.fields.keySet().stream().toList();
        assert inputs.size() == keys.size() : "Number of fields don't match";
        Map<String, Value> fields = new HashMap<>();
        for (int i = 0; i < keys.size(); ++i) {
            fields.put(keys.get(i), inputs.get(i));
        }
        return new Struct(fields);
    }
}

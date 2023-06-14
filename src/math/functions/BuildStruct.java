package math.functions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import math.types.CompositeType;
import math.types.Type;
import math.values.Struct;
import math.values.Value;

public class BuildStruct implements Function {
    private final CompositeType type;

    public BuildStruct(CompositeType type) {
        this.type = type;
    }

    public List<Type> inputTypes() {
        return type.fieldTypes();
    }

    public Type outputType() {
        return type;
    }

    public Value apply(List<Value> inputs) {
        List<String> keys = type.fieldNames();
        assert inputs.size() == keys.size() : "Number of fields don't match";
        Map<String, Value> fields = new HashMap<>();
        for (int i = 0; i < keys.size(); ++i) {
            fields.put(keys.get(i), inputs.get(i));
        }
        return new Struct(fields);
    }
}

package math.values;

import java.util.Map;

public class Struct implements Value {
    private final Map<String, Value> fields;

    public Struct(Map<String, Value> fields) {
        this.fields = fields;
    }
}

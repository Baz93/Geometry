package math.values;

import java.util.List;

public class Tuple implements Value {
    private final List<Value> fields;

    public Tuple(List<Value> fields) {
        this.fields = fields;
    }
}

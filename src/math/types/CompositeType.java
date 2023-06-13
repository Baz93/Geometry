package math.types;

import java.util.LinkedHashMap;
import java.util.Map;

public class CompositeType implements Type {
    private final String name;
    public final Map<String, Type> fields;

    public String getName() {
        return name;
    }

    public CompositeType(String name, Iterable<Map.Entry<String, Type>> fields) {
        this.name = name;
        this.fields = new LinkedHashMap<>();
        for (Map.Entry<String, Type> item : fields) {
            this.fields.put(item.getKey(), item.getValue());
        }
    }
}

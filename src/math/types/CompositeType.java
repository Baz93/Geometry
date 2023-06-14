package math.types;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CompositeType implements Type {
    private final String name;
    public final Map<String, Type> fields;

    public CompositeType(String name, Iterable<Map.Entry<String, Type>> fields) {
        this.name = name;
        this.fields = new LinkedHashMap<>();
        for (Map.Entry<String, Type> item : fields) {
            this.fields.put(item.getKey(), item.getValue());
        }
    }

    public String getName() {
        return name;
    }

    public List<String> fieldNames() {
        return fields.keySet().stream().toList();
    }

    public List<Type> fieldTypes() {
        return fields.values().stream().toList();
    }
}

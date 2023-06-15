package math.types;

import java.util.List;

public class TupleType implements Type {
    public final List<Type> types;
    public final String name;

    public TupleType(List<Type> types) {
        this.types = types;
        this.name = composeName(types);
    }

    public static String composeName(List<Type> types) {
        StringBuilder name = new StringBuilder("Tuple[");
        for (int i = 0; i < types.size(); ++i) {
            if (i > 0) {
                name.append(',');
            }
            name.append(types.get(i));
        }
        name.append(']');
        return name.toString();
    }

    public String getName() {
        return name;
    }
}

package math.types;

public class PrimitiveType implements Type {
    private String name;

    public String getName() {
        return name;
    }

    public PrimitiveType(String name) {
        this.name = name;
    }
}

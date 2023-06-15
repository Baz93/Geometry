package graph;

import java.util.ArrayList;
import java.util.List;

import math.functions.Function;
import math.types.Type;
import math.values.Value;

public class Vertex {
    public final Type type;
    private final Function function;
    private final List<Vertex> parents;
    private Value value;

    public Vertex(Function function, List<Vertex> parents) {
        this.type = function.outputType();
        this.function = function;
        this.parents = parents;
        List<Type> expectedTypes = function.inputTypes();
        assert parents.size() == expectedTypes.size() : "Number of arguments don't match.";
        for (int i = 0; i < parents.size(); ++i) {
            assert parents.get(i).type == expectedTypes.get(i) : "Whong argument type.";
        }
    }

    public Value getValue() {
        return value;
    }

    public void evaluate() {
        List<Value> inputs = new ArrayList<>();
        for (Vertex vertex : parents) {
            inputs.add(vertex.value);
        }
        value = function.apply(inputs);
    }
}

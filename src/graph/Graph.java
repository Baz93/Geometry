package graph;

import java.util.List;

import math.functions.Function;

public class Graph {
    private List<Vertex> vertices;
    
    public Vertex apply(Function function, List<Vertex> inputs) {
        Vertex result = new Vertex(function, inputs);
        vertices.add(result);
        return result;
    }
}

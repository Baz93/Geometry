package composition;

import math.graph.Vertex;

public class Variable {
    private String command;
    private Vertex vertex;
    private Object settings;

    public Variable(String command, Vertex vertex, Object settings) {
        this.command = command;
        this.vertex = vertex;
        this.settings = settings;
    }
}

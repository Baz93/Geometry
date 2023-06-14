package composition;

import graph.Vertex;

public class Variable {
    private final String command;
    public final Vertex vertex;
    private final Object settings;

    public Variable(String command, Vertex vertex, Object settings) {
        this.command = command;
        this.vertex = vertex;
        this.settings = settings;
    }
}

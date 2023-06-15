package graph;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import math.types.Declaration;
import math.types.Type;

public class Tool {
    private final Map<String, Tool> tools; 
    private final List<Declaration> inputs;
    private final List<String> commands;
    private final List<Declaration> outputs;

    public Tool(
        Map<String, Tool> tools,
        List<Declaration> inputs,
        List<String> commands,
        List<Declaration> outputs
    ) {
        this.tools = tools;
        this.inputs = inputs;
        this.commands = commands;
        this.outputs = outputs;
    }
    
    public List<Type> inputTypes() {
        List<Type> result = new ArrayList<>();
        for (Declaration item : inputs) {
            result.add(item.type);
        }
        return result;
    }

    public List<Type> outputTypes() {
        List<Type> result = new ArrayList<>();
        for (Declaration item : outputs) {
            result.add(item.type);
        }
        return result;
    }
}

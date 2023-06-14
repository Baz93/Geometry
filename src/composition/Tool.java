package composition;

import java.util.List;

public class Tool {
    private final List<String> inputs;
    private final List<String> commands;
    private final List<String> outputs;

    public Tool(List<String> inputs, List<String> commands, List<String> outputs) {
        this.inputs = inputs;
        this.commands = commands;
        this.outputs = outputs;
    }
}

package composition;

import java.nio.CharBuffer;
import java.util.Map;

import math.graph.Vertex;

public class Composition {
    private Map<String, Tool> tools;
    private Map<String, Variable> variables;

    public class CommandReader {
        String str;
        int pos;

        public CommandReader(String str) {
            this.str = str.replaceAll("s+", "");
            this.pos = 0;
        }

        public String readName() {
            assert Character.isLetter(currentChar()) : "Names should start with a letter.";
            StringBuilder name = new StringBuilder();
            while (Character.isLetter(currentChar())) {
                name.append(readChar());
            }
            return name.toString();
        }

        public char currentChar() {
            return (pos < str.length()) ? str.charAt(pos) : '\n';
        }

        public char readChar() {
            return str.charAt(pos++);
        }
    }

    public Vertex calcAddendum(CommandReader reader, boolean canStartWithMinus) {
        Vertex cur = null;
        if (reader.currentChar() == '(') {
            reader.readChar();
            cur = calcExpression(reader);
            assert reader.readChar() == ')' : "')' expected.";
        }
        
        return cur;
    }

    public Vertex calcExpression(CommandReader reader) {
        Vertex cur = calcAddendum(reader, true);
        while (")\n".indexOf(reader.currentChar()) == -1) {
            char sign = reader.readChar();
            Vertex next = calcAddendum(reader, false);
            
        }
        return cur;
    }

    public Variable applyCommand(String command) {
        CommandReader reader = new CommandReader(command);
        String name = reader.readName();
        assert reader.readChar() == '=' : "'=' expected.";
        Vertex vertex = calcExpression(reader);
        Variable variable = new Variable(command, vertex, new Object());
        variables.put(name, variable);
        return variable;
    }
}

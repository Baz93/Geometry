package composition;

import java.util.Arrays;
import java.util.Map;

import graph.Graph;
import graph.Vertex;
import math.entities.RealNumber;
import math.functions.ConstFunction;
import math.values.Value;

public class Composition {
    private Map<String, Tool> tools;
    private Map<String, Variable> variables;
    private Graph graph;

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
            while (Character.isLetterOrDigit(currentChar())) {
                name.append(readChar());
            }
            return name.toString();
        }

        public double readNumber() {
            assert Character.isDigit(currentChar()) : "Numbers should start with a digit.";
            StringBuilder token = new StringBuilder();
            while (Character.isLetterOrDigit(currentChar()) || currentChar() == '.') {
                token.append(readChar());
            }
            return Double.parseDouble(token.toString());
        }

        public char currentChar() {
            return (pos < str.length()) ? str.charAt(pos) : '\n';
        }

        public char readChar() {
            return str.charAt(pos++);
        }
    }

    public Vertex calcMultiple(CommandReader reader, boolean canStartWithMinus) {
        if (reader.currentChar() == '-') {
            assert canStartWithMinus : "Inappropriate minus position.";
            reader.readChar();
            Vertex result = calcMultiple(reader, false);
            return graph.apply(new RealNumber.UnaryMinus(), Arrays.asList(result));
        }
        if (reader.currentChar() == '(') {
            reader.readChar();
            Vertex result = calcExpression(reader);
            assert reader.readChar() == ')' : "Closing parenthesis expected";
            return result;
        }
        if (Character.isDigit(reader.currentChar())) {
            double number = reader.readNumber();
            Value value = new RealNumber.Value(number);
            return new Vertex(new ConstFunction(RealNumber.type, value), Arrays.asList());
        }
        String name = reader.readName();
        return variables.get(name).vertex;
    }

    public Vertex calcAddendum(CommandReader reader, boolean canStartWithMinus) {
        Vertex cur = calcMultiple(reader, canStartWithMinus);
        while ("+-)\n".indexOf(reader.currentChar()) == -1) {
            char sign = reader.readChar();
            Vertex next = calcAddendum(reader, true);
            switch (sign) {
            case '*':
                cur = graph.apply(new RealNumber.Multiply(), Arrays.asList(cur, next));
            case '/':
                cur = graph.apply(new RealNumber.Divide(), Arrays.asList(cur, next));
            default:
                throw new RuntimeException("Unprocessed case.");
            }
        }
        return cur;
    }

    public Vertex calcExpression(CommandReader reader) {
        Vertex cur = calcAddendum(reader, true);
        while (")\n".indexOf(reader.currentChar()) == -1) {
            char sign = reader.readChar();
            Vertex next = calcAddendum(reader, false);
            switch (sign) {
            case '+':
                cur = graph.apply(new RealNumber.Plus(), Arrays.asList(cur, next));
            case '-':
                cur = graph.apply(new RealNumber.Minus(), Arrays.asList(cur, next));
            default:
                throw new RuntimeException("Unprocessed case.");
            }
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

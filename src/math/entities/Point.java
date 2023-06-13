package math.entities;

import java.util.AbstractMap;
import java.util.Arrays;

import math.types.CompositeType;
import math.types.Type;

public class Point {
    public static final Type type = new CompositeType("RealNumber", Arrays.asList(
        new AbstractMap.SimpleEntry<>("x", RealNumber.type),
        new AbstractMap.SimpleEntry<>("y", RealNumber.type)
    ));
}

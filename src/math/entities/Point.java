package math.entities;

import java.util.Arrays;

import math.types.CompositeType;
import math.types.Declaration;
import math.types.Type;

public class Point {
    public static final Type type = new CompositeType("RealNumber", Arrays.asList(
        new Declaration("x", RealNumber.type),
        new Declaration("y", RealNumber.type)
    ));

    
    public String midPoint = "c = Point((a.x + b.x) / 2, (a.y + b.y) / 2)";
}

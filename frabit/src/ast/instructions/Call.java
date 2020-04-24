package ast.instructions;

import java.util.List;

import ast.expressions.Expression;

public class Call extends Instruction{

    private String identifier;
    private List<Expression> arguments;

    public Call(String id, List<Expression> args) {
	identifier = id;
	arguments = args;
    }
}

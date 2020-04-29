package ast;

public final class AstUtils {
    public static final String NEW_BRANCH_DELIMITER = "├── ";
    public static final String LAST_BRANCH_DELIMITER = "└── ";
    public static final String INNER_SEPARATION = "|   ";
    public static final String BLANK_SEPARATION = "    ";

    public static final String PROGRAM_HEADER = "PROGRAM ";
    public static final String PROCEDURE_HEADER = "PROCEDURE ";
    public static final String FUNCTION_HEADER = "FUNCTION ";
    public static final String TYPE_HEADER = "TYPE: ";
    public static final String PARAMS_DEF_HEADER = "PARAMETERS: ";
    public static final String PARAMS_HEADER = "PARAMETERS: ";
    public static final String PARAM_HEADER = "PARAMETER: ";
    public static final String ID_HEADER = "ID: ";
    public static final String INSTRUCTIONS_HEADER = "STATEMENTS: ";
    public static final String RETURN_HEADER = "RETURN: ";
    public static final String DEFINITION_HEADER = "DEFINITION: ";
    // TODO: Not used, but could be used. Do we want to?
    public static final String INIT_EXPRESSION_HEADER = "INITIALIZATION: ";
    public static final String ASSIGNMENT_HEADER = "ASSIGNMENT: ";
    public static final String INVOKE_HEADER = "INVOKE: ";
    public static final String WHILE_HEADER = "WHILE: ";
    public static final String SWITCH_HEADER = "SWITCH: ";
    public static final String IFELSE_HEADER = "IFELSE: ";
    public static final String IF_HEADER = "IF: ";
    public static final String CASE_HEADER = "CASE: ";
    public static final String DEFAULT_HEADER = "DEFAULT: ";
    // TODO: Used, but potentially redundant
    public static final String VAR_ACCESS_HEADER = "VARIABLE: ";
    // TODO: Unused, I prefer it this way but tell me your thoughts
    public static final String EXPRESSION_HEADER = "EXPRESSION: ";
    public static final String ARRAY_HEADER = "ARRAY: ";
    public static final String ARRAY_ACCESS_HEADER = "[]: ";
    public static final String REGISTER_HEADER = "REGISTER: ";
    public static final String CALL_HEADER = "CALL: ";
}

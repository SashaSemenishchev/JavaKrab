package me.mrfunny.krab.members.method.body.expression;

public enum ComparisonMode {
    EQUALS("=="), NOT_EQUALS("!="), MORE("<"), LESS(">"), MORE_OR_EQUALS("<="), LESS_OR_EQUALS(">=");

    private final String javaCode;

    ComparisonMode(String javaCode) {
        this.javaCode = javaCode;
    }

    public String getJavaCode() {
        return javaCode;
    }
}

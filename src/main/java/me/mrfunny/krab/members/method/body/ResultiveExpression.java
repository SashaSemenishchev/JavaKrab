package me.mrfunny.krab.members.method.body;

public interface ResultiveExpression {
    /**
     * @return Returns a class of what expression leaves on the stack frame after.
     * Null or {@link java.lang.Object} class indicate any result
     */
    Class<?> getExpressionResult();
}

package me.mrfunny.krab.members.method.body.possibilities;

public interface ResultiveExpression extends Concatenable {
    /**
     * @return Returns a class of what expression leaves on the stack frame after.
     * Null or {@link java.lang.Object} class indicate any result
     */
    Class<?> getExpressionResult();
}

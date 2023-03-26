package me.mrfunny.krab.members.method.body.statement;

import me.mrfunny.krab.members.common.Type;
import me.mrfunny.krab.members.method.body.Expression;
import me.mrfunny.krab.members.method.body.Statement;
import me.mrfunny.krab.members.method.body.environment.LocalVariable;

public class LocalVariableDeclarationStatement extends Statement {
    private LocalVariable wrapper = null;
    private boolean isFinal;
    private Type typeOf;
    private String name;
    private Expression declaration;

    public LocalVariableDeclarationStatement(Type typeOf, String name, Expression declaration, boolean isFinal) {
        this.typeOf = typeOf;
        this.name = name;
        this.declaration = declaration;
        this.isFinal = isFinal;
    }

    public LocalVariableDeclarationStatement(Type typeOf, String name, Expression declaration) {
        this.typeOf = typeOf;
        this.name = name;
        this.declaration = declaration;
        this.isFinal = false;
    }

    public LocalVariableDeclarationStatement setName(String name) {
        this.name = name;
        return this;
    }

    public LocalVariableDeclarationStatement setDeclaration(Expression declaration) {
        this.declaration = declaration;
        return this;
    }

    public LocalVariableDeclarationStatement setTypeOf(Type typeOf) {
        this.typeOf = typeOf;
        return this;
    }

    public String getName() {
        return name;
    }

    public Expression getDeclaration() {
        return declaration;
    }

    public Type getTypeOf() {
        return typeOf;
    }

    public LocalVariableDeclarationStatement(Type typeOf, String name) {
        this(typeOf, name, null, false);
    }

    public LocalVariableDeclarationStatement setFinal(boolean aFinal) {
        isFinal = aFinal;
        return this;
    }

    public LocalVariableDeclarationStatement(LocalVariable variable) {
        this(variable.getType(), variable.getName(), variable.getInitializer(), variable.isFinal());
        this.wrapper = variable;
    }
    @Override
    public String toJavaCode() {
        if(wrapper != null) {
            return wrapper.toJavaCode();
        }
        StringBuilder sb = new StringBuilder(typeOf.toJavaCode()).append(" ").append(name);
        if(declaration != null) {
            sb.append("=").append(Expression.toString(declaration));
        }
        return sb.toString();
    }
}

package me.mrfunny.krab.members;

public abstract class Accessible<T> {

    public Accessible(AccessModifier accessModifier, boolean isFinal, boolean isStatic, String name) {
        this.accessModifier = accessModifier;
        this.isFinal = isFinal;
        this.isStatic = isStatic;
        this.name = name;
    }

    protected AccessModifier accessModifier = AccessModifier.PACKAGE_PRIVATE;
    protected boolean isFinal;
    protected boolean isStatic;
    protected String name;
    public T setAccessModifier(AccessModifier accessModifier) {
        this.accessModifier = accessModifier;
        return (T) this;
    }
    public T setStatic(boolean s) {
        this.isStatic = s;
        return (T) this;
    }
    public T setFinal(boolean f) {
        this.isFinal = f;
        return (T) this;
    }
    public String getName() {
        return name;
    }
    public AccessModifier getAccessModifier() {
        return accessModifier;
    }

    public boolean isStatic() {
        return isStatic;
    }
    public boolean isFinal() {
        return isFinal;
    }

    public String createAccessString() {
        StringBuilder builder = new StringBuilder(getAccessModifier().toJavaCode());
        if(isStatic()) {
            builder.append(" static");
        }

        if(isFinal()) {
            builder.append(" final");
        }

        builder.append(" ").append(getName());
        return builder.toString();
    }
}

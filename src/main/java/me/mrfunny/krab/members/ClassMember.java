package me.mrfunny.krab.members;

import me.mrfunny.krab.Krab;
import me.mrfunny.krab.members.common.Type;
import me.mrfunny.krab.members.method.body.possibilities.Typeable;

public abstract class ClassMember<T extends ClassMember<T>>
        extends Accessible<T>
    implements Typeable {

    protected Type type;
    protected Krab source = null;
    public ClassMember(AccessModifier accessModifier, Type typeOf, boolean isFinal, boolean isStatic, String name) {
        super(accessModifier, isFinal, isStatic, name);
        this.type = typeOf;
    }

    public void setSource(Krab source) {
        this.source = source;
    }
}

package me.mrfunny.krab.members.method;

import me.mrfunny.krab.Krab;
import me.mrfunny.krab.members.AccessModifier;
import me.mrfunny.krab.members.common.Type;
import me.mrfunny.krab.members.method.body.Body;

public class JavaConstructor extends JavaMethod {
    public JavaConstructor(Krab source, AccessModifier accessModifier, Body body) {
        super(accessModifier, null,false, false, source.getName());
        this.body = body;
    }

    @Override
    public final JavaMethod setAbstract(boolean a) {
        throw new UnsupportedOperationException("A constructor can't be abstract");
    }

    @Override
    public final JavaMethod setFinal(boolean f) {
        throw new UnsupportedOperationException("A constructor can't be final");
    }

    @Override
    public final JavaMethod setReturnType(Type returnType) {
        throw new UnsupportedOperationException("Return type can't be changed for a constructor. " +
                "It's always implicitly void");
    }

    @Override
    public String toJavaCode() {
        StringBuilder sb = new StringBuilder(accessModifier.toJavaCode())
            .append(" ").append(source.getName());
        generateArguments(sb);
        sb.append(body.toJavaCode());

        return sb.toString();
    }
}

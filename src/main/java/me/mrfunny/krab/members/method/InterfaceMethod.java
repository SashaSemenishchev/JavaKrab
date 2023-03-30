package me.mrfunny.krab.members.method;

import me.mrfunny.krab.members.AccessModifier;
import me.mrfunny.krab.members.common.Type;
import me.mrfunny.krab.members.method.body.Body;

public class InterfaceMethod extends JavaMethod {
    public InterfaceMethod(Type returnType, boolean isStatic, String name) {
        super(AccessModifier.PUBLIC, returnType, false, isStatic, name);
    }

    public InterfaceMethod(Type returnType, boolean isStatic, String name, Body defaultImpl) {
        super(AccessModifier.PUBLIC, returnType, false, isStatic, name);
        this.body = defaultImpl;
    }

    public InterfaceMethod defaultImplementation(Body body) {
        this.body = body;
        return this;
    }

    @Override
    public String toJavaCode() {
        StringBuilder result = new StringBuilder(createAccessString());
        generateArguments(result);
        if(body != null && !isStatic) {
            return result.insert(0, "default ").toString();
        }
        return result.append(";").toString();
    }
}

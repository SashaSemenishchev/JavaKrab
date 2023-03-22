package me.mrfunny.krab.members.method;

import me.mrfunny.krab.Krab;
import me.mrfunny.krab.members.AccessModifier;
import me.mrfunny.krab.members.Accessible;
import me.mrfunny.krab.members.method.body.Body;

public class JavaConstructor extends JavaMethod {
    public JavaConstructor(Krab source, AccessModifier accessModifier, Body methodBody) {
        super(accessModifier, null,false, false, source.getName());
    }
}

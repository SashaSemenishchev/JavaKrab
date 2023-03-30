package me.mrfunny.krab;

import com.google.googlejavaformat.java.Formatter;
import com.google.googlejavaformat.java.JavaFormatterOptions;
import me.mrfunny.krab.common.ClassType;
import me.mrfunny.krab.exception.KrabException;
import me.mrfunny.krab.members.*;
import me.mrfunny.krab.members.common.Type;
import me.mrfunny.krab.members.method.InterfaceMethod;
import me.mrfunny.krab.members.method.JavaMethod;
import me.mrfunny.krab.members.method.MethodArgument;
import me.mrfunny.krab.members.method.body.Body;
import me.mrfunny.krab.members.method.JavaConstructor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class KrabImpl extends Accessible<Krab> implements Krab {
    protected final String fileName;
    protected String packageName;

    protected List<ClassMember<?>> classMembers = new ArrayList<>();
    protected List<KrabImpl> innerClasses = new ArrayList<>();
    protected List<Type> imports = new LinkedList<>();
    protected ClassType classType = ClassType.CLASS;
    protected boolean isAbstract = false;
    private boolean innerMode;
    protected KrabImpl outerClass = null;

    KrabImpl(String packageName, String className, String fileName) {
        super(AccessModifier.PACKAGE_PRIVATE, false, false, className);
        this.fileName = fileName;
        this.packageName = packageName;
    }

    @Override
    public Krab setClassType(ClassType type) {
        this.classType = type;
        return this;
    }

    @Override
    public Krab addConstructor(AccessModifier accessModifier, Body body) {
        addMember(new JavaConstructor(this, accessModifier, body));
        return this;
    }

    @Override
    public Krab addConstructor(AccessModifier accessModifier, Body body, MethodArgument... arguments) {
        addMember(new JavaConstructor(this, accessModifier, body).setArguments(arguments));
        return this;
    }

    @Override
    public Krab addField(JavaField field) {
        addMember(field);
        return this;
    }

    @Override
    public KrabImpl addMethod(JavaMethod method) {
        addMember(method);
        return this;
    }

    @Override
    public void addMember(ClassMember<?> member) {
        if(member instanceof InterfaceMethod && classType != ClassType.INTERFACE) {
            throw new KrabException(this, "Can't add an interface method to non-interface class");
        }
        member.setSource(this);
        this.classMembers.add(member);
    }

    @Override
    public Krab addInnerClass(Krab other) {
        KrabImpl otherImpl = (KrabImpl) other;
        otherImpl.packageName = this.packageName;
        otherImpl.outerClass = this;
        innerClasses.add(otherImpl);
        return this;
    }

    @Override
    public Krab addImport(Type it) {
        imports.add(it);
        return this;
    }

    @Override
    public String toJavaCode() {
        StringBuilder stringBuilder = new StringBuilder();
        if(!innerMode) {
            stringBuilder.append(packageName == null ? "" : "package " + packageName + ";");
            ArrayList<String> addedImports = new ArrayList<>(imports.size());
            processImports(this, addedImports);
            for (KrabImpl innerClass : innerClasses) {
                if(!innerClass.innerMode) throw new KrabException(innerClass, "Not inner class was registered as an inner one");
                processImports(innerClass, addedImports);
            }
            for (String addedImport : addedImports) {
                stringBuilder.append("import ").append(addedImport).append(";");
            }
        }

        stringBuilder.append(createAccessString());
        stringBuilder.append("{");

        for(ClassMember<?> member : classMembers) {
            stringBuilder.append(member.toJavaCode());
        }

        for (Krab innerClass : innerClasses) {
            stringBuilder.append(innerClass.toJavaCode());
        }

        stringBuilder.append("}");

        return stringBuilder.toString();
    }

    @Override
    public Krab setAbstract(boolean a) {
        isAbstract = a;
        return this;
    }

    @Override
    public boolean isAbstract() {
        return isAbstract;
    }

    protected Krab setInnerMode() {
        this.innerMode = true;
        return this;
    }

    @Override
    protected String createAccessString() {
        StringBuilder builder = new StringBuilder(getAccessModifier().toJavaCode());
        if(isStatic()) {
            builder.append(" static");
        }

        if(isFinal()) {
            builder.append(" final");
        }

        if(isAbstract()) {
            builder.append(" abstract");
        }

        builder.append(" ").append(classType.toJavaCode()).append(" ").append(getName());
        return builder.toString();
    }

    protected static void processImports(KrabImpl source, List<String> names) {
        for (Type anImport : source.imports) {
            String theName = anImport.toJavaCode();
            if(names.contains(theName)) continue;
            names.add(theName);
        }
    }
}

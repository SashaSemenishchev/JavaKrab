package me.mrfunny.krab;

import me.mrfunny.krab.exception.KrabException;
import me.mrfunny.krab.members.*;
import me.mrfunny.krab.members.common.Type;
import me.mrfunny.krab.members.method.JavaMethod;
import me.mrfunny.krab.members.method.body.Body;
import me.mrfunny.krab.members.method.JavaConstructor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Krab extends Accessible<Krab> implements JavaObject, Abstractable<Krab> {
    protected final String fileName;
    protected String packageName;

    protected List<ClassMember<?>> classMembers = new ArrayList<>();
    protected List<Krab> innerClasses = new ArrayList<>();
    protected List<Type> imports = new LinkedList<>();
    protected ClassType classType = ClassType.CLASS;
    protected boolean isAbstract = false;
    private boolean innerMode;
    protected Krab outerClass = null;

    private Krab(String packageName, String className, String fileName) {
        super(AccessModifier.PACKAGE_PRIVATE, false, false, className);
        this.fileName = fileName;
        this.packageName = packageName;
    }

    public Krab classType(ClassType type) {
        this.classType = type;
        return this;
    }

    public Krab addConstructor(AccessModifier accessModifier, Body body) {
        addMember(new JavaConstructor(this, accessModifier, body));
        return this;
    }

    public Krab addField(JavaField field) {
        addMember(field);
        return this;
    }

    public Krab addMethod(JavaMethod method) {
        addMember(method);
        return this;
    }

    public void addMember(ClassMember<?> member) {
        member.setSource(this);
        this.classMembers.add(member);
    }

    public Krab addInnerClass(Krab other) {
        other.packageName = this.packageName;
        other.outerClass = this;
        innerClasses.add(other);
        return this;
    }

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
            for (Krab innerClass : innerClasses) {
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

    public boolean isAbstract() {
        return isAbstract;
    }

    protected Krab setInnerMode() {
        this.innerMode = true;
        return this;
    }

    @Override
    public String createAccessString() {
        StringBuilder builder = new StringBuilder(getAccessModifier().getJavaName());
        if(isStatic()) {
            builder.append(" static");
        }

        if(isFinal()) {
            builder.append(" final");
        }

        if(isAbstract()) {
            builder.append(" abstract");
        }

        builder.append(" ").append(classType.name().toLowerCase()).append(" ").append(getName());
        return builder.toString();
    }

    public static Krab newSource(String packageName, String className) {
        return newSource(packageName, className, className + ".java");
    }
    public static Krab newSource(String packageName, String className, String fileName) {
        return new Krab(packageName, className, fileName);
    }

    public static Krab innerClass(String name) {
        return new Krab(null, name, null)
                .setInnerMode()
                .setStatic(true);
    }

    protected static void processImports(Krab source, List<String> names) {
        for (Type anImport : source.imports) {
            String theName = anImport.toJavaCode();
            if(names.contains(theName)) continue;
            names.add(theName);
        }
    }
}

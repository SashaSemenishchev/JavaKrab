package me.mrfunny.krab;

import me.mrfunny.krab.common.ClassType;
import me.mrfunny.krab.common.EnumEntry;
import me.mrfunny.krab.members.method.body.Expression;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class EnumKrab extends KrabImpl {
    private final KrabImpl normalClassMirror;
    protected List<EnumEntry> enumEntries = new LinkedList<>();
    EnumKrab(String packageName, String className, String fileName, KrabImpl normalClassMirror) {
        super(packageName, className, fileName);
        this.normalClassMirror = normalClassMirror;
        setClassType(ClassType.ENUM);
    }

    public EnumKrab addEnumEntry(String name, Expression... initializerArguments) {
        return addEnumEntry(EnumEntry.of(name, initializerArguments));
    }

    public EnumKrab setEnumEntries(List<EnumEntry> enumEntries) {
        this.enumEntries = enumEntries;
        return this;
    }

    public EnumKrab addEnumEntry(EnumEntry entry) {
        this.enumEntries.add(entry);
        return this;
    }

    @Override
    public String toJavaCode() {
        StringBuilder sb = new StringBuilder();
        processHeader(sb);
        sb.append(createAccessString())
            .append("{");
        Iterator<EnumEntry> iterator = enumEntries.iterator();
        while(iterator.hasNext()) {
            sb.append(iterator.next().toJavaCode());
            if(iterator.hasNext()) {
                sb.append(",");
            } else {
                sb.append(";");
            }
        }

        processInnerMembers(sb);
        return sb.append("}")
            .toString();
    }

    @Override
    public Krab setClassType(ClassType type) {
        if(type != ClassType.ENUM) {
            return normalClassMirror;
        }
        return super.setClassType(type);
    }

    @Override
    public EnumKrab asEnum() {
        throw new UnsupportedOperationException("This class is already an enum!");
    }
}

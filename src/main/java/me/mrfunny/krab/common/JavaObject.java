package me.mrfunny.krab.common;

import com.google.googlejavaformat.java.FormatterException;

public interface JavaObject {
    /**
     * @return String representation of valid java code of this object
     */
    String toJavaCode();
    default String toPrettyJavaCode() {
        String code = toJavaCode();
        try {
            return ConstantPool.formatter.formatSource(code);
        } catch (FormatterException e) {
            e.printStackTrace();
        }

        return code;
    }
}

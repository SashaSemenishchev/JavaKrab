package me.mrfunny.krab;

import com.google.googlejavaformat.java.Formatter;
import com.google.googlejavaformat.java.FormatterException;

public interface JavaObject {
    /**
     * @return String representation of valid java code of this object
     */
    String toJavaCode();

    default String toPrettyJavaCode() {
        String code = toJavaCode();
        try {
            return new Formatter().formatSource(code);
        } catch (FormatterException e) {
            e.printStackTrace();
        }

        return code;
    }
}

package me.mrfunny.krab.common;

import com.google.googlejavaformat.java.Formatter;
import com.google.googlejavaformat.java.JavaFormatterOptions;

public class ConstantPool {
    static Formatter formatter = new Formatter(JavaFormatterOptions.builder().style(JavaFormatterOptions.Style.AOSP).build());
}

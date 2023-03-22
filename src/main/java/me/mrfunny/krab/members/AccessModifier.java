package me.mrfunny.krab.members;

public enum AccessModifier {
    PUBLIC("public"), PRIVATE("private"), PROTECTED("protected"), PACKAGE_PRIVATE("");

    private final String javaName;

    AccessModifier(String javaName) {
        this.javaName = javaName;
    }

    public String getJavaName() {
        return javaName;
    }
}

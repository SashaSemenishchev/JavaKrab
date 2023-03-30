# Krab
A work in progress Java™ source code generator.
Fully OOP based, extensive and can be used for many tasks, such as own JVM based programming language

### Basic usage:
```java
public String generateSource() {
    return Krab.newSource("me.mrfunny", "TestClass")
        .setFinal(true)
        .access(AccessModifier.PUBLIC)
        .setAbstract(true)
        .addField(JavaField.of("world", Type.of("java.lang.String"))
            .access(AccessModifier.PRIVATE)
            .setInitializer(string("Hello, World!"))
            .setFinal(true)
        )
        .addField(JavaField.of("test", Type.of(int.class))
            .access(AccessModifier.PROTECTED)
            .setInitializer(
                newInstance(Type.of(Random.class))
                    .call("nextInt", num(100))
    )
        )
        .addInnerClass(Krab.innerClass("Hello")
            .addField(JavaField.of("name", Type.of(String.class)).setInitializer(string("heya!")))
        )
        .toPrettyJavaCode();
}
```
- Please, remember that this framework is still in progress
- It uses Google formatter to output pretty code 
- The documentation is a subject to change
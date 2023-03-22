import com.google.common.io.Files;
import me.mrfunny.krab.Krab;
import me.mrfunny.krab.members.AccessModifier;
import me.mrfunny.krab.members.JavaField;
import me.mrfunny.krab.members.Type;
import me.mrfunny.krab.members.common.UserType;
import me.mrfunny.krab.members.method.JavaMethod;
import me.mrfunny.krab.members.method.body.DefinedExpression;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import static org.junit.jupiter.api.Assertions.*;

public class KrabTest {
    @Test
    public void mainTest() throws FileNotFoundException {
        Krab krab = Krab.newSource("me.mrfunny", "TestClass")
                .setFinal(true)
                .access(AccessModifier.PUBLIC)
                .setAbstract(true)
                .addField(JavaField.of("world", Type.of("java.lang.String"))
                        .access(AccessModifier.PRIVATE)
                        .setInitializer(DefinedExpression.of("\"Hello, world!\""))
                        .setFinal(true)
                )
                .addField(JavaField.of("test", Type.of(int.class))
                        .access(AccessModifier.PROTECTED)
                        .setInitializer(DefinedExpression.of("0"))
                )
                .addInnerClass(
                        Krab.innerClass("Hello")
                            .addField(JavaField.of("name", Type.of(String.class)))
                );

        assertTrue(krab.isAbstract());
        assertTrue(krab.isFinal());
        assertEquals(krab.getAccessModifier(), AccessModifier.PUBLIC);
        PrintWriter writer = new PrintWriter("TestClass.java");
        writer.write(krab.toPrettyJavaCode());
        writer.close();
    }
}

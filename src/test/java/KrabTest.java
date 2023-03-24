import me.mrfunny.krab.Krab;
import me.mrfunny.krab.members.AccessModifier;
import me.mrfunny.krab.members.common.Type;
import me.mrfunny.krab.members.method.JavaMethod;
import me.mrfunny.krab.members.method.MethodArgument;
import me.mrfunny.krab.members.method.body.Body;
import me.mrfunny.krab.members.method.body.expression.ComparisonMode;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.concurrent.ThreadLocalRandom;

import static me.mrfunny.krab.members.method.body.Components.*;

public class KrabTest {
    @Test
    public void mainTest() throws FileNotFoundException {
//        Krab krab = Krab.newSource("me.mrfunny", "TestClass")
//                .setFinal(true)
//                .access(AccessModifier.PUBLIC)
//                .setAbstract(true)
//                .addField(worldField)
//                .addField(JavaField.of("test", Type.of(int.class))
//                        .access(AccessModifier.PROTECTED)
//                        .setInitializer(DefinedExpression.of("0"))
//                )
//                .addMethod(JavaMethod.of("test", Type.of(void.class))
//                        .access(AccessModifier.PUBLIC)
//                        .setBody(Body.of(
//                                thisClass().accessField(worldField).call("substring", num(1))
//                        ))
//                );

//        assertTrue(krab.isAbstract());
//        assertTrue(krab.isFinal());
//        assertEquals(krab.getAccessModifier(), AccessModifier.PUBLIC);
        PrintWriter writer = new PrintWriter("TestClass.java");
        String code = Krab.newSource("me.mrfunny", "TestClass")
                .setAccess(AccessModifier.PUBLIC)
                .addMethod(JavaMethod.of("main", Type.of(void.class))
                        .setAccess(AccessModifier.PUBLIC)
                        .setArguments(MethodArgument.of(Type.of(String.class).asArray(), "args"))
                        .setStatic(true)
                        .setBody(Body.of(
                                Type.of(System.class)
                                        .accessField("out")
                                        .call("println", string("Hello World!")),
                                ifStatement(conditionBranch(
                                        Type.of(ThreadLocalRandom.class)
                                                .call("current")
                                                .compare(num(100), ComparisonMode.LESS),
                                        Body.scope(
                                                Type.of(System.class)
                                                        .accessField("out")
                                                        .call("println", string("Random number is less than 100"))
                                        )
                                )).addElseIf(conditionBranch(Type.of(ThreadLocalRandom.class)
                                                        .call("nextBoolean"), Body.scope(
                                                        thisClass().call("another")
                                                )
                                        )
                                ).ifElse(Body.scope(
                                        thisClass().call("nothing")
                                ))
                        ))

                )
                .toPrettyJavaCode();
        writer.write(code);
        writer.close();
    }
}

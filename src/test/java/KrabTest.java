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
            .setAccessModifier(AccessModifier.PUBLIC)
            .addConstructor(AccessModifier.PUBLIC, Body.of(
                Type.of(System.class)
                    .accessField("out")
                    .call("println", string("Hello World"))
            ))
            .addMethod(JavaMethod.of("main", Type.VOID)
                .setAccessModifier(AccessModifier.PUBLIC)
                .setArguments(MethodArgument.of(Type.of(String.class).asArrayType(), "args"))
                .setStatic(true)
                .setBody(Body.of(
                    Type.of(System.class)
                        .accessField("out")
                        .call("println", string("Hello World!")),
                    declareLocalVariable(
                        Type.INT,
                        "random",
                        Type.of(ThreadLocalRandom.class)
                            .call("current")
                            .call("nextInt")
                    ),
                    ifStatement(
                        conditionBranch(
                            accessLocalVariable("random")
                                .compare(num(100), ComparisonMode.LESS),
                            Body.scope(
                                Type.of(System.class)
                                    .accessField("out")
                                    .call(
                                        "println",
                                        string("Random number is less than 100. Got: ").concat(accessLocalVariable("random"))
                                    )
                            )
                    )).addElseIf(conditionBranch(
                        Type.of(ThreadLocalRandom.class)
                            .call("current")
                            .call("nextBoolean"),
                        Body.scope(call("another"))
                    )).ifElse(Body.scope(
                        call("nothing")
                    ))
                ))

            )
            .addMethod(JavaMethod.of("another", Type.VOID).setStatic(true))
            .addMethod(JavaMethod.of("nothing", Type.VOID).setStatic(true))
            .toPrettyJavaCode();
        writer.write(code);
        writer.close();
    }
}

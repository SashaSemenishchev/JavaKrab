import me.mrfunny.krab.Krab;
import me.mrfunny.krab.members.AccessModifier;
import me.mrfunny.krab.members.JavaField;
import me.mrfunny.krab.members.common.Type;
import me.mrfunny.krab.members.method.JavaMethod;
import me.mrfunny.krab.members.method.MethodArgument;
import me.mrfunny.krab.members.method.body.Body;
import me.mrfunny.krab.members.method.body.DefinedStatement;
import me.mrfunny.krab.members.method.body.expression.ComparisonMode;
import me.mrfunny.krab.members.method.body.statement.NumberOutputType;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.concurrent.ThreadLocalRandom;

import static me.mrfunny.krab.members.method.body.Components.*;
import static me.mrfunny.krab.members.method.body.Macros.*;

public class KrabTest {
    @Test
    public void mainTest() throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("TestClass.java");
        String code = Krab.newSource("me.mrfunny", "TestClass")
            .setAccessModifier(AccessModifier.PUBLIC)
            .addField(JavaField.of("test", Type.LONG)
                .setInitializer(num(100)
                    .setTypeSuffix(Type.LONG)
                    .setOutputType(NumberOutputType.BINARY)
                )
            )
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
                    sout(string("Hello World!")),
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
                                sout(string("Random number is less than 100. Got: ").concat(accessLocalVariable("random")))
                            )
                        )).addElseIf(conditionBranch(
                        Type.of(ThreadLocalRandom.class)
                            .call("current")
                            .call("nextBoolean"),
                        Body.scope(call("another"))
                    )).addElse(Body.scope(
                        call("nothing")
                    ))
                ))

            )
            .addMethod(JavaMethod.of("another", Type.VOID)
                .setStatic(true)
                .setBody(Body.of(
                    forLoop(
                        declareLocalVariable(Type.INT, "i", num(0)),
                        compare(accessLocalVariable("i"), num(100), ComparisonMode.MORE),
                        DefinedStatement.of("i++"),
                        Body.scope(
                            call("println", string("Counter: ").concat(accessLocalVariable("i")))
                        )
                    )
                ))
            )
            .addMethod(JavaMethod.of("nothing", Type.VOID)
                .setStatic(true)
            )
            .addMethod(JavaMethod.of("println", Type.VOID)
                .setStatic(true)
                .setAccessModifier(AccessModifier.PUBLIC)
                .setArguments(MethodArgument.of(Type.of(String.class).asVarargs(), "toPrint"))
                .setBody(Body.of(
                    Type.of(System.class)
                        .accessField("out")
                        .call(
                            "println",
                            Type.of(String.class)
                                .call("join", string(" "), accessLocalVariable("toPrint"))
                        )
                ))
            )
            .toPrettyJavaCode();
        writer.write(code);
        writer.close();
    }
}

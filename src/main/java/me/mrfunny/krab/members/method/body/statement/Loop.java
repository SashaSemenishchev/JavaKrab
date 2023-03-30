package me.mrfunny.krab.members.method.body.statement;

import me.mrfunny.krab.members.method.MethodScope;
import me.mrfunny.krab.members.method.body.possibilities.BranchableStatement;

public interface Loop extends BranchableStatement {
    MethodScope getLoopBody();
}

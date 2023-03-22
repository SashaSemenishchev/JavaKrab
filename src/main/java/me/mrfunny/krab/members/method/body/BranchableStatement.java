package me.mrfunny.krab.members.method.body;

public interface BranchableStatement<T> {
    MethodScope<T> getBranch();
}

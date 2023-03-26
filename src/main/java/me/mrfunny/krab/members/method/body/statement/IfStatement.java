package me.mrfunny.krab.members.method.body.statement;

import me.mrfunny.krab.exception.KrabException;
import me.mrfunny.krab.members.method.body.*;
import me.mrfunny.krab.members.method.body.possibilities.BranchableStatement;
import me.mrfunny.krab.members.method.body.possibilities.ResultiveExpression;

import java.util.ArrayList;

public class IfStatement extends Statement implements BranchableStatement {
    private final ConditionBranch baseBranch;
    private BasicMethodScope<?> elseBranch;
    private final ArrayList<ConditionBranch> elseIfs = new ArrayList<>();

    public IfStatement(ConditionBranch baseBranch) {
        this.baseBranch = baseBranch;
    }

    public IfStatement(ConditionBranch baseBranch, BasicMethodScope<?> elseBranch) {
        this.baseBranch = baseBranch;
        this.elseBranch = elseBranch;
    }

    public IfStatement ifElse(BasicMethodScope<?> elseBranch) {
        this.elseBranch = elseBranch;
        return this;
    }

    public IfStatement addElseIf(ConditionBranch conditionBranch) {
        elseIfs.add(conditionBranch);
        return this;
    }

    @Override
    public String toJavaCode() {
        StringBuilder sb = new StringBuilder();

        processBranch(sb, "if", baseBranch);
        for (ConditionBranch elseIf : elseIfs) {
            processBranch(sb, "else if", elseIf);
        }

        if(elseBranch != null) {
            sb.append("else").append(elseBranch.toJavaCode());
        }
        
        return sb.toString();
    }

    protected void processBranch(StringBuilder sb, String prefix, ConditionBranch branch) {
        sb.append(prefix).append("(");
        Expression expression = branch.matcher;
        if(!(expression instanceof ResultiveExpression)) {
            throw new KrabException(null, "If statement branches should always result a boolean.");
        }
        Class<?> classOfResult = ((ResultiveExpression) expression).getExpressionResult();
        if(classOfResult != boolean.class && classOfResult != Object.class) {
            throw new KrabException(null, "If statement branches should always result a boolean.");
        }
        sb.append(Expression.toString(branch.matcher));
        sb.append(")");
        sb.append(branch.branch.toJavaCode());
    }

    public static class ConditionBranch {
        protected Expression matcher;
        protected BasicMethodScope<?> branch;

        public BasicMethodScope<?> getBranch() {
            return branch;
        }

        public Expression getMatcher() {
            return matcher;
        }

        public ConditionBranch(Expression matcher, BasicMethodScope<?> branch) {
            this.matcher = matcher;
            this.branch = branch;
        }
    }
}

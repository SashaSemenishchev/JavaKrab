package me.mrfunny.krab.members.method.body.statement;

import me.mrfunny.krab.common.JavaObject;
import me.mrfunny.krab.exception.KrabException;
import me.mrfunny.krab.members.method.body.*;
import me.mrfunny.krab.members.method.body.possibilities.BranchableStatement;
import me.mrfunny.krab.members.method.body.possibilities.ResultiveExpression;

import java.util.ArrayList;

public class IfStatement extends Statement implements BranchableStatement {
    private ConditionBranch baseBranch;
    private BasicMethodScope<?> elseBranch;
    private ArrayList<ConditionBranch> elseIfs = new ArrayList<>();

    public IfStatement(ConditionBranch baseBranch) {
        this.baseBranch = baseBranch;
    }

    public IfStatement(ConditionBranch baseBranch, BasicMethodScope<?> elseBranch) {
        this.baseBranch = baseBranch;
        this.elseBranch = elseBranch;
    }

    public IfStatement addElse(BasicMethodScope<?> elseBranch) {
        this.elseBranch = elseBranch;
        return this;
    }

    public IfStatement setBaseBranch(ConditionBranch baseBranch) {
        this.baseBranch = baseBranch;
        return this;
    }

    public IfStatement addElseIf(ConditionBranch conditionBranch) {
        elseIfs.add(conditionBranch);
        return this;
    }

    @Override
    public String toJavaCode() {
        StringBuilder sb = new StringBuilder("if");
        sb.append(baseBranch.toJavaCode());
        for (ConditionBranch elseIf : elseIfs) {
            sb.append("else if").append(elseIf.toJavaCode());
        }

        if(elseBranch != null) {
            sb.append("else").append(elseBranch.toJavaCode());
        }
        
        return sb.toString();
    }

    public static class ConditionBranch implements JavaObject {
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

        @Override
        public String toJavaCode() {
            if(!(matcher instanceof ResultiveExpression)) {
                throw new KrabException(null, "If statement branches should always result a boolean.");
            }
            Class<?> classOfResult = ((ResultiveExpression) matcher).getExpressionResult();
            if(classOfResult != boolean.class && classOfResult != Object.class) {
                throw new KrabException(null, "If statement branches should always result a boolean.");
            }
            return "(" +
                Expression.toString(matcher) +
                ")" +
                (branch == null ? "{}" : branch.toJavaCode());
        }
    }
}

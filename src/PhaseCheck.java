import org.antlr.v4.runtime.tree.ParseTreeProperty;
import java.util.*;

public class PhaseCheck extends miniJavaBaseListener
{
    ParseTreeProperty<Scope> scopes;
    GlobalScope globals;
    Scope currentScope;

    ParseTreeProperty<Type> typeprop = new ParseTreeProperty<Type>();
    public PhaseCheck(GlobalScope globals, ParseTreeProperty<Scope> scopes)
    {
        this.scopes = scopes;
        this.globals = globals;
    }

    public void enterGoal(miniJavaParser.GoalContext ctx)
    {
        currentScope = globals;
    }

    public void exitAnd(miniJavaParser.AndContext ctx)   //a && b  a and b should be both boolean
    {
        Type and_type = typeprop.get(ctx.expression(0));
        System.out.println(and_type);
    }

    public void exitIntValueOfExpression(miniJavaParser.IntValueOfExpressionContext ctx)
    {
        typeprop.put(ctx, Type.tInt);

    }
}
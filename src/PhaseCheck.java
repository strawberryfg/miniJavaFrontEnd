import org.antlr.v4.runtime.tree.ParseTreeProperty;
import java.util.*;
import org.antlr.v4.runtime.Token;
import java.util.HashMap;

public class PhaseCheck extends miniJavaBaseListener
{
    ParseTreeProperty<Scope> scopes;
    GlobalScope globals;
    Scope currentScope;

    ParseTreeProperty<Type> typeprop = new ParseTreeProperty<Type>();
    public class pair
    {
         String var_name;
         Type var_type;
         public pair(String s, Type t)
         {
             var_name = s;
             var_type = t;
         }
         public pair()
         {

         }
    }
    HashMap<String, Type> currentvarSet = new HashMap<String, Type>();   //each variable has an unique
    Set<pair> classSet = new HashSet();

    public PhaseCheck(GlobalScope globals, ParseTreeProperty<Scope> scopes)
    {
        this.scopes = scopes;
        this.globals = globals;
    }

    public void enterGoal(miniJavaParser.GoalContext ctx)
    {
        currentScope = globals;
    }

    public void exitVarOfExpression(miniJavaParser.VarOfExpressionContext ctx)
    {
        int start = ctx.start.getStartIndex();
        int stop = ctx.start.getStopIndex();
        String var_name = ctx.start.getInputStream().toString().substring(start, stop + 1);
        boolean var_find = currentvarSet.contains(var_name);
        boolean class_find = classSet.contains(var_name);
        if (!var_find && !class_find)    // the variable need to be defined does not exist right now
        {
            basic.PrintError(ctx.getStart(), " The variable you just used in the code" + var_name  + " is not a variable or a class right now!");
            basic.PrintContext(ctx.start.getInputStream().toString(), ctx.start.getLine(), ctx.start.getStartIndex(), ctx.start.getStopIndex());
        }
    }

    public void enterInsideClass(miniJavaParser.InsideClassContext ctx)
    {
        if (ctx.identifier(1) != null)   // extends     the class should exist already
        {
            int start = ctx.identifier(1).start.getStartIndex();
            int stop = ctx.identifier(1).start.getStopIndex();
            String class_name = ctx.identifier(1).start.getInputStream().toString().substring(start, stop + 1);
            if (!classSet.contains(new pair(class_name, Type.jClass)))   //the class does not exist currently
            {
                basic.PrintError(ctx.getStart(), " The extended class " + class_name + " does not exist right now! ");
                basic.PrintContext(ctx.start.getInputStream().toString(), ctx.start.getLine(), ctx.start.getStartIndex(), ctx.start.getStopIndex());
            }
        }
        int start = ctx.identifier(0).start.getStartIndex();
        int stop = ctx.identifier(0).start.getStopIndex();
        String class_name = ctx.identifier(0).start.getInputStream().toString().substring(start, stop + 1);
        classSet.add(new pair(class_name, Type.jClass));
    }

    public void exitIntValueOfExpression(miniJavaParser.IntValueOfExpressionContext ctx)   // INT in the expression
    {
        typeprop.put(ctx, Type.jInt);
    }

    public void exitDeclareVariable(miniJavaParser.DeclareVariableContext ctx)
    {
        int start = ctx.start.getStartIndex();
        int stop = ctx.start.getStopIndex();
        String var_name = ctx.start.getInputStream().toString().substring(start, stop + 1);
        if (currentvarSet.contains(var_name))
        {
            basic.PrintError(ctx.getStart(), " The variable " + var_name + " already exists right now! ");
            basic.PrintContext(ctx.start.getInputStream().toString(), ctx.start.getLine(), ctx.start.getStartIndex(), ctx.start.getStopIndex());
        }
        else
        {
            currentvarSet.add(new pair(var_name, typeprop.get(ctx.type())));
        }
    }

    public void exitIntegerArray(miniJavaParser.IntegerArrayContext ctx)
    {
        typeprop.put(ctx, Type.jArray);
    }

    public void exitBoolean(miniJavaParser.BooleanContext ctx)
    {
        typeprop.put(ctx, Type.jBool);
    }

    public void exitInteger(miniJavaParser.IntegerContext ctx)
    {
        typeprop.put(ctx, Type.jInt);
    }

    public void exitInstance(miniJavaParser.InstanceContext ctx)
    {
        typeprop.put(ctx, Type.jClass);
    }

    public void exitStringValueOfExpression(miniJavaParser.StringValueOfExpressionContext ctx)
    {
        typeprop.put(ctx, Type.jString);
    }

    public void exitBoolTrue(miniJavaParser.BoolTrueContext ctx)
    {
        typeprop.put(ctx, Type.jBool);
    }

    public void exitBoolFalse(miniJavaParser.BoolTrueContext ctx)
    {
        typeprop.put(ctx, Type.jBool);
    }

    public void exitAnd(miniJavaParser.AndContext ctx)   //a && b  a and b should be both boolean
    {
        Type and_type_0 = typeprop.get(ctx.expression(0));
        Type and_type_1 =typeprop.get(ctx.expression(1));
        if (and_type_0 != Type.jBool || and_type_1 != Type.jBool)
        {
            basic.PrintError(ctx.getStart(), " Requires Boolean and Boolean ( && operation ) but got" + and_type_0 + " and " + and_type_1);
            basic.PrintContext(ctx.start.getInputStream().toString(), ctx.start.getLine(), ctx.start.getStartIndex(), ctx.start.getStopIndex());
            typeprop.put(ctx, Type.jVoid);
        }
        else
        {
            typeprop.put(ctx, Type.jBool);
        }
    }

    public void exitLessthan(miniJavaParser.LessthanContext ctx)
    {
        Type a_type = typeprop.get(ctx.expression(0));
        Type b_type =typeprop.get(ctx.expression(1));
        if (a_type != Type.jInt || b_type != Type.jInt)
        {
            basic.PrintError(ctx.getStart(), " Requires Int and Int but ( < operation) got " + a_type + " and " + b_type);
            basic.PrintContext(ctx.start.getInputStream().toString(), ctx.start.getLine(), ctx.start.getStartIndex(), ctx.start.getStopIndex());
            typeprop.put(ctx, Type.jVoid);
        }
        else
        {
            typeprop.put(ctx, Type.jBool);
        }
    }

    public void exitMulDivide(miniJavaParser.MulDivideContext ctx)
    {
        Type a_type = typeprop.get(ctx.expression(0));
        Type b_type =typeprop.get(ctx.expression(1));
        if (a_type != Type.jInt || b_type != Type.jInt)
        {
            basic.PrintError(ctx.getStart(), " Requires Int and Int but ( * / operation) got " + a_type + " and " + b_type);
            basic.PrintContext(ctx.start.getInputStream().toString(), ctx.start.getLine(), ctx.start.getStartIndex(), ctx.start.getStopIndex());
            typeprop.put(ctx, Type.jVoid);
        }
        else
        {
            typeprop.put(ctx, Type.jInt);
        }
    }

    public void exitAddSub(miniJavaParser.AddSubContext ctx)
    {
        Type a_type = typeprop.get(ctx.expression(0));
        Type b_type =typeprop.get(ctx.expression(1));
        if (a_type != Type.jInt || b_type != Type.jInt)
        {
            basic.PrintError(ctx.getStart(), " Requires Int and Int but ( + - operation) got " + a_type + " and " + b_type);
            basic.PrintContext(ctx.start.getInputStream().toString(), ctx.start.getLine(), ctx.start.getStartIndex(), ctx.start.getStopIndex());
            typeprop.put(ctx, Type.jVoid);
        }
        else
        {
            typeprop.put(ctx, Type.jInt);
        }
    }

    public void exitGetArrayValue(miniJavaParser.GetArrayValueContext ctx)
    {
         Type var_type = typeprop.get(ctx.expression(0));
         Type id_type = typeprop.get(ctx.expression(1));  //  f[s]  f is expression(0) and s is expression(1)
         if (id_type != Type.jInt)
         {
             basic.PrintError(ctx.getStart(), " Requires the index of array to be int but got " + id_type);
             basic.PrintContext(ctx.start.getInputStream().toString(), ctx.start.getLine(), ctx.start.getStartIndex(), ctx.start.getStopIndex());
             typeprop.put(ctx, Type.jVoid);
         }
         else if (var_type != Type.jArray)
         {
             basic.PrintError(ctx.getStart(), " Requires it to be an array but got" + var_type);
             basic.PrintContext(ctx.start.getInputStream().toString(), ctx.start.getLine(), ctx.start.getStartIndex(), ctx.start.getStopIndex());
             typeprop.put(ctx, Type.jVoid);
         }
         else
         {
             typeprop.put(ctx, Type.jInt);
         }
    }

    public void exitGetLength(miniJavaParser.GetLengthContext ctx)
    {
        Type str_type = typeprop.get(ctx.expression());
        if (str_type != Type.jString)
        {
            basic.PrintError(ctx.getStart(), " Requires a string to calculate its length but got " + str_type);
            basic.PrintContext(ctx.start.getInputStream().toString(), ctx.start.getLine(), ctx.start.getStartIndex(), ctx.start.getStopIndex());
            typeprop.put(ctx, Type.jVoid);
        }
        else
        {
            typeprop.put(ctx, Type.jInt);
        }
    }
}
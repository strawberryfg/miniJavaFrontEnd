import com.intellij.vcs.log.Hash;
import com.sun.deploy.security.ValidationState;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import java.util.*;
import org.antlr.v4.runtime.Token;
import java.util.HashMap;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class PhaseCheck extends miniJavaBaseListener
{
    ParseTreeProperty<Scope> scopes;
    GlobalScope globals;
    Scope currentScope;

    ParseTreeProperty<Type> typeprop = new ParseTreeProperty<Type>();
    int now_scope = 0;
    public class class_method_pair
    {
         String class_name;
         String method_name;
         public class_method_pair(String s, String t)
         {
             class_name = s;
             method_name = t;
         }
         public class_method_pair()
         {

         }
    }
    HashMap<String, Type> currentvarSet = new HashMap<String, Type>();   //each variable has an unique
    HashMap<String, Integer> varScope = new HashMap<String, Integer>();
    HashSet<String> classSet = new HashSet<String>();
    HashMap<String, Integer> classScope = new HashMap<String, Integer>();
    HashMap<String, String> classInstanceSet = new HashMap<String, String>();   // the set of instances of classes
    Table<String, String, HashMap<Integer, Type>> method_arguments = HashBasedTable.create();

    //HashMap<class_method_pair, HashMap<Integer, Type> > method_arguments = new HashMap<class_method_pair, HashMap<Integer, Type>>(); //integer stands for the index of the arguemnt list
    String current_class_name = "";   //the name of current class    this means it

    public PhaseCheck(GlobalScope globals, ParseTreeProperty<Scope> scopes)
    {
        this.scopes = scopes;
        this.globals = globals;
        //key word which cannot be used as argument reserved word
        currentvarSet.put("class", Type.jVoid); currentvarSet.put("public", Type.jVoid); currentvarSet.put("static", Type.jVoid); currentvarSet.put("void", Type.jVoid);
        currentvarSet.put("main", Type.jVoid); currentvarSet.put("String", Type.jVoid); currentvarSet.put("extends", Type.jVoid); currentvarSet.put("return", Type.jVoid);
        currentvarSet.put("int", Type.jVoid); currentvarSet.put("int []", Type.jVoid); currentvarSet.put("boolean", Type.jVoid); currentvarSet.put("if", Type.jVoid);
        currentvarSet.put("while", Type.jVoid); currentvarSet.put("true", Type.jVoid); currentvarSet.put("false", Type.jVoid); currentvarSet.put("this", Type.jVoid);
        currentvarSet.put("new", Type.jVoid); currentvarSet.put("length", Type.jVoid); currentvarSet.put("else", Type.jVoid);

        classSet.add("class"); classSet.add("public"); classSet.add("static"); classSet.add("void");
        classSet.add("main"); classSet.add("String"); classSet.add("extends"); classSet.add("return");
        classSet.add("int"); classSet.add("int []"); classSet.add("boolean"); classSet.add("if");
        classSet.add("while"); classSet.add("true"); classSet.add("false"); classSet.add("this");
        classSet.add("new"); classSet.add("length"); classSet.add("else");
    }

    public void enterGoal(miniJavaParser.GoalContext ctx)
    {
        currentScope = globals;
    }

    public Type findType(String type_name)
    {
        switch (type_name)
        {
            case "int []":
                return Type.jArray;
            case "int":
                return Type.jInt;
            case "boolean":
                return Type.jBool;
        }
        if (classSet.contains(type_name)) return Type.jClass;
        return Type.jVoid;   // not a class or any type
    }

    public void enterEnterMainClass(miniJavaParser.EnterMainClassContext ctx)
    {
        now_scope++; //it's the first scope since it is the main class so any variable declaration in this scope should not be added permanently into the map or set
        System.out.println("fds");
        classSet.add(ctx.identifier().getText());
        classScope.put(ctx.identifier().getText(), now_scope);   // main class name
        currentvarSet.put("main", Type.jVoid);  //"main" function can not be used
        varScope.put("main", now_scope);
    }

    public void enterInsideClass(miniJavaParser.InsideClassContext ctx)
    {
        now_scope++;
        if (ctx.identifier(1) != null)   // extends     the class should exist already
        {
            int start = ctx.identifier(1).start.getStartIndex();
            int stop = ctx.identifier(1).start.getStopIndex();
            String class_name = ctx.identifier(1).start.getInputStream().toString().substring(start, stop + 1);
            if (!classSet.contains(class_name))   //the class does not exist currently
            {
                basic.PrintError(ctx.getStart(), " The extended class " + class_name + " does not exist right now! ");
                basic.PrintContext(ctx.start.getInputStream().toString(), ctx.start.getLine(), ctx.start.getStartIndex(), ctx.start.getStopIndex());
            }
        }
        int start = ctx.identifier(0).start.getStartIndex();
        int stop = ctx.identifier(0).start.getStopIndex();
        String class_name = ctx.identifier(0).start.getInputStream().toString().substring(start, stop + 1);
        current_class_name = class_name;
        if (classSet.contains(class_name))
        {
            basic.PrintError(ctx.getStart(), " The class " + class_name + " already exists right now! ");
            basic.PrintContext(ctx.start.getInputStream().toString(), ctx.start.getLine(), ctx.start.getStartIndex(), ctx.start.getStopIndex());
        }
        else
        {
            classSet.add(class_name);
            classScope.put(ctx.identifier(0).getText(), now_scope);   // map<class_name> = now_scope
        }
    }

    public void exitInsideClass(miniJavaParser.InsideClassContext ctx)
    {
        for (int i = 0; i < ctx.varDeclaration().size(); i++)
        {
            String var_name = ctx.varDeclaration(i).getChild(1).getText();
            if (currentvarSet.get(var_name) != null)
            {
                if (varScope.get(var_name) == classScope.get(ctx.identifier(0).getText()))   // is declared in the current class
                {
                    Type var_type = findType(ctx.varDeclaration(i).getChild(0).getText());
                    if (var_type != Type.jVoid)   //wrong declaration
                    {
                        if (currentvarSet.containsKey(var_name))
                        {
                            if (var_type == Type.jClass) classInstanceSet.remove(var_name);
                            currentvarSet.remove(var_name);
                            varScope.remove(var_name);
                        }
                    }
                }
            }
        }
        System.out.println("s");
    }

    public void exitDeclareVariable(miniJavaParser.DeclareVariableContext ctx)
    {
        int type_start = ctx.type().start.getStartIndex();
        int type_stop = ctx.type().start.getStopIndex();
        int identifier_start = ctx.identifier().start.getStartIndex();
        int identifier_stop = ctx.identifier().start.getStopIndex();
        String type_name = ctx.start.getInputStream().toString().substring(type_start, type_stop + 1);
        if (!type_name.equals("int []") && !type_name.equals("int") && !type_name.equals("boolean"))
        {
            if (!classSet.contains(type_name))   // does not has this class now
            {
                basic.PrintError(ctx.getStart(), " The class you are using " + type_name + " does not xists right now! ");
                basic.PrintContext(ctx.start.getInputStream().toString(), ctx.start.getLine(), ctx.start.getStartIndex(), ctx.start.getStopIndex());
            }
        }
        String var_name = ctx.start.getInputStream().toString().substring(identifier_start, identifier_stop + 1);
        if (currentvarSet.get(var_name) != null || classSet.contains(var_name))   //maybe it's a predefined class
        {
            basic.PrintError(ctx.getStart(), " The variable " + var_name + " already exists right now! ");
            basic.PrintContext(ctx.start.getInputStream().toString(), ctx.start.getLine(), ctx.start.getStartIndex(), ctx.start.getStopIndex());
        }
        else if (now_scope != 1) //not in the main function
        {
            Type var_type = typeprop.get(ctx.type());
            if (var_type == Type.jClass) classInstanceSet.put(var_name, type_name);   //pair <instance_name, which class this instance belong to> e.g. Tree tree_hello  build pair<"tree_hello", "Tree">
            currentvarSet.put(var_name, var_type);
            varScope.put(var_name, now_scope);
        }
    }

    public void enterMethod(miniJavaParser.MethodContext ctx)   //public method inside the class
    {
        now_scope++;
        HashMap<Integer, Type> t_hash = new HashMap<Integer, Type>();
        //class name is the getText of identifier(0) of parent, and method name is simply ctx.identifier(0).getText()
        //e.g. <Tree, Init>  class Tree has Function Init
        boolean valid_method = true;
        for (int i = 0; i < ctx.identifier().size(); i++)
        {
            int identifier_start = ctx.identifier(i).start.getStartIndex();
            int identifier_stop = ctx.identifier(i).start.getStopIndex();
            String identifier_name = ctx.start.getInputStream().toString().substring(identifier_start, identifier_stop + 1);
            int type_start = ctx.type(i).start.getStartIndex();
            int type_stop = ctx.type(i).start.getStopIndex();
            String type_name = ctx.start.getInputStream().toString().substring(type_start, type_stop + 1);
            if (currentvarSet.get(identifier_name) != null || classSet.contains(identifier_name))   //maybe it's a predefined class
            {
                valid_method = false; //method name or argument name exist already
                if (i == 0) basic.PrintError(ctx.getStart(), " The method name inside the class " + identifier_name  + " is already defined!");
                else basic.PrintError(ctx.getStart(), " The argument name of the method inside the class " + identifier_name  + " is already defined!");
                basic.PrintContext(ctx.start.getInputStream().toString(), ctx.start.getLine(), ctx.start.getStartIndex(), ctx.start.getStopIndex());
            }
            else
            {
                Type t_find = findType(type_name);
                if (t_find != Type.jVoid) // int boolean or class
                {
                    if (t_find == Type.jClass) classInstanceSet.put(identifier_name, type_name);   //instance, class name
                    currentvarSet.put(identifier_name, t_find);
                    varScope.put(identifier_name, now_scope);    //add the argument of the method to the var set
                    t_hash.put(i, t_find);   //the i-th argument's type is t_find
                }
                else
                {
                    valid_method = false; //because maybe T t   while T is not a predefined class
                }
            }
        }
        if (valid_method)
        {
            method_arguments.put(((miniJavaParser.InsideClassContext) ((miniJavaParser.MethodContext) ctx).parent).identifier(0).getText(), ctx.identifier(0).getText(), t_hash);
        }
    }

    public void exitMethod(miniJavaParser.MethodContext ctx)  //will step out of the method
    {
        for (int i = 0; i < ctx.identifier().size(); i++)
        {
            int identifier_start = ctx.identifier(i).start.getStartIndex();
            int identifier_stop = ctx.identifier(i).start.getStopIndex();
            String identifier_name = ctx.start.getInputStream().toString().substring(identifier_start, identifier_stop + 1);
            int type_start = ctx.type(i).start.getStartIndex();
            int type_stop = ctx.type(i).start.getStopIndex();
            String type_name = ctx.start.getInputStream().toString().substring(type_start, type_stop + 1);
            if (currentvarSet.get(identifier_name) != null)
            {
                if (varScope.get(identifier_name) == now_scope)  //it is declared in this scope   can ensure it's exactly this method
                {
                    Type t_find = findType(type_name);
                    if (t_find != Type.jVoid)
                    {
                        if (currentvarSet.get(identifier_name)  != null)
                        {
                            if (t_find == Type.jClass) classInstanceSet.remove(identifier_name); //remove the instance
                            currentvarSet.remove(identifier_name);   //remove it from the method
                            varScope.remove(identifier_name);
                        }

                    }
                }//otherwise it should not be removed
            }
        }

        for (int i = 0; i < ctx.varDeclaration().size(); i++)
        {
            String identifier_name = ctx.varDeclaration(i).getChild(1).getText();
            String type_name = ctx.varDeclaration(i).getChild(0).getText();
            if (currentvarSet.get(identifier_name) != null)
            {
                if (varScope.get(identifier_name) == now_scope)  //it is declared in this scope
                {
                    Type t_find = findType(type_name);
                    if (t_find != Type.jVoid)
                    {
                        if (currentvarSet.get(identifier_name)  != null)
                        {
                            if (t_find == Type.jClass) classInstanceSet.remove(identifier_name);
                            currentvarSet.remove(identifier_name);   //remove it from the method
                            varScope.remove(identifier_name);
                        }
                    }
                }//otherwise it should not be removed
            }
        }
        //check return type
        Type return_type = findType(ctx.type(0).getText());
        Type calculate_type = typeprop.get(ctx.extendexp());
        if (calculate_type != return_type)
        {
            basic.PrintError(ctx.getStart(), "The expected return type of function " + ctx.identifier(0).getText() + " should be " + return_type + " while the real return type is " + calculate_type);
            basic.PrintContext(ctx.start.getInputStream().toString(), ctx.start.getLine(), ctx.start.getStartIndex(), ctx.start.getStopIndex());
        }
    }

    public void exitIfelse(miniJavaParser.IfelseContext ctx)
    {
        Type condition_type = typeprop.get(ctx.extendexp());
        if (condition_type != Type.jBool)
        {
            basic.PrintError(ctx.getStart(), "The if condition is not a boolean but a " + condition_type);
            basic.PrintContext(ctx.start.getInputStream().toString(), ctx.start.getLine(), ctx.start.getStartIndex(), ctx.start.getStopIndex());
        }
    }

    public void exitWhile(miniJavaParser.WhileContext ctx)
    {
        Type condition_type = typeprop.get(ctx.extendexp());
        if (condition_type != Type.jBool)
        {
            basic.PrintError(ctx.getStart(), "The while condition is not a boolean but a " + condition_type);
            basic.PrintContext(ctx.start.getInputStream().toString(), ctx.start.getLine(), ctx.start.getStartIndex(), ctx.start.getStopIndex());
        }
    }

    public void exitPrintln(miniJavaParser.PrintlnContext ctx)
    {
        Type condition_type = typeprop.get(ctx.extendexp());
        if (condition_type == Type.jVoid)
        {
            basic.PrintError(ctx.getStart(), "The content you want to print out is void");
            basic.PrintContext(ctx.start.getInputStream().toString(), ctx.start.getLine(), ctx.start.getStartIndex(), ctx.start.getStopIndex());
        }
    }

    public void exitAssign(miniJavaParser.AssignContext ctx)   //assign a value to a variable
    {
        String identifier_name = ctx.identifier().getText();
        Type var_find = currentvarSet.get(identifier_name);
        boolean class_find = classSet.contains(identifier_name);
        if (var_find == null && !class_find)
        {
            basic.PrintError(ctx.getStart(), "The left value of assign operation " + identifier_name + " is not a variable nor a class");
            basic.PrintContext(ctx.start.getInputStream().toString(), ctx.start.getLine(), ctx.start.getStartIndex(), ctx.start.getStopIndex());
        }
        Type t_extended = typeprop.get(ctx.extendexp());
        if (var_find != t_extended)   //mismatch type
        {
            basic.PrintError(ctx.getStart(), "Type mismatch, the desired type should be " + var_find + " while the type of extendedexp is " + t_extended);
            basic.PrintContext(ctx.start.getInputStream().toString(), ctx.start.getLine(), ctx.start.getStartIndex(), ctx.start.getStopIndex());
        }
    }

    public void exitArrayValueAssign(miniJavaParser.ArrayValueAssignContext ctx)
    {
        String identifier_name = ctx.identifier().getText();
        Type var_find = currentvarSet.get(identifier_name);
        if (var_find != Type.jArray)
        {
            basic.PrintError(ctx.getStart(), "The left value of assign operation " + identifier_name + " is not an array");
            basic.PrintContext(ctx.start.getInputStream().toString(), ctx.start.getLine(), ctx.start.getStartIndex(), ctx.start.getStopIndex());
        }
        Type t_index = typeprop.get(ctx.extendexp(0));
        if (t_index != Type.jInt)
        {
            basic.PrintError(ctx.getStart(), "The index of the array is not an integer");
            basic.PrintContext(ctx.start.getInputStream().toString(), ctx.start.getLine(), ctx.start.getStartIndex(), ctx.start.getStopIndex());
        }
        Type t_value = typeprop.get(ctx.extendexp(1));
        if (t_value != Type.jInt)
        {
            basic.PrintError(ctx.getStart(), "The assigned value is not an integer");
            basic.PrintContext(ctx.start.getInputStream().toString(), ctx.start.getLine(), ctx.start.getStartIndex(), ctx.start.getStopIndex());
        }
    }



    public void exitWrongID(miniJavaParser.WrongIDContext ctx)
    {
        basic.PrintError(ctx.getStart(), "The variable starts with digit, which is not prohibited here!");
        basic.PrintContext(ctx.start.getInputStream().toString(), ctx.start.getLine(), ctx.start.getStartIndex(), ctx.start.getStopIndex());
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

    public void exitSingleExpression(miniJavaParser.SingleExpressionContext ctx)
    {
        typeprop.put(ctx,typeprop.get(ctx.expression()));
    }

    public void exitExpressionRightbrace(miniJavaParser.ExpressionRightbraceContext ctx)
    {
        basic.PrintError(ctx.getStart(), "The braces are not perfectedly matched, the expression ends with too many ')' ");
        basic.PrintContext(ctx.start.getInputStream().toString(), ctx.start.getLine(), ctx.start.getStartIndex(), ctx.start.getStopIndex());
    }

    public void exitLeftbraceExpression(miniJavaParser.LeftbraceExpressionContext ctx)
    {
        basic.PrintError(ctx.getStart(), "The braces are not perfectedly matched, the expression starts with too many '(' ");
        basic.PrintContext(ctx.start.getInputStream().toString(), ctx.start.getLine(), ctx.start.getStartIndex(), ctx.start.getStopIndex());
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
        Type b_type = typeprop.get(ctx.expression(1));
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
        if (var_type != Type.jArray)
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

    public void exitCallFunction(miniJavaParser.CallFunctionContext ctx)
    {
        if (now_scope == 1) return;  //main class just simply ignore it    main class will call like new F.start()
        if (typeprop.get(ctx.expression(0)) != Type.jClass)
        {
            basic.PrintError(ctx.getStart(), " The class  " + ctx.expression(0).getText()  + " does not exist right now, so you could not call functions of it!");
            basic.PrintContext(ctx.start.getInputStream().toString(), ctx.start.getLine(), ctx.start.getStartIndex(), ctx.start.getStopIndex());
            typeprop.put(ctx, Type.jVoid);
        }
        else
        {
            boolean type_mismatch = false;
            String class_name = ctx.expression(0).getText();
            String class_type = "";
            if (class_name.equals("this"))
            {
                class_name = current_class_name;    //because of this pointer
                class_type = current_class_name;   //it is
            }
            else if (classInstanceSet.containsKey(class_name)) class_type = classInstanceSet.get(class_name); // e.g. class Tree Tree f_tree  then f_tree is the class_name while Tree is the class type
            if (class_type.equals(""))
            {
                basic.PrintError(ctx.getStart(), class_name + " is not a predefined class, and you cannot call its function" );
                basic.PrintContext(ctx.start.getInputStream().toString(), ctx.start.getLine(), ctx.start.getStartIndex(), ctx.start.getStopIndex()); //so that there is no redundancy
                typeprop.put(ctx, Type.jVoid);
            }
            else
            {
                HashMap<Integer, Type> function_args = method_arguments.get(class_type, ctx.identifier().getText());    // call function 's arguments  (<name, type> pair)
                if (function_args == null)
                {
                    basic.PrintError(ctx.getStart(), " The method " + ctx.identifier().getText() + " is not a function of class " + class_type + "yet, you cannot pass parameter!" );
                    basic.PrintContext(ctx.start.getInputStream().toString(), ctx.start.getLine(), ctx.start.getStartIndex(), ctx.start.getStopIndex()); //so that there is no redundancy
                    typeprop.put(ctx, Type.jVoid);
                }
                else
                {
                    for (int i = 1; i < ctx.expression().size(); i++) //0 is the Instance name   (use the function of class Instance)
                    {
                        Type arg_i_type = typeprop.get(ctx.expression(i));   //get the type of i-th argument of the method function
                        Type expected_type = Type.jVoid;
                        if (function_args.containsKey(i)) expected_type = function_args.get(i);   // i = 1 is the first argument 's type
                        if (expected_type == Type.jVoid)  //key i does not exist remember the pair is <index, type of argument>
                        {
                            basic.PrintError(ctx.getStart(), " The " + i + " -th argument of the function does not exist in the declaration, you cannot pass parameter!" );
                        }
                        else if (expected_type != arg_i_type)
                        {
                            basic.PrintError(ctx.getStart(), " The definition type of " + i + " -th argument of the function + " + class_name + " is " + expected_type + " while the real type is " + arg_i_type);
                            type_mismatch = true; //flag
                        }
                    }
                    if (type_mismatch)
                    {
                        basic.PrintContext(ctx.start.getInputStream().toString(), ctx.start.getLine(), ctx.start.getStartIndex(), ctx.start.getStopIndex()); //so that there is no redundancy
                        typeprop.put(ctx, Type.jVoid);
                    }
                    else
                    {
                        Type return_type = function_args.get(0); // 0 is the class method (function)  's type
                        typeprop.put(ctx, return_type);
                    }
                }
            }
        }
    }

    public void exitBoolTrue(miniJavaParser.BoolTrueContext ctx)
    {
        typeprop.put(ctx, Type.jBool);
    }

    public void exitBoolFalse(miniJavaParser.BoolFalseContext ctx)
    {
        typeprop.put(ctx, Type.jBool);
    }

    public void exitVarOfExpression(miniJavaParser.VarOfExpressionContext ctx)
    {
        int start = ctx.start.getStartIndex();
        int stop = ctx.start.getStopIndex();
        String var_name = ctx.start.getInputStream().toString().substring(start, stop + 1);

        Type var_find = currentvarSet.get(var_name);
        boolean class_find = classSet.contains(var_name);
        if (var_find == null && !class_find)    // the variable need to be defined does not exist right now
        {
            basic.PrintError(ctx.getStart(), " The variable you just used in the code " + var_name  + " is not a variable or a class right now!");
            basic.PrintContext(ctx.start.getInputStream().toString(), ctx.start.getLine(), ctx.start.getStartIndex(), ctx.start.getStopIndex());
        }
        else if (var_find != null)
        {
            typeprop.put(ctx, var_find);
        }
        else if (class_find)
        {
            typeprop.put(ctx, Type.jClass);
        }
    }

    public void exitThis(miniJavaParser.ThisContext ctx)
    {
        typeprop.put(ctx, Type.jClass); //this is a class
    }

    public void exitNewIntArray(miniJavaParser.NewIntArrayContext ctx)
    {
        Type t_type = typeprop.get(ctx.expression());
        if (t_type != Type.jInt)
        {
            basic.PrintError(ctx.getStart(), " new int [num] num should be a integer but got " + t_type);
            basic.PrintContext(ctx.start.getInputStream().toString(), ctx.start.getLine(), ctx.start.getStartIndex(), ctx.start.getStopIndex());
        }
        else
        {
            typeprop.put(ctx, Type.jArray);
        }
    }

    public void exitNewClass(miniJavaParser.NewClassContext ctx)
    {
        String identifier_name = ctx.identifier().getText();
        boolean class_find = classSet.contains(identifier_name);
        if (now_scope !=1 && !class_find) //not in the main class
        {
            basic.PrintError(ctx.getStart(), "The Class " + identifier_name + " you want to new is not a class");
            basic.PrintContext(ctx.start.getInputStream().toString(), ctx.start.getLine(), ctx.start.getStartIndex(), ctx.start.getStopIndex());
        }
        else
        {
            typeprop.put(ctx, Type.jClass);
        }
    }

    public void exitNegative(miniJavaParser.NegativeContext ctx)
    {
        Type t_expression = typeprop.get(ctx.expression());
        if ( t_expression == Type.jBool)
        {
            typeprop.put(ctx, Type.jBool);
        }
        else
        {
            basic.PrintError(ctx.getStart(), " The expression you want to negate is not a boolean but a " +  t_expression);
            basic.PrintContext(ctx.start.getInputStream().toString(), ctx.start.getLine(), ctx.start.getStartIndex(), ctx.start.getStopIndex());
            typeprop.put(ctx, Type.jVoid);
        }
    }

    public void exitBracketpair(miniJavaParser.BracketpairContext ctx)
    {
        Type t_expression = typeprop.get(ctx.expression());
        if (t_expression == Type.jVoid)
        {
            basic.PrintError(ctx.getStart(), " The expression you want to add bracket pairs is not valid" );
            basic.PrintContext(ctx.start.getInputStream().toString(), ctx.start.getLine(), ctx.start.getStartIndex(), ctx.start.getStopIndex());
        }
        else
        {
            typeprop.put(ctx, t_expression);
        }
    }

    public void exitIntValueOfExpression(miniJavaParser.IntValueOfExpressionContext ctx)   // INT in the expression
    {
        typeprop.put(ctx, Type.jInt);
    }

    public void exitStringValueOfExpression(miniJavaParser.StringValueOfExpressionContext ctx)
    {
        typeprop.put(ctx, Type.jString);
    }
}
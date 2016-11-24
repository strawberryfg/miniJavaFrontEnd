// Generated from miniJava.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link miniJavaParser}.
 */
public interface miniJavaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link miniJavaParser#goal}.
	 * @param ctx the parse tree
	 */
	void enterGoal(miniJavaParser.GoalContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniJavaParser#goal}.
	 * @param ctx the parse tree
	 */
	void exitGoal(miniJavaParser.GoalContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniJavaParser#mainClass}.
	 * @param ctx the parse tree
	 */
	void enterMainClass(miniJavaParser.MainClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniJavaParser#mainClass}.
	 * @param ctx the parse tree
	 */
	void exitMainClass(miniJavaParser.MainClassContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InsideClass}
	 * labeled alternative in {@link miniJavaParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInsideClass(miniJavaParser.InsideClassContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InsideClass}
	 * labeled alternative in {@link miniJavaParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInsideClass(miniJavaParser.InsideClassContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DeclareVariable}
	 * labeled alternative in {@link miniJavaParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclareVariable(miniJavaParser.DeclareVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DeclareVariable}
	 * labeled alternative in {@link miniJavaParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclareVariable(miniJavaParser.DeclareVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Method}
	 * labeled alternative in {@link miniJavaParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethod(miniJavaParser.MethodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Method}
	 * labeled alternative in {@link miniJavaParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethod(miniJavaParser.MethodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntegerArray}
	 * labeled alternative in {@link miniJavaParser#type}.
	 * @param ctx the parse tree
	 */
	void enterIntegerArray(miniJavaParser.IntegerArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntegerArray}
	 * labeled alternative in {@link miniJavaParser#type}.
	 * @param ctx the parse tree
	 */
	void exitIntegerArray(miniJavaParser.IntegerArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Boolean}
	 * labeled alternative in {@link miniJavaParser#type}.
	 * @param ctx the parse tree
	 */
	void enterBoolean(miniJavaParser.BooleanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Boolean}
	 * labeled alternative in {@link miniJavaParser#type}.
	 * @param ctx the parse tree
	 */
	void exitBoolean(miniJavaParser.BooleanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Integer}
	 * labeled alternative in {@link miniJavaParser#type}.
	 * @param ctx the parse tree
	 */
	void enterInteger(miniJavaParser.IntegerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Integer}
	 * labeled alternative in {@link miniJavaParser#type}.
	 * @param ctx the parse tree
	 */
	void exitInteger(miniJavaParser.IntegerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Instance}
	 * labeled alternative in {@link miniJavaParser#type}.
	 * @param ctx the parse tree
	 */
	void enterInstance(miniJavaParser.InstanceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Instance}
	 * labeled alternative in {@link miniJavaParser#type}.
	 * @param ctx the parse tree
	 */
	void exitInstance(miniJavaParser.InstanceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BracesOfStatement}
	 * labeled alternative in {@link miniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterBracesOfStatement(miniJavaParser.BracesOfStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BracesOfStatement}
	 * labeled alternative in {@link miniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitBracesOfStatement(miniJavaParser.BracesOfStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Ifelse}
	 * labeled alternative in {@link miniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIfelse(miniJavaParser.IfelseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Ifelse}
	 * labeled alternative in {@link miniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIfelse(miniJavaParser.IfelseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code While}
	 * labeled alternative in {@link miniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterWhile(miniJavaParser.WhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code While}
	 * labeled alternative in {@link miniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitWhile(miniJavaParser.WhileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Println}
	 * labeled alternative in {@link miniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterPrintln(miniJavaParser.PrintlnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Println}
	 * labeled alternative in {@link miniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitPrintln(miniJavaParser.PrintlnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Assign}
	 * labeled alternative in {@link miniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterAssign(miniJavaParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Assign}
	 * labeled alternative in {@link miniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitAssign(miniJavaParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayValueAssign}
	 * labeled alternative in {@link miniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterArrayValueAssign(miniJavaParser.ArrayValueAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayValueAssign}
	 * labeled alternative in {@link miniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitArrayValueAssign(miniJavaParser.ArrayValueAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SingleExpression}
	 * labeled alternative in {@link miniJavaParser#extendexp}.
	 * @param ctx the parse tree
	 */
	void enterSingleExpression(miniJavaParser.SingleExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SingleExpression}
	 * labeled alternative in {@link miniJavaParser#extendexp}.
	 * @param ctx the parse tree
	 */
	void exitSingleExpression(miniJavaParser.SingleExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionRightbrace}
	 * labeled alternative in {@link miniJavaParser#extendexp}.
	 * @param ctx the parse tree
	 */
	void enterExpressionRightbrace(miniJavaParser.ExpressionRightbraceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionRightbrace}
	 * labeled alternative in {@link miniJavaParser#extendexp}.
	 * @param ctx the parse tree
	 */
	void exitExpressionRightbrace(miniJavaParser.ExpressionRightbraceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LeftbraceExpression}
	 * labeled alternative in {@link miniJavaParser#extendexp}.
	 * @param ctx the parse tree
	 */
	void enterLeftbraceExpression(miniJavaParser.LeftbraceExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LeftbraceExpression}
	 * labeled alternative in {@link miniJavaParser#extendexp}.
	 * @param ctx the parse tree
	 */
	void exitLeftbraceExpression(miniJavaParser.LeftbraceExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VarOfExpression}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterVarOfExpression(miniJavaParser.VarOfExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VarOfExpression}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitVarOfExpression(miniJavaParser.VarOfExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(miniJavaParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(miniJavaParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringValueOfExpression}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterStringValueOfExpression(miniJavaParser.StringValueOfExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringValueOfExpression}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitStringValueOfExpression(miniJavaParser.StringValueOfExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GetLength}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterGetLength(miniJavaParser.GetLengthContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GetLength}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitGetLength(miniJavaParser.GetLengthContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Lessthan}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLessthan(miniJavaParser.LessthanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Lessthan}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLessthan(miniJavaParser.LessthanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Negative}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNegative(miniJavaParser.NegativeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Negative}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNegative(miniJavaParser.NegativeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulDivide}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMulDivide(miniJavaParser.MulDivideContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulDivide}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMulDivide(miniJavaParser.MulDivideContext ctx);
	/**
	 * Enter a parse tree produced by the {@code And}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAnd(miniJavaParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code And}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAnd(miniJavaParser.AndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolFalse}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBoolFalse(miniJavaParser.BoolFalseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolFalse}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBoolFalse(miniJavaParser.BoolFalseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code This}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterThis(miniJavaParser.ThisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code This}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitThis(miniJavaParser.ThisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Bracketpair}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBracketpair(miniJavaParser.BracketpairContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Bracketpair}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBracketpair(miniJavaParser.BracketpairContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntValueOfExpression}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIntValueOfExpression(miniJavaParser.IntValueOfExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntValueOfExpression}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIntValueOfExpression(miniJavaParser.IntValueOfExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NewIntArray}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNewIntArray(miniJavaParser.NewIntArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NewIntArray}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNewIntArray(miniJavaParser.NewIntArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NewClass}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNewClass(miniJavaParser.NewClassContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NewClass}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNewClass(miniJavaParser.NewClassContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CallFunction}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCallFunction(miniJavaParser.CallFunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CallFunction}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCallFunction(miniJavaParser.CallFunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolTrue}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBoolTrue(miniJavaParser.BoolTrueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolTrue}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBoolTrue(miniJavaParser.BoolTrueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GetArrayValue}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterGetArrayValue(miniJavaParser.GetArrayValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GetArrayValue}
	 * labeled alternative in {@link miniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitGetArrayValue(miniJavaParser.GetArrayValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link miniJavaParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterVariable(miniJavaParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link miniJavaParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitVariable(miniJavaParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WrongID}
	 * labeled alternative in {@link miniJavaParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterWrongID(miniJavaParser.WrongIDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WrongID}
	 * labeled alternative in {@link miniJavaParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitWrongID(miniJavaParser.WrongIDContext ctx);
}
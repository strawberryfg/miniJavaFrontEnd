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
	 * Enter a parse tree produced by {@link miniJavaParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(miniJavaParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniJavaParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(miniJavaParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniJavaParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclaration(miniJavaParser.VarDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniJavaParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclaration(miniJavaParser.VarDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniJavaParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(miniJavaParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniJavaParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(miniJavaParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link miniJavaParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(miniJavaParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniJavaParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(miniJavaParser.TypeContext ctx);
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
	 * Enter a parse tree produced by {@link miniJavaParser#extendexp}.
	 * @param ctx the parse tree
	 */
	void enterExtendexp(miniJavaParser.ExtendexpContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniJavaParser#extendexp}.
	 * @param ctx the parse tree
	 */
	void exitExtendexp(miniJavaParser.ExtendexpContext ctx);
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
	 * Enter a parse tree produced by {@link miniJavaParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(miniJavaParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link miniJavaParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(miniJavaParser.IdentifierContext ctx);
}
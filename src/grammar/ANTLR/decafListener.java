// Generated from C:\Users\Kevin\Documents\Kevin\Ciclo 7\Compis\Scanner\src\grammar\decaf.g4 by ANTLR 4.4
package grammar.ANTLR;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link decafParser}.
 */
public interface decafListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link decafParser#structDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterStructDeclaration(@NotNull decafParser.StructDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#structDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitStructDeclaration(@NotNull decafParser.StructDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link decafParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(@NotNull decafParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(@NotNull decafParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link decafParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(@NotNull decafParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(@NotNull decafParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link decafParser#bool_literal}.
	 * @param ctx the parse tree
	 */
	void enterBool_literal(@NotNull decafParser.Bool_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#bool_literal}.
	 * @param ctx the parse tree
	 */
	void exitBool_literal(@NotNull decafParser.Bool_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link decafParser#rel_op}.
	 * @param ctx the parse tree
	 */
	void enterRel_op(@NotNull decafParser.Rel_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#rel_op}.
	 * @param ctx the parse tree
	 */
	void exitRel_op(@NotNull decafParser.Rel_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link decafParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(@NotNull decafParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(@NotNull decafParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link decafParser#eq_op}.
	 * @param ctx the parse tree
	 */
	void enterEq_op(@NotNull decafParser.Eq_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#eq_op}.
	 * @param ctx the parse tree
	 */
	void exitEq_op(@NotNull decafParser.Eq_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link decafParser#int_literal}.
	 * @param ctx the parse tree
	 */
	void enterInt_literal(@NotNull decafParser.Int_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#int_literal}.
	 * @param ctx the parse tree
	 */
	void exitInt_literal(@NotNull decafParser.Int_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link decafParser#varType}.
	 * @param ctx the parse tree
	 */
	void enterVarType(@NotNull decafParser.VarTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#varType}.
	 * @param ctx the parse tree
	 */
	void exitVarType(@NotNull decafParser.VarTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link decafParser#methodType}.
	 * @param ctx the parse tree
	 */
	void enterMethodType(@NotNull decafParser.MethodTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#methodType}.
	 * @param ctx the parse tree
	 */
	void exitMethodType(@NotNull decafParser.MethodTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link decafParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(@NotNull decafParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(@NotNull decafParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link decafParser#arg}.
	 * @param ctx the parse tree
	 */
	void enterArg(@NotNull decafParser.ArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#arg}.
	 * @param ctx the parse tree
	 */
	void exitArg(@NotNull decafParser.ArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link decafParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(@NotNull decafParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(@NotNull decafParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link decafParser#pow}.
	 * @param ctx the parse tree
	 */
	void enterPow(@NotNull decafParser.PowContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#pow}.
	 * @param ctx the parse tree
	 */
	void exitPow(@NotNull decafParser.PowContext ctx);
	/**
	 * Enter a parse tree produced by {@link decafParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(@NotNull decafParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(@NotNull decafParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link decafParser#char_literal}.
	 * @param ctx the parse tree
	 */
	void enterChar_literal(@NotNull decafParser.Char_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#char_literal}.
	 * @param ctx the parse tree
	 */
	void exitChar_literal(@NotNull decafParser.Char_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link decafParser#parameterType}.
	 * @param ctx the parse tree
	 */
	void enterParameterType(@NotNull decafParser.ParameterTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#parameterType}.
	 * @param ctx the parse tree
	 */
	void exitParameterType(@NotNull decafParser.ParameterTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link decafParser#op}.
	 * @param ctx the parse tree
	 */
	void enterOp(@NotNull decafParser.OpContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#op}.
	 * @param ctx the parse tree
	 */
	void exitOp(@NotNull decafParser.OpContext ctx);
	/**
	 * Enter a parse tree produced by {@link decafParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(@NotNull decafParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(@NotNull decafParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link decafParser#calc_op}.
	 * @param ctx the parse tree
	 */
	void enterCalc_op(@NotNull decafParser.Calc_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#calc_op}.
	 * @param ctx the parse tree
	 */
	void exitCalc_op(@NotNull decafParser.Calc_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link decafParser#plusOrMinus}.
	 * @param ctx the parse tree
	 */
	void enterPlusOrMinus(@NotNull decafParser.PlusOrMinusContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#plusOrMinus}.
	 * @param ctx the parse tree
	 */
	void exitPlusOrMinus(@NotNull decafParser.PlusOrMinusContext ctx);
	/**
	 * Enter a parse tree produced by {@link decafParser#arith_op}.
	 * @param ctx the parse tree
	 */
	void enterArith_op(@NotNull decafParser.Arith_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#arith_op}.
	 * @param ctx the parse tree
	 */
	void exitArith_op(@NotNull decafParser.Arith_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link decafParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(@NotNull decafParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(@NotNull decafParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link decafParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclaration(@NotNull decafParser.VarDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclaration(@NotNull decafParser.VarDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link decafParser#multOrDiv}.
	 * @param ctx the parse tree
	 */
	void enterMultOrDiv(@NotNull decafParser.MultOrDivContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#multOrDiv}.
	 * @param ctx the parse tree
	 */
	void exitMultOrDiv(@NotNull decafParser.MultOrDivContext ctx);
	/**
	 * Enter a parse tree produced by {@link decafParser#cond_op}.
	 * @param ctx the parse tree
	 */
	void enterCond_op(@NotNull decafParser.Cond_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#cond_op}.
	 * @param ctx the parse tree
	 */
	void exitCond_op(@NotNull decafParser.Cond_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link decafParser#unaryMinus}.
	 * @param ctx the parse tree
	 */
	void enterUnaryMinus(@NotNull decafParser.UnaryMinusContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#unaryMinus}.
	 * @param ctx the parse tree
	 */
	void exitUnaryMinus(@NotNull decafParser.UnaryMinusContext ctx);
	/**
	 * Enter a parse tree produced by {@link decafParser#location}.
	 * @param ctx the parse tree
	 */
	void enterLocation(@NotNull decafParser.LocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#location}.
	 * @param ctx the parse tree
	 */
	void exitLocation(@NotNull decafParser.LocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link decafParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(@NotNull decafParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(@NotNull decafParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link decafParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void enterMethodCall(@NotNull decafParser.MethodCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void exitMethodCall(@NotNull decafParser.MethodCallContext ctx);
}
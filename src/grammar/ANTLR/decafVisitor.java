// Generated from C:\Users\Kevin\Documents\Kevin\Ciclo 7\Compis\Scanner\src\grammar\decaf.g4 by ANTLR 4.4
package grammar.ANTLR;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link decafParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface decafVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link decafParser#structDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructDeclaration(@NotNull decafParser.StructDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link decafParser#methodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclaration(@NotNull decafParser.MethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code locationExp}
	 * labeled alternative in {@link decafParser#location}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocationExp(@NotNull decafParser.LocationExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statementReturn}
	 * labeled alternative in {@link decafParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementReturn(@NotNull decafParser.StatementReturnContext ctx);
	/**
	 * Visit a parse tree produced by {@link decafParser#assignOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignOp(@NotNull decafParser.AssignOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statementBlock}
	 * labeled alternative in {@link decafParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementBlock(@NotNull decafParser.StatementBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link decafParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(@NotNull decafParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link decafParser#bool_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool_literal(@NotNull decafParser.Bool_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link decafParser#atom2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom2(@NotNull decafParser.Atom2Context ctx);
	/**
	 * Visit a parse tree produced by {@link decafParser#rel_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRel_op(@NotNull decafParser.Rel_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link decafParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(@NotNull decafParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link decafParser#eq_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEq_op(@NotNull decafParser.Eq_opContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statementExp}
	 * labeled alternative in {@link decafParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementExp(@NotNull decafParser.StatementExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link decafParser#int_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt_literal(@NotNull decafParser.Int_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link decafParser#varType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarType(@NotNull decafParser.VarTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link decafParser#methodType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodType(@NotNull decafParser.MethodTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link decafParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(@NotNull decafParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link decafParser#arg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArg(@NotNull decafParser.ArgContext ctx);
	/**
	 * Visit a parse tree produced by {@link decafParser#pow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPow(@NotNull decafParser.PowContext ctx);
	/**
	 * Visit a parse tree produced by {@link decafParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(@NotNull decafParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link decafParser#condOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondOp(@NotNull decafParser.CondOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link decafParser#char_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChar_literal(@NotNull decafParser.Char_literalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statementPrint}
	 * labeled alternative in {@link decafParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementPrint(@NotNull decafParser.StatementPrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link decafParser#parameterType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterType(@NotNull decafParser.ParameterTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statementAsign}
	 * labeled alternative in {@link decafParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementAsign(@NotNull decafParser.StatementAsignContext ctx);
	/**
	 * Visit a parse tree produced by {@link decafParser#op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp(@NotNull decafParser.OpContext ctx);
	/**
	 * Visit a parse tree produced by {@link decafParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(@NotNull decafParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link decafParser#plusOrMinus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusOrMinus(@NotNull decafParser.PlusOrMinusContext ctx);
	/**
	 * Visit a parse tree produced by {@link decafParser#unaryMinus2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryMinus2(@NotNull decafParser.UnaryMinus2Context ctx);
	/**
	 * Visit a parse tree produced by {@link decafParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(@NotNull decafParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link decafParser#varDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclaration(@NotNull decafParser.VarDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link decafParser#pow2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPow2(@NotNull decafParser.Pow2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code locationExplocation}
	 * labeled alternative in {@link decafParser#location}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocationExplocation(@NotNull decafParser.LocationExplocationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code locationIDlocation}
	 * labeled alternative in {@link decafParser#location}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocationIDlocation(@NotNull decafParser.LocationIDlocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link decafParser#multOrDiv}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultOrDiv(@NotNull decafParser.MultOrDivContext ctx);
	/**
	 * Visit a parse tree produced by {@link decafParser#cond_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond_op(@NotNull decafParser.Cond_opContext ctx);
	/**
	 * Visit a parse tree produced by the {@code locationID}
	 * labeled alternative in {@link decafParser#location}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocationID(@NotNull decafParser.LocationIDContext ctx);
	/**
	 * Visit a parse tree produced by {@link decafParser#unaryMinus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryMinus(@NotNull decafParser.UnaryMinusContext ctx);
	/**
	 * Visit a parse tree produced by {@link decafParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(@NotNull decafParser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statementWhile}
	 * labeled alternative in {@link decafParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementWhile(@NotNull decafParser.StatementWhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statementIf}
	 * labeled alternative in {@link decafParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementIf(@NotNull decafParser.StatementIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link decafParser#methodCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodCall(@NotNull decafParser.MethodCallContext ctx);
}
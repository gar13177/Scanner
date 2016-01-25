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
	 * Visit a parse tree produced by {@link decafParser#parameterType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterType(@NotNull decafParser.ParameterTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link decafParser#op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp(@NotNull decafParser.OpContext ctx);
	/**
	 * Visit a parse tree produced by {@link decafParser#methodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclaration(@NotNull decafParser.MethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link decafParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(@NotNull decafParser.ExpressionContext ctx);
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
	 * Visit a parse tree produced by {@link decafParser#arith_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArith_op(@NotNull decafParser.Arith_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link decafParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(@NotNull decafParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link decafParser#rel_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRel_op(@NotNull decafParser.Rel_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link decafParser#varDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclaration(@NotNull decafParser.VarDeclarationContext ctx);
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
	 * Visit a parse tree produced by {@link decafParser#cond_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond_op(@NotNull decafParser.Cond_opContext ctx);
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
	 * Visit a parse tree produced by {@link decafParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(@NotNull decafParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link decafParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(@NotNull decafParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link decafParser#location}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocation(@NotNull decafParser.LocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link decafParser#char_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChar_literal(@NotNull decafParser.Char_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link decafParser#methodCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodCall(@NotNull decafParser.MethodCallContext ctx);
}
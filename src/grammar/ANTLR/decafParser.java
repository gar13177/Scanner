// Generated from C:\Users\Kevin\Documents\Kevin\Ciclo 7\Compis\Scanner\src\grammar\decaf.g4 by ANTLR 4.4
package grammar.ANTLR;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class decafParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__35=1, T__34=2, T__33=3, T__32=4, T__31=5, T__30=6, T__29=7, T__28=8, 
		T__27=9, T__26=10, T__25=11, T__24=12, T__23=13, T__22=14, T__21=15, T__20=16, 
		T__19=17, T__18=18, T__17=19, T__16=20, T__15=21, T__14=22, T__13=23, 
		T__12=24, T__11=25, T__10=26, T__9=27, T__8=28, T__7=29, T__6=30, T__5=31, 
		T__4=32, T__3=33, T__2=34, T__1=35, T__0=36, ID=37, NUM=38, CHAR=39, WS=40, 
		COMMENTS=41;
	public static final String[] tokenNames = {
		"<INVALID>", "'/'", "'char'", "'true'", "'return'", "'!='", "'class'", 
		"'||'", "'while'", "';'", "'void'", "'{'", "'&&'", "'='", "'}'", "'Program'", 
		"'if'", "'<='", "'int'", "'('", "'*'", "','", "'false'", "'.'", "'boolean'", 
		"'>='", "'['", "'=='", "'<'", "']'", "'>'", "'!'", "'else'", "')'", "'+'", 
		"'struct'", "'-'", "ID", "NUM", "CHAR", "WS", "COMMENTS"
	};
	public static final int
		RULE_program = 0, RULE_declaration = 1, RULE_varType = 2, RULE_varDeclaration = 3, 
		RULE_structDeclaration = 4, RULE_methodDeclaration = 5, RULE_methodType = 6, 
		RULE_parameter = 7, RULE_parameterType = 8, RULE_block = 9, RULE_statement = 10, 
		RULE_location = 11, RULE_expression = 12, RULE_methodCall = 13, RULE_arg = 14, 
		RULE_op = 15, RULE_calc_op = 16, RULE_plusOrMinus = 17, RULE_multOrDiv = 18, 
		RULE_pow = 19, RULE_unaryMinus = 20, RULE_atom = 21, RULE_rel_op = 22, 
		RULE_eq_op = 23, RULE_cond_op = 24, RULE_literal = 25, RULE_int_literal = 26, 
		RULE_char_literal = 27, RULE_bool_literal = 28;
	public static final String[] ruleNames = {
		"program", "declaration", "varType", "varDeclaration", "structDeclaration", 
		"methodDeclaration", "methodType", "parameter", "parameterType", "block", 
		"statement", "location", "expression", "methodCall", "arg", "op", "calc_op", 
		"plusOrMinus", "multOrDiv", "pow", "unaryMinus", "atom", "rel_op", "eq_op", 
		"cond_op", "literal", "int_literal", "char_literal", "bool_literal"
	};

	@Override
	public String getGrammarFileName() { return "decaf.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public decafParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof decafVisitor ) return ((decafVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58); match(T__30);
			setState(59); match(T__21);
			setState(60); match(T__25);
			setState(64);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__34) | (1L << T__26) | (1L << T__18) | (1L << T__12) | (1L << T__1))) != 0)) {
				{
				{
				setState(61); declaration();
				}
				}
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(67); match(T__22);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public MethodDeclarationContext methodDeclaration() {
			return getRuleContext(MethodDeclarationContext.class,0);
		}
		public VarDeclarationContext varDeclaration() {
			return getRuleContext(VarDeclarationContext.class,0);
		}
		public StructDeclarationContext structDeclaration() {
			return getRuleContext(StructDeclarationContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof decafVisitor ) return ((decafVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaration);
		try {
			setState(72);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(69); structDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(70); varDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(71); methodDeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarTypeContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(decafParser.ID, 0); }
		public StructDeclarationContext structDeclaration() {
			return getRuleContext(StructDeclarationContext.class,0);
		}
		public VarTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).enterVarType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).exitVarType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof decafVisitor ) return ((decafVisitor<? extends T>)visitor).visitVarType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarTypeContext varType() throws RecognitionException {
		VarTypeContext _localctx = new VarTypeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_varType);
		try {
			setState(81);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(74); match(T__18);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(75); match(T__34);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(76); match(T__12);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(77); match(T__1);
				setState(78); match(ID);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(79); match(T__26);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(80); structDeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDeclarationContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(decafParser.ID, 0); }
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public TerminalNode NUM() { return getToken(decafParser.NUM, 0); }
		public VarDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).enterVarDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).exitVarDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof decafVisitor ) return ((decafVisitor<? extends T>)visitor).visitVarDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclarationContext varDeclaration() throws RecognitionException {
		VarDeclarationContext _localctx = new VarDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_varDeclaration);
		try {
			setState(94);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(83); varType();
				setState(84); match(ID);
				setState(85); match(T__27);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(87); varType();
				setState(88); match(ID);
				setState(89); match(T__10);
				setState(90); match(NUM);
				setState(91); match(T__7);
				setState(92); match(T__27);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StructDeclarationContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(decafParser.ID, 0); }
		public List<VarDeclarationContext> varDeclaration() {
			return getRuleContexts(VarDeclarationContext.class);
		}
		public VarDeclarationContext varDeclaration(int i) {
			return getRuleContext(VarDeclarationContext.class,i);
		}
		public StructDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).enterStructDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).exitStructDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof decafVisitor ) return ((decafVisitor<? extends T>)visitor).visitStructDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructDeclarationContext structDeclaration() throws RecognitionException {
		StructDeclarationContext _localctx = new StructDeclarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_structDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96); match(T__1);
			setState(97); match(ID);
			setState(98); match(T__25);
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__34) | (1L << T__26) | (1L << T__18) | (1L << T__12) | (1L << T__1))) != 0)) {
				{
				{
				setState(99); varDeclaration();
				}
				}
				setState(104);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(105); match(T__22);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodDeclarationContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(decafParser.ID, 0); }
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public MethodTypeContext methodType() {
			return getRuleContext(MethodTypeContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public MethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).enterMethodDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).exitMethodDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof decafVisitor ) return ((decafVisitor<? extends T>)visitor).visitMethodDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodDeclarationContext methodDeclaration() throws RecognitionException {
		MethodDeclarationContext _localctx = new MethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_methodDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107); methodType();
			setState(108); match(ID);
			setState(109); match(T__17);
			setState(118);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__34) | (1L << T__18) | (1L << T__12))) != 0)) {
				{
				setState(110); parameter();
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__15) {
					{
					{
					setState(111); match(T__15);
					setState(112); parameter();
					}
					}
					setState(117);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(120); match(T__3);
			setState(121); block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodTypeContext extends ParserRuleContext {
		public MethodTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).enterMethodType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).exitMethodType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof decafVisitor ) return ((decafVisitor<? extends T>)visitor).visitMethodType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodTypeContext methodType() throws RecognitionException {
		MethodTypeContext _localctx = new MethodTypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_methodType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__34) | (1L << T__26) | (1L << T__18) | (1L << T__12))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(decafParser.ID, 0); }
		public ParameterTypeContext parameterType() {
			return getRuleContext(ParameterTypeContext.class,0);
		}
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).enterParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).exitParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof decafVisitor ) return ((decafVisitor<? extends T>)visitor).visitParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_parameter);
		try {
			setState(133);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(125); parameterType();
				setState(126); match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(128); parameterType();
				setState(129); match(ID);
				setState(130); match(T__10);
				setState(131); match(T__7);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterTypeContext extends ParserRuleContext {
		public ParameterTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).enterParameterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).exitParameterType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof decafVisitor ) return ((decafVisitor<? extends T>)visitor).visitParameterType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterTypeContext parameterType() throws RecognitionException {
		ParameterTypeContext _localctx = new ParameterTypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_parameterType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__34) | (1L << T__18) | (1L << T__12))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public List<VarDeclarationContext> varDeclaration() {
			return getRuleContexts(VarDeclarationContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public VarDeclarationContext varDeclaration(int i) {
			return getRuleContext(VarDeclarationContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof decafVisitor ) return ((decafVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137); match(T__25);
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__34) | (1L << T__26) | (1L << T__18) | (1L << T__12) | (1L << T__1))) != 0)) {
				{
				{
				setState(138); varDeclaration();
				}
				}
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__33) | (1L << T__32) | (1L << T__28) | (1L << T__27) | (1L << T__25) | (1L << T__20) | (1L << T__17) | (1L << T__14) | (1L << T__5) | (1L << T__0) | (1L << ID) | (1L << NUM) | (1L << CHAR))) != 0)) {
				{
				{
				setState(144); statement();
				}
				}
				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(150); match(T__22);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public LocationContext location() {
			return getRuleContext(LocationContext.class,0);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public MethodCallContext methodCall() {
			return getRuleContext(MethodCallContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof decafVisitor ) return ((decafVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_statement);
		int _la;
		try {
			setState(184);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(152); match(T__20);
				setState(153); match(T__17);
				setState(154); expression(0);
				setState(155); match(T__3);
				setState(156); block();
				setState(159);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(157); match(T__4);
					setState(158); block();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(161); match(T__28);
				setState(162); match(T__17);
				setState(163); expression(0);
				setState(164); match(T__3);
				setState(165); block();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(167); match(T__32);
				setState(169);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__33) | (1L << T__17) | (1L << T__14) | (1L << T__5) | (1L << T__0) | (1L << ID) | (1L << NUM) | (1L << CHAR))) != 0)) {
					{
					setState(168); expression(0);
					}
				}

				setState(171); match(T__27);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(172); methodCall();
				setState(173); match(T__27);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(175); block();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(176); location();
				setState(177); match(T__23);
				setState(178); expression(0);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(181);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__33) | (1L << T__17) | (1L << T__14) | (1L << T__5) | (1L << T__0) | (1L << ID) | (1L << NUM) | (1L << CHAR))) != 0)) {
					{
					setState(180); expression(0);
					}
				}

				setState(183); match(T__27);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LocationContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(decafParser.ID, 0); }
		public LocationContext location() {
			return getRuleContext(LocationContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_location; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).enterLocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).exitLocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof decafVisitor ) return ((decafVisitor<? extends T>)visitor).visitLocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocationContext location() throws RecognitionException {
		LocationContext _localctx = new LocationContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_location);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(186); match(ID);
				}
				break;
			case 2:
				{
				setState(187); match(ID);
				setState(188); match(T__10);
				setState(189); expression(0);
				setState(190); match(T__7);
				}
				break;
			}
			setState(196);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(194); match(T__13);
				setState(195); location();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public OpContext op() {
			return getRuleContext(OpContext.class,0);
		}
		public LocationContext location() {
			return getRuleContext(LocationContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public MethodCallContext methodCall() {
			return getRuleContext(MethodCallContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public Calc_opContext calc_op() {
			return getRuleContext(Calc_opContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof decafVisitor ) return ((decafVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(199); match(T__0);
				setState(200); expression(3);
				}
				break;
			case 2:
				{
				setState(201); match(T__5);
				setState(202); expression(2);
				}
				break;
			case 3:
				{
				setState(203); location();
				}
				break;
			case 4:
				{
				setState(204); methodCall();
				}
				break;
			case 5:
				{
				setState(205); literal();
				}
				break;
			case 6:
				{
				setState(206); calc_op();
				}
				break;
			case 7:
				{
				setState(207); match(T__17);
				setState(208); expression(0);
				setState(209); match(T__3);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(219);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expression);
					setState(213);
					if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
					setState(214); op();
					setState(215); expression(5);
					}
					} 
				}
				setState(221);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class MethodCallContext extends ParserRuleContext {
		public ArgContext arg(int i) {
			return getRuleContext(ArgContext.class,i);
		}
		public TerminalNode ID() { return getToken(decafParser.ID, 0); }
		public List<ArgContext> arg() {
			return getRuleContexts(ArgContext.class);
		}
		public MethodCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).enterMethodCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).exitMethodCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof decafVisitor ) return ((decafVisitor<? extends T>)visitor).visitMethodCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodCallContext methodCall() throws RecognitionException {
		MethodCallContext _localctx = new MethodCallContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_methodCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222); match(ID);
			setState(223); match(T__17);
			setState(232);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__33) | (1L << T__17) | (1L << T__14) | (1L << T__5) | (1L << T__0) | (1L << ID) | (1L << NUM) | (1L << CHAR))) != 0)) {
				{
				setState(224); arg();
				setState(229);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__15) {
					{
					{
					setState(225); match(T__15);
					setState(226); arg();
					}
					}
					setState(231);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(234); match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).enterArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).exitArg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof decafVisitor ) return ((decafVisitor<? extends T>)visitor).visitArg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgContext arg() throws RecognitionException {
		ArgContext _localctx = new ArgContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_arg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236); expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OpContext extends ParserRuleContext {
		public Rel_opContext rel_op() {
			return getRuleContext(Rel_opContext.class,0);
		}
		public Eq_opContext eq_op() {
			return getRuleContext(Eq_opContext.class,0);
		}
		public Cond_opContext cond_op() {
			return getRuleContext(Cond_opContext.class,0);
		}
		public OpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).enterOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).exitOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof decafVisitor ) return ((decafVisitor<? extends T>)visitor).visitOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OpContext op() throws RecognitionException {
		OpContext _localctx = new OpContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_op);
		try {
			setState(241);
			switch (_input.LA(1)) {
			case T__19:
			case T__11:
			case T__8:
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(238); rel_op();
				}
				break;
			case T__31:
			case T__9:
				enterOuterAlt(_localctx, 2);
				{
				setState(239); eq_op();
				}
				break;
			case T__29:
			case T__24:
				enterOuterAlt(_localctx, 3);
				{
				setState(240); cond_op();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Calc_opContext extends ParserRuleContext {
		public PlusOrMinusContext plusOrMinus() {
			return getRuleContext(PlusOrMinusContext.class,0);
		}
		public Calc_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_calc_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).enterCalc_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).exitCalc_op(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof decafVisitor ) return ((decafVisitor<? extends T>)visitor).visitCalc_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Calc_opContext calc_op() throws RecognitionException {
		Calc_opContext _localctx = new Calc_opContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_calc_op);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243); plusOrMinus(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PlusOrMinusContext extends ParserRuleContext {
		public MultOrDivContext multOrDiv() {
			return getRuleContext(MultOrDivContext.class,0);
		}
		public PlusOrMinusContext plusOrMinus() {
			return getRuleContext(PlusOrMinusContext.class,0);
		}
		public PlusOrMinusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plusOrMinus; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).enterPlusOrMinus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).exitPlusOrMinus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof decafVisitor ) return ((decafVisitor<? extends T>)visitor).visitPlusOrMinus(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PlusOrMinusContext plusOrMinus() throws RecognitionException {
		return plusOrMinus(0);
	}

	private PlusOrMinusContext plusOrMinus(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PlusOrMinusContext _localctx = new PlusOrMinusContext(_ctx, _parentState);
		PlusOrMinusContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_plusOrMinus, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(246); multOrDiv(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(256);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(254);
					switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
					case 1:
						{
						_localctx = new PlusOrMinusContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_plusOrMinus);
						setState(248);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(249); match(T__2);
						setState(250); multOrDiv(0);
						}
						break;
					case 2:
						{
						_localctx = new PlusOrMinusContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_plusOrMinus);
						setState(251);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(252); match(T__0);
						setState(253); multOrDiv(0);
						}
						break;
					}
					} 
				}
				setState(258);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class MultOrDivContext extends ParserRuleContext {
		public PowContext pow() {
			return getRuleContext(PowContext.class,0);
		}
		public MultOrDivContext multOrDiv() {
			return getRuleContext(MultOrDivContext.class,0);
		}
		public MultOrDivContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multOrDiv; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).enterMultOrDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).exitMultOrDiv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof decafVisitor ) return ((decafVisitor<? extends T>)visitor).visitMultOrDiv(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultOrDivContext multOrDiv() throws RecognitionException {
		return multOrDiv(0);
	}

	private MultOrDivContext multOrDiv(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MultOrDivContext _localctx = new MultOrDivContext(_ctx, _parentState);
		MultOrDivContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_multOrDiv, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(260); pow();
			}
			_ctx.stop = _input.LT(-1);
			setState(270);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(268);
					switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
					case 1:
						{
						_localctx = new MultOrDivContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_multOrDiv);
						setState(262);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(263); match(T__16);
						setState(264); pow();
						}
						break;
					case 2:
						{
						_localctx = new MultOrDivContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_multOrDiv);
						setState(265);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(266); match(T__35);
						setState(267); pow();
						}
						break;
					}
					} 
				}
				setState(272);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PowContext extends ParserRuleContext {
		public UnaryMinusContext unaryMinus() {
			return getRuleContext(UnaryMinusContext.class,0);
		}
		public PowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pow; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).enterPow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).exitPow(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof decafVisitor ) return ((decafVisitor<? extends T>)visitor).visitPow(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PowContext pow() throws RecognitionException {
		PowContext _localctx = new PowContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_pow);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273); unaryMinus();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryMinusContext extends ParserRuleContext {
		public UnaryMinusContext unaryMinus() {
			return getRuleContext(UnaryMinusContext.class,0);
		}
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public UnaryMinusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryMinus; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).enterUnaryMinus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).exitUnaryMinus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof decafVisitor ) return ((decafVisitor<? extends T>)visitor).visitUnaryMinus(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryMinusContext unaryMinus() throws RecognitionException {
		UnaryMinusContext _localctx = new UnaryMinusContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_unaryMinus);
		try {
			setState(278);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(275); match(T__0);
				setState(276); unaryMinus();
				}
				break;
			case T__33:
			case T__17:
			case T__14:
			case ID:
			case NUM:
			case CHAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(277); atom();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtomContext extends ParserRuleContext {
		public LocationContext location() {
			return getRuleContext(LocationContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public PlusOrMinusContext plusOrMinus() {
			return getRuleContext(PlusOrMinusContext.class,0);
		}
		public MethodCallContext methodCall() {
			return getRuleContext(MethodCallContext.class,0);
		}
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).exitAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof decafVisitor ) return ((decafVisitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_atom);
		try {
			setState(287);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(280); match(T__17);
				setState(281); plusOrMinus(0);
				setState(282); match(T__3);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(284); literal();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(285); location();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(286); methodCall();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Rel_opContext extends ParserRuleContext {
		public Rel_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rel_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).enterRel_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).exitRel_op(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof decafVisitor ) return ((decafVisitor<? extends T>)visitor).visitRel_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Rel_opContext rel_op() throws RecognitionException {
		Rel_opContext _localctx = new Rel_opContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_rel_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(289);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__19) | (1L << T__11) | (1L << T__8) | (1L << T__6))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Eq_opContext extends ParserRuleContext {
		public Eq_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eq_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).enterEq_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).exitEq_op(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof decafVisitor ) return ((decafVisitor<? extends T>)visitor).visitEq_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Eq_opContext eq_op() throws RecognitionException {
		Eq_opContext _localctx = new Eq_opContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_eq_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
			_la = _input.LA(1);
			if ( !(_la==T__31 || _la==T__9) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Cond_opContext extends ParserRuleContext {
		public Cond_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).enterCond_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).exitCond_op(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof decafVisitor ) return ((decafVisitor<? extends T>)visitor).visitCond_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Cond_opContext cond_op() throws RecognitionException {
		Cond_opContext _localctx = new Cond_opContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_cond_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			_la = _input.LA(1);
			if ( !(_la==T__29 || _la==T__24) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public Int_literalContext int_literal() {
			return getRuleContext(Int_literalContext.class,0);
		}
		public Char_literalContext char_literal() {
			return getRuleContext(Char_literalContext.class,0);
		}
		public Bool_literalContext bool_literal() {
			return getRuleContext(Bool_literalContext.class,0);
		}
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof decafVisitor ) return ((decafVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_literal);
		try {
			setState(298);
			switch (_input.LA(1)) {
			case NUM:
				enterOuterAlt(_localctx, 1);
				{
				setState(295); int_literal();
				}
				break;
			case CHAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(296); char_literal();
				}
				break;
			case T__33:
			case T__14:
				enterOuterAlt(_localctx, 3);
				{
				setState(297); bool_literal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Int_literalContext extends ParserRuleContext {
		public TerminalNode NUM() { return getToken(decafParser.NUM, 0); }
		public Int_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_int_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).enterInt_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).exitInt_literal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof decafVisitor ) return ((decafVisitor<? extends T>)visitor).visitInt_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Int_literalContext int_literal() throws RecognitionException {
		Int_literalContext _localctx = new Int_literalContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_int_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(300); match(NUM);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Char_literalContext extends ParserRuleContext {
		public TerminalNode CHAR() { return getToken(decafParser.CHAR, 0); }
		public Char_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_char_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).enterChar_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).exitChar_literal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof decafVisitor ) return ((decafVisitor<? extends T>)visitor).visitChar_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Char_literalContext char_literal() throws RecognitionException {
		Char_literalContext _localctx = new Char_literalContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_char_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302); match(CHAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Bool_literalContext extends ParserRuleContext {
		public Bool_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).enterBool_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).exitBool_literal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof decafVisitor ) return ((decafVisitor<? extends T>)visitor).visitBool_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bool_literalContext bool_literal() throws RecognitionException {
		Bool_literalContext _localctx = new Bool_literalContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_bool_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(304);
			_la = _input.LA(1);
			if ( !(_la==T__33 || _la==T__14) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 12: return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 17: return plusOrMinus_sempred((PlusOrMinusContext)_localctx, predIndex);
		case 18: return multOrDiv_sempred((MultOrDivContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean multOrDiv_sempred(MultOrDivContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3: return precpred(_ctx, 3);
		case 4: return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 4);
		}
		return true;
	}
	private boolean plusOrMinus_sempred(PlusOrMinusContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1: return precpred(_ctx, 3);
		case 2: return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3+\u0135\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\3\2\3\2\7\2"+
		"A\n\2\f\2\16\2D\13\2\3\2\3\2\3\3\3\3\3\3\5\3K\n\3\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\5\4T\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5a\n\5"+
		"\3\6\3\6\3\6\3\6\7\6g\n\6\f\6\16\6j\13\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\7\7t\n\7\f\7\16\7w\13\7\5\7y\n\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\5\t\u0088\n\t\3\n\3\n\3\13\3\13\7\13\u008e\n\13\f\13"+
		"\16\13\u0091\13\13\3\13\7\13\u0094\n\13\f\13\16\13\u0097\13\13\3\13\3"+
		"\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00a2\n\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\5\f\u00ac\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00b8"+
		"\n\f\3\f\5\f\u00bb\n\f\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00c3\n\r\3\r\3\r\5"+
		"\r\u00c7\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\5\16\u00d6\n\16\3\16\3\16\3\16\3\16\7\16\u00dc\n\16\f\16\16\16"+
		"\u00df\13\16\3\17\3\17\3\17\3\17\3\17\7\17\u00e6\n\17\f\17\16\17\u00e9"+
		"\13\17\5\17\u00eb\n\17\3\17\3\17\3\20\3\20\3\21\3\21\3\21\5\21\u00f4\n"+
		"\21\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\7\23\u0101"+
		"\n\23\f\23\16\23\u0104\13\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\7\24\u010f\n\24\f\24\16\24\u0112\13\24\3\25\3\25\3\26\3\26\3\26\5"+
		"\26\u0119\n\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u0122\n\27\3\30"+
		"\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\33\5\33\u012d\n\33\3\34\3\34\3\35"+
		"\3\35\3\36\3\36\3\36\2\5\32$&\37\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \"$&(*,.\60\62\64\668:\2\b\6\2\4\4\f\f\24\24\32\32\5\2\4\4\24\24\32\32"+
		"\6\2\23\23\33\33\36\36  \4\2\7\7\35\35\4\2\t\t\16\16\4\2\5\5\30\30\u0146"+
		"\2<\3\2\2\2\4J\3\2\2\2\6S\3\2\2\2\b`\3\2\2\2\nb\3\2\2\2\fm\3\2\2\2\16"+
		"}\3\2\2\2\20\u0087\3\2\2\2\22\u0089\3\2\2\2\24\u008b\3\2\2\2\26\u00ba"+
		"\3\2\2\2\30\u00c2\3\2\2\2\32\u00d5\3\2\2\2\34\u00e0\3\2\2\2\36\u00ee\3"+
		"\2\2\2 \u00f3\3\2\2\2\"\u00f5\3\2\2\2$\u00f7\3\2\2\2&\u0105\3\2\2\2(\u0113"+
		"\3\2\2\2*\u0118\3\2\2\2,\u0121\3\2\2\2.\u0123\3\2\2\2\60\u0125\3\2\2\2"+
		"\62\u0127\3\2\2\2\64\u012c\3\2\2\2\66\u012e\3\2\2\28\u0130\3\2\2\2:\u0132"+
		"\3\2\2\2<=\7\b\2\2=>\7\21\2\2>B\7\r\2\2?A\5\4\3\2@?\3\2\2\2AD\3\2\2\2"+
		"B@\3\2\2\2BC\3\2\2\2CE\3\2\2\2DB\3\2\2\2EF\7\20\2\2F\3\3\2\2\2GK\5\n\6"+
		"\2HK\5\b\5\2IK\5\f\7\2JG\3\2\2\2JH\3\2\2\2JI\3\2\2\2K\5\3\2\2\2LT\7\24"+
		"\2\2MT\7\4\2\2NT\7\32\2\2OP\7%\2\2PT\7\'\2\2QT\7\f\2\2RT\5\n\6\2SL\3\2"+
		"\2\2SM\3\2\2\2SN\3\2\2\2SO\3\2\2\2SQ\3\2\2\2SR\3\2\2\2T\7\3\2\2\2UV\5"+
		"\6\4\2VW\7\'\2\2WX\7\13\2\2Xa\3\2\2\2YZ\5\6\4\2Z[\7\'\2\2[\\\7\34\2\2"+
		"\\]\7(\2\2]^\7\37\2\2^_\7\13\2\2_a\3\2\2\2`U\3\2\2\2`Y\3\2\2\2a\t\3\2"+
		"\2\2bc\7%\2\2cd\7\'\2\2dh\7\r\2\2eg\5\b\5\2fe\3\2\2\2gj\3\2\2\2hf\3\2"+
		"\2\2hi\3\2\2\2ik\3\2\2\2jh\3\2\2\2kl\7\20\2\2l\13\3\2\2\2mn\5\16\b\2n"+
		"o\7\'\2\2ox\7\25\2\2pu\5\20\t\2qr\7\27\2\2rt\5\20\t\2sq\3\2\2\2tw\3\2"+
		"\2\2us\3\2\2\2uv\3\2\2\2vy\3\2\2\2wu\3\2\2\2xp\3\2\2\2xy\3\2\2\2yz\3\2"+
		"\2\2z{\7#\2\2{|\5\24\13\2|\r\3\2\2\2}~\t\2\2\2~\17\3\2\2\2\177\u0080\5"+
		"\22\n\2\u0080\u0081\7\'\2\2\u0081\u0088\3\2\2\2\u0082\u0083\5\22\n\2\u0083"+
		"\u0084\7\'\2\2\u0084\u0085\7\34\2\2\u0085\u0086\7\37\2\2\u0086\u0088\3"+
		"\2\2\2\u0087\177\3\2\2\2\u0087\u0082\3\2\2\2\u0088\21\3\2\2\2\u0089\u008a"+
		"\t\3\2\2\u008a\23\3\2\2\2\u008b\u008f\7\r\2\2\u008c\u008e\5\b\5\2\u008d"+
		"\u008c\3\2\2\2\u008e\u0091\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2"+
		"\2\2\u0090\u0095\3\2\2\2\u0091\u008f\3\2\2\2\u0092\u0094\5\26\f\2\u0093"+
		"\u0092\3\2\2\2\u0094\u0097\3\2\2\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2"+
		"\2\2\u0096\u0098\3\2\2\2\u0097\u0095\3\2\2\2\u0098\u0099\7\20\2\2\u0099"+
		"\25\3\2\2\2\u009a\u009b\7\22\2\2\u009b\u009c\7\25\2\2\u009c\u009d\5\32"+
		"\16\2\u009d\u009e\7#\2\2\u009e\u00a1\5\24\13\2\u009f\u00a0\7\"\2\2\u00a0"+
		"\u00a2\5\24\13\2\u00a1\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00bb\3"+
		"\2\2\2\u00a3\u00a4\7\n\2\2\u00a4\u00a5\7\25\2\2\u00a5\u00a6\5\32\16\2"+
		"\u00a6\u00a7\7#\2\2\u00a7\u00a8\5\24\13\2\u00a8\u00bb\3\2\2\2\u00a9\u00ab"+
		"\7\6\2\2\u00aa\u00ac\5\32\16\2\u00ab\u00aa\3\2\2\2\u00ab\u00ac\3\2\2\2"+
		"\u00ac\u00ad\3\2\2\2\u00ad\u00bb\7\13\2\2\u00ae\u00af\5\34\17\2\u00af"+
		"\u00b0\7\13\2\2\u00b0\u00bb\3\2\2\2\u00b1\u00bb\5\24\13\2\u00b2\u00b3"+
		"\5\30\r\2\u00b3\u00b4\7\17\2\2\u00b4\u00b5\5\32\16\2\u00b5\u00bb\3\2\2"+
		"\2\u00b6\u00b8\5\32\16\2\u00b7\u00b6\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8"+
		"\u00b9\3\2\2\2\u00b9\u00bb\7\13\2\2\u00ba\u009a\3\2\2\2\u00ba\u00a3\3"+
		"\2\2\2\u00ba\u00a9\3\2\2\2\u00ba\u00ae\3\2\2\2\u00ba\u00b1\3\2\2\2\u00ba"+
		"\u00b2\3\2\2\2\u00ba\u00b7\3\2\2\2\u00bb\27\3\2\2\2\u00bc\u00c3\7\'\2"+
		"\2\u00bd\u00be\7\'\2\2\u00be\u00bf\7\34\2\2\u00bf\u00c0\5\32\16\2\u00c0"+
		"\u00c1\7\37\2\2\u00c1\u00c3\3\2\2\2\u00c2\u00bc\3\2\2\2\u00c2\u00bd\3"+
		"\2\2\2\u00c3\u00c6\3\2\2\2\u00c4\u00c5\7\31\2\2\u00c5\u00c7\5\30\r\2\u00c6"+
		"\u00c4\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\31\3\2\2\2\u00c8\u00c9\b\16\1"+
		"\2\u00c9\u00ca\7&\2\2\u00ca\u00d6\5\32\16\5\u00cb\u00cc\7!\2\2\u00cc\u00d6"+
		"\5\32\16\4\u00cd\u00d6\5\30\r\2\u00ce\u00d6\5\34\17\2\u00cf\u00d6\5\64"+
		"\33\2\u00d0\u00d6\5\"\22\2\u00d1\u00d2\7\25\2\2\u00d2\u00d3\5\32\16\2"+
		"\u00d3\u00d4\7#\2\2\u00d4\u00d6\3\2\2\2\u00d5\u00c8\3\2\2\2\u00d5\u00cb"+
		"\3\2\2\2\u00d5\u00cd\3\2\2\2\u00d5\u00ce\3\2\2\2\u00d5\u00cf\3\2\2\2\u00d5"+
		"\u00d0\3\2\2\2\u00d5\u00d1\3\2\2\2\u00d6\u00dd\3\2\2\2\u00d7\u00d8\f\6"+
		"\2\2\u00d8\u00d9\5 \21\2\u00d9\u00da\5\32\16\7\u00da\u00dc\3\2\2\2\u00db"+
		"\u00d7\3\2\2\2\u00dc\u00df\3\2\2\2\u00dd\u00db\3\2\2\2\u00dd\u00de\3\2"+
		"\2\2\u00de\33\3\2\2\2\u00df\u00dd\3\2\2\2\u00e0\u00e1\7\'\2\2\u00e1\u00ea"+
		"\7\25\2\2\u00e2\u00e7\5\36\20\2\u00e3\u00e4\7\27\2\2\u00e4\u00e6\5\36"+
		"\20\2\u00e5\u00e3\3\2\2\2\u00e6\u00e9\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e7"+
		"\u00e8\3\2\2\2\u00e8\u00eb\3\2\2\2\u00e9\u00e7\3\2\2\2\u00ea\u00e2\3\2"+
		"\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ed\7#\2\2\u00ed"+
		"\35\3\2\2\2\u00ee\u00ef\5\32\16\2\u00ef\37\3\2\2\2\u00f0\u00f4\5.\30\2"+
		"\u00f1\u00f4\5\60\31\2\u00f2\u00f4\5\62\32\2\u00f3\u00f0\3\2\2\2\u00f3"+
		"\u00f1\3\2\2\2\u00f3\u00f2\3\2\2\2\u00f4!\3\2\2\2\u00f5\u00f6\5$\23\2"+
		"\u00f6#\3\2\2\2\u00f7\u00f8\b\23\1\2\u00f8\u00f9\5&\24\2\u00f9\u0102\3"+
		"\2\2\2\u00fa\u00fb\f\5\2\2\u00fb\u00fc\7$\2\2\u00fc\u0101\5&\24\2\u00fd"+
		"\u00fe\f\4\2\2\u00fe\u00ff\7&\2\2\u00ff\u0101\5&\24\2\u0100\u00fa\3\2"+
		"\2\2\u0100\u00fd\3\2\2\2\u0101\u0104\3\2\2\2\u0102\u0100\3\2\2\2\u0102"+
		"\u0103\3\2\2\2\u0103%\3\2\2\2\u0104\u0102\3\2\2\2\u0105\u0106\b\24\1\2"+
		"\u0106\u0107\5(\25\2\u0107\u0110\3\2\2\2\u0108\u0109\f\5\2\2\u0109\u010a"+
		"\7\26\2\2\u010a\u010f\5(\25\2\u010b\u010c\f\4\2\2\u010c\u010d\7\3\2\2"+
		"\u010d\u010f\5(\25\2\u010e\u0108\3\2\2\2\u010e\u010b\3\2\2\2\u010f\u0112"+
		"\3\2\2\2\u0110\u010e\3\2\2\2\u0110\u0111\3\2\2\2\u0111\'\3\2\2\2\u0112"+
		"\u0110\3\2\2\2\u0113\u0114\5*\26\2\u0114)\3\2\2\2\u0115\u0116\7&\2\2\u0116"+
		"\u0119\5*\26\2\u0117\u0119\5,\27\2\u0118\u0115\3\2\2\2\u0118\u0117\3\2"+
		"\2\2\u0119+\3\2\2\2\u011a\u011b\7\25\2\2\u011b\u011c\5$\23\2\u011c\u011d"+
		"\7#\2\2\u011d\u0122\3\2\2\2\u011e\u0122\5\64\33\2\u011f\u0122\5\30\r\2"+
		"\u0120\u0122\5\34\17\2\u0121\u011a\3\2\2\2\u0121\u011e\3\2\2\2\u0121\u011f"+
		"\3\2\2\2\u0121\u0120\3\2\2\2\u0122-\3\2\2\2\u0123\u0124\t\4\2\2\u0124"+
		"/\3\2\2\2\u0125\u0126\t\5\2\2\u0126\61\3\2\2\2\u0127\u0128\t\6\2\2\u0128"+
		"\63\3\2\2\2\u0129\u012d\5\66\34\2\u012a\u012d\58\35\2\u012b\u012d\5:\36"+
		"\2\u012c\u0129\3\2\2\2\u012c\u012a\3\2\2\2\u012c\u012b\3\2\2\2\u012d\65"+
		"\3\2\2\2\u012e\u012f\7(\2\2\u012f\67\3\2\2\2\u0130\u0131\7)\2\2\u0131"+
		"9\3\2\2\2\u0132\u0133\t\7\2\2\u0133;\3\2\2\2\36BJS`hux\u0087\u008f\u0095"+
		"\u00a1\u00ab\u00b7\u00ba\u00c2\u00c6\u00d5\u00dd\u00e7\u00ea\u00f3\u0100"+
		"\u0102\u010e\u0110\u0118\u0121\u012c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
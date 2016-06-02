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
		T__4=32, T__3=33, T__2=34, T__1=35, T__0=36, ID=37, NUM=38, STRING=39, 
		CHAR=40, WS=41, COMMENTS=42;
	public static final String[] tokenNames = {
		"<INVALID>", "'/'", "'char'", "'true'", "'return'", "'!='", "'class'", 
		"'||'", "'while'", "'void'", "';'", "'{'", "'&&'", "'='", "'}'", "'if'", 
		"'<='", "'int'", "'print'", "'('", "'*'", "','", "'false'", "'.'", "'boolean'", 
		"'>='", "'['", "'=='", "'<'", "']'", "'>'", "'!'", "'else'", "')'", "'+'", 
		"'struct'", "'-'", "ID", "NUM", "STRING", "CHAR", "WS", "COMMENTS"
	};
	public static final int
		RULE_program = 0, RULE_declaration = 1, RULE_varType = 2, RULE_varDeclaration = 3, 
		RULE_structDeclaration = 4, RULE_methodDeclaration = 5, RULE_methodType = 6, 
		RULE_parameter = 7, RULE_parameterType = 8, RULE_block = 9, RULE_statement = 10, 
		RULE_location = 11, RULE_expression = 12, RULE_methodCall = 13, RULE_arg = 14, 
		RULE_op = 15, RULE_condOp = 16, RULE_assignOp = 17, RULE_pow2 = 18, RULE_unaryMinus2 = 19, 
		RULE_atom2 = 20, RULE_plusOrMinus = 21, RULE_multOrDiv = 22, RULE_pow = 23, 
		RULE_unaryMinus = 24, RULE_atom = 25, RULE_rel_op = 26, RULE_eq_op = 27, 
		RULE_cond_op = 28, RULE_literal = 29, RULE_int_literal = 30, RULE_char_literal = 31, 
		RULE_bool_literal = 32;
	public static final String[] ruleNames = {
		"program", "declaration", "varType", "varDeclaration", "structDeclaration", 
		"methodDeclaration", "methodType", "parameter", "parameterType", "block", 
		"statement", "location", "expression", "methodCall", "arg", "op", "condOp", 
		"assignOp", "pow2", "unaryMinus2", "atom2", "plusOrMinus", "multOrDiv", 
		"pow", "unaryMinus", "atom", "rel_op", "eq_op", "cond_op", "literal", 
		"int_literal", "char_literal", "bool_literal"
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
		public TerminalNode ID() { return getToken(decafParser.ID, 0); }
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
			setState(66); match(T__30);
			setState(67); match(ID);
			setState(68); match(T__25);
			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__34) | (1L << T__27) | (1L << T__19) | (1L << T__12) | (1L << T__1))) != 0)) {
				{
				{
				setState(69); declaration();
				}
				}
				setState(74);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(75); match(T__22);
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
			setState(80);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(77); structDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(78); varDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(79); methodDeclaration();
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
			setState(88);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(82); match(T__19);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(83); match(T__34);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(84); match(T__12);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(85); match(T__1);
				setState(86); match(ID);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(87); structDeclaration();
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
			setState(101);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(90); varType();
				setState(91); match(ID);
				setState(92); match(T__26);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(94); varType();
				setState(95); match(ID);
				setState(96); match(T__10);
				setState(97); match(NUM);
				setState(98); match(T__7);
				setState(99); match(T__26);
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
			setState(103); match(T__1);
			setState(104); match(ID);
			setState(105); match(T__25);
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__34) | (1L << T__19) | (1L << T__12) | (1L << T__1))) != 0)) {
				{
				{
				setState(106); varDeclaration();
				}
				}
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(112); match(T__22);
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
			setState(114); methodType();
			setState(115); match(ID);
			setState(116); match(T__17);
			setState(125);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__34) | (1L << T__19) | (1L << T__12))) != 0)) {
				{
				setState(117); parameter();
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__15) {
					{
					{
					setState(118); match(T__15);
					setState(119); parameter();
					}
					}
					setState(124);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(127); match(T__3);
			setState(128); block();
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
			setState(130);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__34) | (1L << T__27) | (1L << T__19) | (1L << T__12))) != 0)) ) {
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
			setState(140);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(132); parameterType();
				setState(133); match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(135); parameterType();
				setState(136); match(ID);
				setState(137); match(T__10);
				setState(138); match(T__7);
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
			setState(142);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__34) | (1L << T__19) | (1L << T__12))) != 0)) ) {
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
			setState(144); match(T__25);
			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__34) | (1L << T__33) | (1L << T__32) | (1L << T__28) | (1L << T__25) | (1L << T__21) | (1L << T__19) | (1L << T__18) | (1L << T__17) | (1L << T__14) | (1L << T__12) | (1L << T__5) | (1L << T__1) | (1L << T__0) | (1L << ID) | (1L << NUM) | (1L << CHAR))) != 0)) {
				{
				setState(147);
				switch (_input.LA(1)) {
				case T__34:
				case T__19:
				case T__12:
				case T__1:
					{
					setState(145); varDeclaration();
					}
					break;
				case T__33:
				case T__32:
				case T__28:
				case T__25:
				case T__21:
				case T__18:
				case T__17:
				case T__14:
				case T__5:
				case T__0:
				case ID:
				case NUM:
				case CHAR:
					{
					setState(146); statement();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(151);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(152); match(T__22);
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
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StatementAsignContext extends StatementContext {
		public LocationContext location() {
			return getRuleContext(LocationContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementAsignContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).enterStatementAsign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).exitStatementAsign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof decafVisitor ) return ((decafVisitor<? extends T>)visitor).visitStatementAsign(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatementExpContext extends StatementContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementExpContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).enterStatementExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).exitStatementExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof decafVisitor ) return ((decafVisitor<? extends T>)visitor).visitStatementExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatementReturnContext extends StatementContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementReturnContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).enterStatementReturn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).exitStatementReturn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof decafVisitor ) return ((decafVisitor<? extends T>)visitor).visitStatementReturn(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatementBlockContext extends StatementContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public StatementBlockContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).enterStatementBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).exitStatementBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof decafVisitor ) return ((decafVisitor<? extends T>)visitor).visitStatementBlock(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatementWhileContext extends StatementContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public StatementWhileContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).enterStatementWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).exitStatementWhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof decafVisitor ) return ((decafVisitor<? extends T>)visitor).visitStatementWhile(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatementIfContext extends StatementContext {
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public StatementIfContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).enterStatementIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).exitStatementIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof decafVisitor ) return ((decafVisitor<? extends T>)visitor).visitStatementIf(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatementPrintContext extends StatementContext {
		public TerminalNode STRING() { return getToken(decafParser.STRING, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementPrintContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).enterStatementPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).exitStatementPrint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof decafVisitor ) return ((decafVisitor<? extends T>)visitor).visitStatementPrint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_statement);
		int _la;
		try {
			setState(192);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				_localctx = new StatementIfContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(154); match(T__21);
				setState(155); match(T__17);
				setState(156); expression();
				setState(157); match(T__3);
				setState(158); block();
				setState(161);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(159); match(T__4);
					setState(160); block();
					}
				}

				}
				break;
			case 2:
				_localctx = new StatementWhileContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(163); match(T__28);
				setState(164); match(T__17);
				setState(165); expression();
				setState(166); match(T__3);
				setState(167); block();
				}
				break;
			case 3:
				_localctx = new StatementReturnContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(169); match(T__32);
				setState(171);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__33) | (1L << T__17) | (1L << T__14) | (1L << T__5) | (1L << T__0) | (1L << ID) | (1L << NUM) | (1L << CHAR))) != 0)) {
					{
					setState(170); expression();
					}
				}

				setState(173); match(T__26);
				}
				break;
			case 4:
				_localctx = new StatementBlockContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(174); block();
				}
				break;
			case 5:
				_localctx = new StatementAsignContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(175); location();
				setState(176); match(T__23);
				setState(177); expression();
				setState(178); match(T__26);
				}
				break;
			case 6:
				_localctx = new StatementExpContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(180); expression();
				setState(181); match(T__26);
				}
				break;
			case 7:
				_localctx = new StatementPrintContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(183); match(T__18);
				setState(184); match(T__17);
				setState(185); match(STRING);
				setState(188);
				_la = _input.LA(1);
				if (_la==T__15) {
					{
					setState(186); match(T__15);
					setState(187); expression();
					}
				}

				setState(190); match(T__3);
				setState(191); match(T__26);
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
		public LocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_location; }
	 
		public LocationContext() { }
		public void copyFrom(LocationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LocationIDlocationContext extends LocationContext {
		public TerminalNode ID() { return getToken(decafParser.ID, 0); }
		public LocationContext location() {
			return getRuleContext(LocationContext.class,0);
		}
		public LocationIDlocationContext(LocationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).enterLocationIDlocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).exitLocationIDlocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof decafVisitor ) return ((decafVisitor<? extends T>)visitor).visitLocationIDlocation(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LocationExpContext extends LocationContext {
		public TerminalNode ID() { return getToken(decafParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LocationExpContext(LocationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).enterLocationExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).exitLocationExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof decafVisitor ) return ((decafVisitor<? extends T>)visitor).visitLocationExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LocationIDContext extends LocationContext {
		public TerminalNode ID() { return getToken(decafParser.ID, 0); }
		public LocationIDContext(LocationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).enterLocationID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).exitLocationID(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof decafVisitor ) return ((decafVisitor<? extends T>)visitor).visitLocationID(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LocationExplocationContext extends LocationContext {
		public TerminalNode ID() { return getToken(decafParser.ID, 0); }
		public LocationContext location() {
			return getRuleContext(LocationContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LocationExplocationContext(LocationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).enterLocationExplocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).exitLocationExplocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof decafVisitor ) return ((decafVisitor<? extends T>)visitor).visitLocationExplocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocationContext location() throws RecognitionException {
		LocationContext _localctx = new LocationContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_location);
		try {
			setState(210);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				_localctx = new LocationIDContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(194); match(ID);
				}
				break;
			case 2:
				_localctx = new LocationIDlocationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(195); match(ID);
				setState(196); match(T__13);
				setState(197); location();
				}
				break;
			case 3:
				_localctx = new LocationExpContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(198); match(ID);
				setState(199); match(T__10);
				setState(200); expression();
				setState(201); match(T__7);
				}
				break;
			case 4:
				_localctx = new LocationExplocationContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(203); match(ID);
				setState(204); match(T__10);
				setState(205); expression();
				setState(206); match(T__7);
				setState(207); match(T__13);
				setState(208); location();
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

	public static class ExpressionContext extends ParserRuleContext {
		public CondOpContext condOp() {
			return getRuleContext(CondOpContext.class,0);
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
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212); condOp(0);
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
			setState(214); match(ID);
			setState(215); match(T__17);
			setState(224);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__33) | (1L << T__17) | (1L << T__14) | (1L << T__5) | (1L << T__0) | (1L << ID) | (1L << NUM) | (1L << CHAR))) != 0)) {
				{
				setState(216); arg();
				setState(221);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__15) {
					{
					{
					setState(217); match(T__15);
					setState(218); arg();
					}
					}
					setState(223);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(226); match(T__3);
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
			setState(228); expression();
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
			setState(232);
			switch (_input.LA(1)) {
			case T__20:
			case T__11:
			case T__8:
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(230); rel_op();
				}
				break;
			case T__31:
			case T__9:
				enterOuterAlt(_localctx, 2);
				{
				setState(231); eq_op();
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

	public static class CondOpContext extends ParserRuleContext {
		public CondOpContext condOp() {
			return getRuleContext(CondOpContext.class,0);
		}
		public AssignOpContext assignOp() {
			return getRuleContext(AssignOpContext.class,0);
		}
		public Cond_opContext cond_op() {
			return getRuleContext(Cond_opContext.class,0);
		}
		public CondOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).enterCondOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).exitCondOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof decafVisitor ) return ((decafVisitor<? extends T>)visitor).visitCondOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondOpContext condOp() throws RecognitionException {
		return condOp(0);
	}

	private CondOpContext condOp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		CondOpContext _localctx = new CondOpContext(_ctx, _parentState);
		CondOpContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_condOp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(235); assignOp(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(243);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new CondOpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_condOp);
					setState(237);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(238); cond_op();
					setState(239); assignOp(0);
					}
					} 
				}
				setState(245);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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

	public static class AssignOpContext extends ParserRuleContext {
		public OpContext op() {
			return getRuleContext(OpContext.class,0);
		}
		public AssignOpContext assignOp() {
			return getRuleContext(AssignOpContext.class,0);
		}
		public Pow2Context pow2() {
			return getRuleContext(Pow2Context.class,0);
		}
		public AssignOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).enterAssignOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).exitAssignOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof decafVisitor ) return ((decafVisitor<? extends T>)visitor).visitAssignOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignOpContext assignOp() throws RecognitionException {
		return assignOp(0);
	}

	private AssignOpContext assignOp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AssignOpContext _localctx = new AssignOpContext(_ctx, _parentState);
		AssignOpContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_assignOp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(247); pow2();
			}
			_ctx.stop = _input.LT(-1);
			setState(255);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AssignOpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_assignOp);
					setState(249);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(250); op();
					setState(251); pow2();
					}
					} 
				}
				setState(257);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
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

	public static class Pow2Context extends ParserRuleContext {
		public UnaryMinus2Context unaryMinus2() {
			return getRuleContext(UnaryMinus2Context.class,0);
		}
		public Pow2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pow2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).enterPow2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).exitPow2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof decafVisitor ) return ((decafVisitor<? extends T>)visitor).visitPow2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pow2Context pow2() throws RecognitionException {
		Pow2Context _localctx = new Pow2Context(_ctx, getState());
		enterRule(_localctx, 36, RULE_pow2);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258); unaryMinus2();
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

	public static class UnaryMinus2Context extends ParserRuleContext {
		public Atom2Context atom2() {
			return getRuleContext(Atom2Context.class,0);
		}
		public UnaryMinus2Context unaryMinus2() {
			return getRuleContext(UnaryMinus2Context.class,0);
		}
		public UnaryMinus2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryMinus2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).enterUnaryMinus2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).exitUnaryMinus2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof decafVisitor ) return ((decafVisitor<? extends T>)visitor).visitUnaryMinus2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryMinus2Context unaryMinus2() throws RecognitionException {
		UnaryMinus2Context _localctx = new UnaryMinus2Context(_ctx, getState());
		enterRule(_localctx, 38, RULE_unaryMinus2);
		try {
			setState(263);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(260); match(T__5);
				setState(261); unaryMinus2();
				}
				break;
			case T__33:
			case T__17:
			case T__14:
			case T__0:
			case ID:
			case NUM:
			case CHAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(262); atom2();
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

	public static class Atom2Context extends ParserRuleContext {
		public CondOpContext condOp() {
			return getRuleContext(CondOpContext.class,0);
		}
		public LocationContext location() {
			return getRuleContext(LocationContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public MethodCallContext methodCall() {
			return getRuleContext(MethodCallContext.class,0);
		}
		public PlusOrMinusContext plusOrMinus() {
			return getRuleContext(PlusOrMinusContext.class,0);
		}
		public Atom2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).enterAtom2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof decafListener ) ((decafListener)listener).exitAtom2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof decafVisitor ) return ((decafVisitor<? extends T>)visitor).visitAtom2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Atom2Context atom2() throws RecognitionException {
		Atom2Context _localctx = new Atom2Context(_ctx, getState());
		enterRule(_localctx, 40, RULE_atom2);
		try {
			setState(273);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(265); match(T__17);
				setState(266); condOp(0);
				setState(267); match(T__3);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(269); literal();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(270); location();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(271); methodCall();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(272); plusOrMinus(0);
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
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_plusOrMinus, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(276); multOrDiv(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(286);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(284);
					switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
					case 1:
						{
						_localctx = new PlusOrMinusContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_plusOrMinus);
						setState(278);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(279); match(T__2);
						setState(280); multOrDiv(0);
						}
						break;
					case 2:
						{
						_localctx = new PlusOrMinusContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_plusOrMinus);
						setState(281);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(282); match(T__0);
						setState(283); multOrDiv(0);
						}
						break;
					}
					} 
				}
				setState(288);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
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
		int _startState = 44;
		enterRecursionRule(_localctx, 44, RULE_multOrDiv, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(290); pow();
			}
			_ctx.stop = _input.LT(-1);
			setState(300);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(298);
					switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
					case 1:
						{
						_localctx = new MultOrDivContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_multOrDiv);
						setState(292);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(293); match(T__16);
						setState(294); pow();
						}
						break;
					case 2:
						{
						_localctx = new MultOrDivContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_multOrDiv);
						setState(295);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(296); match(T__35);
						setState(297); pow();
						}
						break;
					}
					} 
				}
				setState(302);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
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
		enterRule(_localctx, 46, RULE_pow);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(303); unaryMinus();
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
		enterRule(_localctx, 48, RULE_unaryMinus);
		try {
			setState(308);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(305); match(T__0);
				setState(306); unaryMinus();
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
				setState(307); atom();
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
		enterRule(_localctx, 50, RULE_atom);
		try {
			setState(317);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(310); match(T__17);
				setState(311); plusOrMinus(0);
				setState(312); match(T__3);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(314); literal();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(315); location();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(316); methodCall();
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
		enterRule(_localctx, 52, RULE_rel_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(319);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__20) | (1L << T__11) | (1L << T__8) | (1L << T__6))) != 0)) ) {
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
		enterRule(_localctx, 54, RULE_eq_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(321);
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
		enterRule(_localctx, 56, RULE_cond_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(323);
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
		enterRule(_localctx, 58, RULE_literal);
		try {
			setState(328);
			switch (_input.LA(1)) {
			case NUM:
				enterOuterAlt(_localctx, 1);
				{
				setState(325); int_literal();
				}
				break;
			case CHAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(326); char_literal();
				}
				break;
			case T__33:
			case T__14:
				enterOuterAlt(_localctx, 3);
				{
				setState(327); bool_literal();
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
		enterRule(_localctx, 60, RULE_int_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(330); match(NUM);
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
		enterRule(_localctx, 62, RULE_char_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(332); match(CHAR);
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
		enterRule(_localctx, 64, RULE_bool_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(334);
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
		case 16: return condOp_sempred((CondOpContext)_localctx, predIndex);
		case 17: return assignOp_sempred((AssignOpContext)_localctx, predIndex);
		case 21: return plusOrMinus_sempred((PlusOrMinusContext)_localctx, predIndex);
		case 22: return multOrDiv_sempred((MultOrDivContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean multOrDiv_sempred(MultOrDivContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4: return precpred(_ctx, 3);
		case 5: return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean assignOp_sempred(AssignOpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1: return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean plusOrMinus_sempred(PlusOrMinusContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2: return precpred(_ctx, 3);
		case 3: return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean condOp_sempred(CondOpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3,\u0153\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\3\2\3\2\3\2\3\2\7\2I\n\2\f\2\16\2L\13\2\3\2\3\2\3\3\3\3\3"+
		"\3\5\3S\n\3\3\4\3\4\3\4\3\4\3\4\3\4\5\4[\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\5\5h\n\5\3\6\3\6\3\6\3\6\7\6n\n\6\f\6\16\6q\13\6\3"+
		"\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\7\7{\n\7\f\7\16\7~\13\7\5\7\u0080\n\7\3"+
		"\7\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u008f\n\t\3\n\3"+
		"\n\3\13\3\13\3\13\7\13\u0096\n\13\f\13\16\13\u0099\13\13\3\13\3\13\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00a4\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\5\f\u00ae\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\5\f\u00bf\n\f\3\f\3\f\5\f\u00c3\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00d5\n\r\3\16\3\16\3\17\3\17\3"+
		"\17\3\17\3\17\7\17\u00de\n\17\f\17\16\17\u00e1\13\17\5\17\u00e3\n\17\3"+
		"\17\3\17\3\20\3\20\3\21\3\21\5\21\u00eb\n\21\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\7\22\u00f4\n\22\f\22\16\22\u00f7\13\22\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\7\23\u0100\n\23\f\23\16\23\u0103\13\23\3\24\3\24\3\25"+
		"\3\25\3\25\5\25\u010a\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26"+
		"\u0114\n\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\7\27\u011f\n"+
		"\27\f\27\16\27\u0122\13\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\7\30\u012d\n\30\f\30\16\30\u0130\13\30\3\31\3\31\3\32\3\32\3\32\5\32"+
		"\u0137\n\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u0140\n\33\3\34\3"+
		"\34\3\35\3\35\3\36\3\36\3\37\3\37\3\37\5\37\u014b\n\37\3 \3 \3!\3!\3\""+
		"\3\"\3\"\2\6\"$,.#\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60"+
		"\62\64\668:<>@B\2\b\6\2\4\4\13\13\23\23\32\32\5\2\4\4\23\23\32\32\6\2"+
		"\22\22\33\33\36\36  \4\2\7\7\35\35\4\2\t\t\16\16\4\2\5\5\30\30\u015f\2"+
		"D\3\2\2\2\4R\3\2\2\2\6Z\3\2\2\2\bg\3\2\2\2\ni\3\2\2\2\ft\3\2\2\2\16\u0084"+
		"\3\2\2\2\20\u008e\3\2\2\2\22\u0090\3\2\2\2\24\u0092\3\2\2\2\26\u00c2\3"+
		"\2\2\2\30\u00d4\3\2\2\2\32\u00d6\3\2\2\2\34\u00d8\3\2\2\2\36\u00e6\3\2"+
		"\2\2 \u00ea\3\2\2\2\"\u00ec\3\2\2\2$\u00f8\3\2\2\2&\u0104\3\2\2\2(\u0109"+
		"\3\2\2\2*\u0113\3\2\2\2,\u0115\3\2\2\2.\u0123\3\2\2\2\60\u0131\3\2\2\2"+
		"\62\u0136\3\2\2\2\64\u013f\3\2\2\2\66\u0141\3\2\2\28\u0143\3\2\2\2:\u0145"+
		"\3\2\2\2<\u014a\3\2\2\2>\u014c\3\2\2\2@\u014e\3\2\2\2B\u0150\3\2\2\2D"+
		"E\7\b\2\2EF\7\'\2\2FJ\7\r\2\2GI\5\4\3\2HG\3\2\2\2IL\3\2\2\2JH\3\2\2\2"+
		"JK\3\2\2\2KM\3\2\2\2LJ\3\2\2\2MN\7\20\2\2N\3\3\2\2\2OS\5\n\6\2PS\5\b\5"+
		"\2QS\5\f\7\2RO\3\2\2\2RP\3\2\2\2RQ\3\2\2\2S\5\3\2\2\2T[\7\23\2\2U[\7\4"+
		"\2\2V[\7\32\2\2WX\7%\2\2X[\7\'\2\2Y[\5\n\6\2ZT\3\2\2\2ZU\3\2\2\2ZV\3\2"+
		"\2\2ZW\3\2\2\2ZY\3\2\2\2[\7\3\2\2\2\\]\5\6\4\2]^\7\'\2\2^_\7\f\2\2_h\3"+
		"\2\2\2`a\5\6\4\2ab\7\'\2\2bc\7\34\2\2cd\7(\2\2de\7\37\2\2ef\7\f\2\2fh"+
		"\3\2\2\2g\\\3\2\2\2g`\3\2\2\2h\t\3\2\2\2ij\7%\2\2jk\7\'\2\2ko\7\r\2\2"+
		"ln\5\b\5\2ml\3\2\2\2nq\3\2\2\2om\3\2\2\2op\3\2\2\2pr\3\2\2\2qo\3\2\2\2"+
		"rs\7\20\2\2s\13\3\2\2\2tu\5\16\b\2uv\7\'\2\2v\177\7\25\2\2w|\5\20\t\2"+
		"xy\7\27\2\2y{\5\20\t\2zx\3\2\2\2{~\3\2\2\2|z\3\2\2\2|}\3\2\2\2}\u0080"+
		"\3\2\2\2~|\3\2\2\2\177w\3\2\2\2\177\u0080\3\2\2\2\u0080\u0081\3\2\2\2"+
		"\u0081\u0082\7#\2\2\u0082\u0083\5\24\13\2\u0083\r\3\2\2\2\u0084\u0085"+
		"\t\2\2\2\u0085\17\3\2\2\2\u0086\u0087\5\22\n\2\u0087\u0088\7\'\2\2\u0088"+
		"\u008f\3\2\2\2\u0089\u008a\5\22\n\2\u008a\u008b\7\'\2\2\u008b\u008c\7"+
		"\34\2\2\u008c\u008d\7\37\2\2\u008d\u008f\3\2\2\2\u008e\u0086\3\2\2\2\u008e"+
		"\u0089\3\2\2\2\u008f\21\3\2\2\2\u0090\u0091\t\3\2\2\u0091\23\3\2\2\2\u0092"+
		"\u0097\7\r\2\2\u0093\u0096\5\b\5\2\u0094\u0096\5\26\f\2\u0095\u0093\3"+
		"\2\2\2\u0095\u0094\3\2\2\2\u0096\u0099\3\2\2\2\u0097\u0095\3\2\2\2\u0097"+
		"\u0098\3\2\2\2\u0098\u009a\3\2\2\2\u0099\u0097\3\2\2\2\u009a\u009b\7\20"+
		"\2\2\u009b\25\3\2\2\2\u009c\u009d\7\21\2\2\u009d\u009e\7\25\2\2\u009e"+
		"\u009f\5\32\16\2\u009f\u00a0\7#\2\2\u00a0\u00a3\5\24\13\2\u00a1\u00a2"+
		"\7\"\2\2\u00a2\u00a4\5\24\13\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2"+
		"\u00a4\u00c3\3\2\2\2\u00a5\u00a6\7\n\2\2\u00a6\u00a7\7\25\2\2\u00a7\u00a8"+
		"\5\32\16\2\u00a8\u00a9\7#\2\2\u00a9\u00aa\5\24\13\2\u00aa\u00c3\3\2\2"+
		"\2\u00ab\u00ad\7\6\2\2\u00ac\u00ae\5\32\16\2\u00ad\u00ac\3\2\2\2\u00ad"+
		"\u00ae\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00c3\7\f\2\2\u00b0\u00c3\5\24"+
		"\13\2\u00b1\u00b2\5\30\r\2\u00b2\u00b3\7\17\2\2\u00b3\u00b4\5\32\16\2"+
		"\u00b4\u00b5\7\f\2\2\u00b5\u00c3\3\2\2\2\u00b6\u00b7\5\32\16\2\u00b7\u00b8"+
		"\7\f\2\2\u00b8\u00c3\3\2\2\2\u00b9\u00ba\7\24\2\2\u00ba\u00bb\7\25\2\2"+
		"\u00bb\u00be\7)\2\2\u00bc\u00bd\7\27\2\2\u00bd\u00bf\5\32\16\2\u00be\u00bc"+
		"\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c1\7#\2\2\u00c1"+
		"\u00c3\7\f\2\2\u00c2\u009c\3\2\2\2\u00c2\u00a5\3\2\2\2\u00c2\u00ab\3\2"+
		"\2\2\u00c2\u00b0\3\2\2\2\u00c2\u00b1\3\2\2\2\u00c2\u00b6\3\2\2\2\u00c2"+
		"\u00b9\3\2\2\2\u00c3\27\3\2\2\2\u00c4\u00d5\7\'\2\2\u00c5\u00c6\7\'\2"+
		"\2\u00c6\u00c7\7\31\2\2\u00c7\u00d5\5\30\r\2\u00c8\u00c9\7\'\2\2\u00c9"+
		"\u00ca\7\34\2\2\u00ca\u00cb\5\32\16\2\u00cb\u00cc\7\37\2\2\u00cc\u00d5"+
		"\3\2\2\2\u00cd\u00ce\7\'\2\2\u00ce\u00cf\7\34\2\2\u00cf\u00d0\5\32\16"+
		"\2\u00d0\u00d1\7\37\2\2\u00d1\u00d2\7\31\2\2\u00d2\u00d3\5\30\r\2\u00d3"+
		"\u00d5\3\2\2\2\u00d4\u00c4\3\2\2\2\u00d4\u00c5\3\2\2\2\u00d4\u00c8\3\2"+
		"\2\2\u00d4\u00cd\3\2\2\2\u00d5\31\3\2\2\2\u00d6\u00d7\5\"\22\2\u00d7\33"+
		"\3\2\2\2\u00d8\u00d9\7\'\2\2\u00d9\u00e2\7\25\2\2\u00da\u00df\5\36\20"+
		"\2\u00db\u00dc\7\27\2\2\u00dc\u00de\5\36\20\2\u00dd\u00db\3\2\2\2\u00de"+
		"\u00e1\3\2\2\2\u00df\u00dd\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e3\3\2"+
		"\2\2\u00e1\u00df\3\2\2\2\u00e2\u00da\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3"+
		"\u00e4\3\2\2\2\u00e4\u00e5\7#\2\2\u00e5\35\3\2\2\2\u00e6\u00e7\5\32\16"+
		"\2\u00e7\37\3\2\2\2\u00e8\u00eb\5\66\34\2\u00e9\u00eb\58\35\2\u00ea\u00e8"+
		"\3\2\2\2\u00ea\u00e9\3\2\2\2\u00eb!\3\2\2\2\u00ec\u00ed\b\22\1\2\u00ed"+
		"\u00ee\5$\23\2\u00ee\u00f5\3\2\2\2\u00ef\u00f0\f\4\2\2\u00f0\u00f1\5:"+
		"\36\2\u00f1\u00f2\5$\23\2\u00f2\u00f4\3\2\2\2\u00f3\u00ef\3\2\2\2\u00f4"+
		"\u00f7\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6#\3\2\2\2"+
		"\u00f7\u00f5\3\2\2\2\u00f8\u00f9\b\23\1\2\u00f9\u00fa\5&\24\2\u00fa\u0101"+
		"\3\2\2\2\u00fb\u00fc\f\4\2\2\u00fc\u00fd\5 \21\2\u00fd\u00fe\5&\24\2\u00fe"+
		"\u0100\3\2\2\2\u00ff\u00fb\3\2\2\2\u0100\u0103\3\2\2\2\u0101\u00ff\3\2"+
		"\2\2\u0101\u0102\3\2\2\2\u0102%\3\2\2\2\u0103\u0101\3\2\2\2\u0104\u0105"+
		"\5(\25\2\u0105\'\3\2\2\2\u0106\u0107\7!\2\2\u0107\u010a\5(\25\2\u0108"+
		"\u010a\5*\26\2\u0109\u0106\3\2\2\2\u0109\u0108\3\2\2\2\u010a)\3\2\2\2"+
		"\u010b\u010c\7\25\2\2\u010c\u010d\5\"\22\2\u010d\u010e\7#\2\2\u010e\u0114"+
		"\3\2\2\2\u010f\u0114\5<\37\2\u0110\u0114\5\30\r\2\u0111\u0114\5\34\17"+
		"\2\u0112\u0114\5,\27\2\u0113\u010b\3\2\2\2\u0113\u010f\3\2\2\2\u0113\u0110"+
		"\3\2\2\2\u0113\u0111\3\2\2\2\u0113\u0112\3\2\2\2\u0114+\3\2\2\2\u0115"+
		"\u0116\b\27\1\2\u0116\u0117\5.\30\2\u0117\u0120\3\2\2\2\u0118\u0119\f"+
		"\5\2\2\u0119\u011a\7$\2\2\u011a\u011f\5.\30\2\u011b\u011c\f\4\2\2\u011c"+
		"\u011d\7&\2\2\u011d\u011f\5.\30\2\u011e\u0118\3\2\2\2\u011e\u011b\3\2"+
		"\2\2\u011f\u0122\3\2\2\2\u0120\u011e\3\2\2\2\u0120\u0121\3\2\2\2\u0121"+
		"-\3\2\2\2\u0122\u0120\3\2\2\2\u0123\u0124\b\30\1\2\u0124\u0125\5\60\31"+
		"\2\u0125\u012e\3\2\2\2\u0126\u0127\f\5\2\2\u0127\u0128\7\26\2\2\u0128"+
		"\u012d\5\60\31\2\u0129\u012a\f\4\2\2\u012a\u012b\7\3\2\2\u012b\u012d\5"+
		"\60\31\2\u012c\u0126\3\2\2\2\u012c\u0129\3\2\2\2\u012d\u0130\3\2\2\2\u012e"+
		"\u012c\3\2\2\2\u012e\u012f\3\2\2\2\u012f/\3\2\2\2\u0130\u012e\3\2\2\2"+
		"\u0131\u0132\5\62\32\2\u0132\61\3\2\2\2\u0133\u0134\7&\2\2\u0134\u0137"+
		"\5\62\32\2\u0135\u0137\5\64\33\2\u0136\u0133\3\2\2\2\u0136\u0135\3\2\2"+
		"\2\u0137\63\3\2\2\2\u0138\u0139\7\25\2\2\u0139\u013a\5,\27\2\u013a\u013b"+
		"\7#\2\2\u013b\u0140\3\2\2\2\u013c\u0140\5<\37\2\u013d\u0140\5\30\r\2\u013e"+
		"\u0140\5\34\17\2\u013f\u0138\3\2\2\2\u013f\u013c\3\2\2\2\u013f\u013d\3"+
		"\2\2\2\u013f\u013e\3\2\2\2\u0140\65\3\2\2\2\u0141\u0142\t\4\2\2\u0142"+
		"\67\3\2\2\2\u0143\u0144\t\5\2\2\u01449\3\2\2\2\u0145\u0146\t\6\2\2\u0146"+
		";\3\2\2\2\u0147\u014b\5> \2\u0148\u014b\5@!\2\u0149\u014b\5B\"\2\u014a"+
		"\u0147\3\2\2\2\u014a\u0148\3\2\2\2\u014a\u0149\3\2\2\2\u014b=\3\2\2\2"+
		"\u014c\u014d\7(\2\2\u014d?\3\2\2\2\u014e\u014f\7*\2\2\u014fA\3\2\2\2\u0150"+
		"\u0151\t\7\2\2\u0151C\3\2\2\2\37JRZgo|\177\u008e\u0095\u0097\u00a3\u00ad"+
		"\u00be\u00c2\u00d4\u00df\u00e2\u00ea\u00f5\u0101\u0109\u0113\u011e\u0120"+
		"\u012c\u012e\u0136\u013f\u014a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
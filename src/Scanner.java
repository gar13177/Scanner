
import org.antlr.runtime.ANTLRStringStream;
import grammar.ANTLR.decafLexer;
import grammar.ANTLR.decafParser;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.gui.TreeViewer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Kevin
 */
public class Scanner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //lectura del archivo
        String str;
        ScannerC scanner;
        try{
            scanner = new ScannerC("src/prueba");
            str = scanner.getString();
            System.out.println(str);
        }catch (IOException e){
            System.out.println("error de lectura");
            str = "";
        }
        
        //archivo leido
        ANTLRInputStream in = new ANTLRInputStream(str);
        decafLexer lexer = new decafLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        decafParser parser = new decafParser(tokens);
        
        
        
        ParseTree tree = parser.program();
        
        ParserRuleContext trr = (ParserRuleContext) tree;
        Visitor visitor = new Visitor();
        String result = visitor.visit(trr);
        System.out.println(result);
        
        List<String> lst = Arrays.asList(parser.getRuleNames());
        TreeViewer tr = new TreeViewer(lst,tree);
        
        //mainView mv = new mainView();
        //mv.setVisible(true);
        //show AST in GUI
        JFrame frame = new JFrame("Antlr AST");
        JPanel panel = new JPanel();
        tr.setScale(1.5);//scale a little
        panel.add(tr);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }
    
}

import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.antlr.runtime.MismatchedTokenException;
import org.antlr.v4.gui.SystemFontMetrics;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.tree.ParseTreeWalker;


public class Test {
    public static void main(String[] args) throws Exception{
        //prepare token stream
        CharStream stream = new ANTLRInputStream(basic.test_string);

        try
        {
            miniJavaLexer lexer  = new miniJavaLexer(stream);
            TokenStream tokenStream = new CommonTokenStream(lexer);
            miniJavaParser parser = new miniJavaParser(tokenStream);
            parser.removeErrorListeners();
            //parser.addErrorListener(new test_listener.VerboseListener());
            parser.addErrorListener(new test_listener2.UnderlineListener());
            ParseTree tree = parser.goal();

            ParseTreeWalker walker = new ParseTreeWalker();
            PhaseDefine def = new PhaseDefine();
            walker.walk(def, tree);
            // create next phase and feed symbol table info from def to ref phase
            PhaseCheck ref = new PhaseCheck(def.globals, def.scopes);
            walker.walk(ref, tree);

            JFrame frame = new JFrame("Abstract Syntax Tree GUI(By Qingfu Wan)");
            JPanel panel = new JPanel();
            TreeViewer viewr = new TreeViewer(Arrays.asList(
                    parser.getRuleNames()),tree);
            viewr.setScale(1.0);//scale a little
            panel.add(viewr);

            frame.add(panel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1366,768);
            frame.setVisible(true);

        }
        catch (RecognitionException ex)
        {
            System.out.print("fsd");
        }




    }
}
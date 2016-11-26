import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class wqfminiJavaCompilerFrontEnd
{
    public static void main(String[] args) throws Exception
    {
        basic.ReadTestString();
        CharStream stream = new ANTLRInputStream(basic.test_string);
        miniJavaLexer lexer  = new miniJavaLexer(stream);
        TokenStream tokenStream = new CommonTokenStream(lexer);
        miniJavaParser parser = new miniJavaParser(tokenStream);
        parser.removeErrorListeners();                                    //my listener has underline while the default hasn't
        parser.addErrorListener(new wqfListener.UnderlineListener());
        if (basic.bail()) parser.setErrorHandler(new ErrorStrategy());   //bail out of the parser upon the first syntax error

        ParseTree tree = parser.goal();
        ParseTreeWalker walker = new ParseTreeWalker();
        PhaseCheck phase_check = new PhaseCheck();
        walker.walk(phase_check, tree);    //Error Reporting and Recovering

        JFrame frame = new JFrame("Abstract Syntax Tree GUI(By Qingfu Wan)");
        JPanel panel = new JPanel();
        TreeViewer viewer = new TreeViewer(Arrays.asList(parser.getRuleNames()),tree);
        viewer.setScale(1.0);//scale a little
        panel.add(viewer);

        //Visualizing the Abstract Syntax Tree
        frame.add(panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1366,768);
    }
}
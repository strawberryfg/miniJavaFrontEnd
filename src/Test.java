import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.tree.ParseTreeWalker;


public class Test {
    public static void main(String[] args) {
        //prepare token stream
        CharStream stream = new ANTLRInputStream("public class Test {\n" +
                "   public static void main(String[] args) {\n" +
                "      int a = 4;\n" +
                "   }\n" +
                "}");
        miniJavaLexer lexer  = new miniJavaLexer(stream);
        TokenStream tokenStream = new CommonTokenStream(lexer);
        miniJavaParser parser = new miniJavaParser(tokenStream);
        ParseTree tree = parser.goal();

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
}
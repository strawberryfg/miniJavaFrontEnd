import org.antlr.v4.runtime.*;

public class wqfListener
{
    public static class UnderlineListener extends BaseErrorListener
    {
        public void syntaxError(Recognizer<?, ?> recognizer,
                                Object offendingSymbol,
                                int line, int charPositionInLine,
                                String msg,
                                RecognitionException e)
        {
            System.err.println("Syntax Error:");
            System.err.println("line "+line+":"+charPositionInLine+" "+msg);
            basic.underlineError(recognizer,(Token)offendingSymbol,
                    line, charPositionInLine);
        }
    }
    public void main(String[] args) throws Exception
    {
        ANTLRInputStream input = new ANTLRInputStream(System.in);
        miniJavaLexer lexer = new miniJavaLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        miniJavaParser parser = new miniJavaParser(tokens);
        parser.removeErrorListeners(); // remove ConsoleErrorListener
        parser.addErrorListener(new UnderlineListener());
        parser.goal();
    }
}
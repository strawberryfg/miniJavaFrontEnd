import org.antlr.v4.runtime.*;

public class ErrorStrategy extends DefaultErrorStrategy
{
    @Override
    public void recover(Parser recognizer, RecognitionException e)
    {
        throw new RuntimeException(e);
    }

    @Override
    public void sync(Parser recognizer) { }

    @Override
    public void reportNoViableAlternative(Parser parser,
                                          NoViableAltException e)
            throws RecognitionException
    {
        String msg = "Syntax Error: \n Cannot choose between alternatives";
        parser.notifyErrorListeners(e.getOffendingToken(), msg, e);
    }

    @Override
    protected void reportInputMismatch(Parser recognizer,
                                       InputMismatchException e)
            throws RecognitionException
    {
        String msg = "Input Mismatch :";
        recognizer.notifyErrorListeners(e.getOffendingToken(), msg, e);
    }
}

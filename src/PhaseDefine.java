import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.*;
import java.util.*;
public class PhaseDefine extends miniJavaBaseListener{
    ParseTreeProperty<Scope> scopes = new ParseTreeProperty<Scope>();   // variable table

}
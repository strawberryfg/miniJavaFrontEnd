import java.util.Map;
import java.util.LinkedHashMap;

public abstract class BaseScope implements Scope {
    Scope enclosingScope;
    Map<String, Symbol> symbols = new LinkedHashMap<String, Symbol>();

    public BaseScope(Scope enclosingScope)
    {
        this.enclosingScope = enclosingScope;
    }

    public Symbol resolve(String name)
    {
        Symbol s = symbols.get(name);
        if ( s!=null ) return s;
        if ( enclosingScope != null )
            return enclosingScope.resolve(name);
        return null;
    }

    public void define(Symbol sym)
    {
        symbols.put(sym.name, sym);
        sym.scope = this;
    }
    public Scope getEnclosingScope()
    {
        return enclosingScope;
    }

    public String toString()
    {
        return getScopeName()+":"+symbols.values().toString();
    }
}

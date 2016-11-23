public class Symbol
{

    String name;
    Type type;
    Scope scope;
    String typeName;

    public Symbol(String name)
    {
        this.name = name;
    }
    public Symbol(String name, Type type)
    {
        this(name); this.type = type;
    }
    public String getName()
    {
        return name;
    }

    public String toString()
    {
        if ( type!=Type.jVoid )
            return '<'+getName()+":"+type+'>';
        return getName();
    }

    public Type getType()
    {
        return type;
    }
    public void setType(Type _type)
    {
        type = _type;
    }
}

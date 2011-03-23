package com.thoughtworks.qdox.model;

import java.util.List;

public class DefaultJavaFieldTest
    extends JavaFieldTest<DefaultJavaField>
{

    public DefaultJavaFieldTest( String s )
    {
        super( s );
    }

    @Override
    public DefaultJavaField newJavaField()
    {
        JavaSource source = new DefaultJavaSource( null );
        JavaClass javaClass = new DefaultJavaClass( source );
        DefaultJavaField result = new DefaultJavaField();
        result.setParentClass( javaClass );
        return result;
    }

    @Override
    public DefaultJavaField newJavaField( Type type, String name )
    {
        return new DefaultJavaField(type, name);
    }

    @Override
    public Type newType( String fullname )
    {
        return new Type( fullname );
    }

    @Override
    public Type newType( String fullname, int dimensions )
    {
        return new Type( fullname, dimensions );
    }

    @Override
    public void setComment( DefaultJavaField fld, String comment )
    {
        fld.setComment( comment );
    }

    @Override
    public void setInitializationExpression( DefaultJavaField fld, String expression )
    {
        fld.setInitializationExpression( expression );
    }

    @Override
    public void setModifiers( DefaultJavaField fld, List<String> modifiers )
    {
        fld.setModifiers( modifiers );
    }

    @Override
    public void setName( DefaultJavaField fld, String name )
    {
        fld.setName( name );
    }

    @Override
    public void setType( DefaultJavaField fld, Type type )
    {
        fld.setType( type );
    }

    @Override
    public void setDeclaringClass( DefaultJavaField fld, JavaClass cls )
    {
        fld.setParentClass( cls );
    }

}
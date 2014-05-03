package interp;

import interp.Types.*;

import org.antlr.runtime.tree.*;
import org.antlr.runtime.Token;

public class StageTree extends CommonTree {
    private TypeInterface value = null;
    private Types type = null;

    public StageTree(Token t) {
        super(t);
    }

    public StageTree getChild(int i) {
        return (StageTree) super.getChild(i);
    }

    public TypeInterface getValue() { return value; }

    public Types getVarType() { return type; }
    public void setVarType(Types t) { type = t; }

    public void setIntValue() {
        type = Types.INT_T;
        value = new IntType(Integer.parseInt(getText()));
    }

    public void setFloatValue() {
        type = Types.FLOAT_T;
        value = new FloatType(Float.parseFloat(getText()));
    }

    public void setBooleanValue() {
        type = Types.BOOL_T;
        value = new BoolType(getText().equals("true"));
    }

    public void setStringValue() {
        type = Types.STRING_T;
        //TODO add type as string.
    }

    public void setCharValue() {
        type = Types.CHAR_T;
        //TODO add type as char.
    }
}

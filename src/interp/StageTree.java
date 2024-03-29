package interp;

import interp.Types.*;

import org.antlr.runtime.tree.*;
import org.antlr.runtime.Token;

public class StageTree extends CommonTree {
    private TypeInterface value = null;
    private Types type = null;
    private int FuncId = -1;

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
        value = new Type_Int(Integer.parseInt(getText()));
    }

    public void setFloatValue() {
        type = Types.FLOAT_T;
        value = new Type_Float(Float.parseFloat(getText()));
    }

    public void setBooleanValue() {
        type = Types.BOOL_T;
        value = new Type_Bool(getText().equals("true"));
    }

    public void setStringValue() {
        type = Types.STRING_T;
        String s = getText();
        value = new Type_String(s.substring(1,s.length()-1));
    }

    public void setCharValue() {
        type = Types.CHAR_T;
        value = new Type_Char(getText().charAt(1));
    }

    public void setFuncId(int i) {
        FuncId = i;
    }
    public int getFuncId() { return FuncId; }
}

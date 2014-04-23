package interp;

import org.antlr.runtime.tree.*;
import org.antlr.runtime.Token;

public class StageTree extends CommonTree {
    private int intValue;
    private String strValue;
    private float floatValue;

    public StageTree(Token t) {
        super(t);
    }

    public StageTree getChild(int i) {
        return (StageTree) super.getChild(i);
    }

    public int getIntValue() { return intValue; }
    public void setIntValue() { intValue = Integer.parseInt(getText()); }

    public boolean getBooleanValue() { return intValue != 0; }
    public void setBooleanValue() { intValue = getText().equals("true") ? 1 : 0; }

    public String getStringValue() { return strValue; }
    public void setStringValue() { String s = getText();
        strValue = s.substring(1,s.length()-1); }

    public float getFloatValue() { return floatValue; }
    public void setFloatValue() { floatValue = Float.parseFloat(getText()); }
}

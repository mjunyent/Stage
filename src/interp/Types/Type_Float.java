package interp.Types;

import processing.opengl.PShader;

import java.util.List;


public class Type_Float implements TypeFunctionInterface,TypeFilterInterface {
    private float value;

    static private FunctionList fl;
    static {
        fl = new FunctionList();
        fl.add("+", new Types[] {Types.FLOAT_T}, Types.FLOAT_T, 0);
        fl.add("-", new Types[] {Types.FLOAT_T}, Types.FLOAT_T, 1);
        fl.add("*", new Types[] {Types.FLOAT_T}, Types.FLOAT_T, 2);
        fl.add("/", new Types[] {Types.FLOAT_T}, Types.FLOAT_T, 3);

        fl.add("-", new Types[] {}, Types.FLOAT_T, 4);

        fl.add("==", new Types[] {Types.FLOAT_T}, Types.BOOL_T, 10);
        fl.add("!=", new Types[] {Types.FLOAT_T}, Types.BOOL_T, 11);
        fl.add(">=", new Types[] {Types.FLOAT_T}, Types.BOOL_T, 12);
        fl.add("<=", new Types[] {Types.FLOAT_T}, Types.BOOL_T, 13);
        fl.add("<", new Types[] {Types.FLOAT_T}, Types.BOOL_T, 14);
        fl.add(">", new Types[] {Types.FLOAT_T}, Types.BOOL_T, 15);

        fl.add("+", new Types[] {Types.VEC4_T}, Types.VEC4_T, 20);
        fl.add("-", new Types[] {Types.VEC4_T}, Types.VEC4_T, 21);
        fl.add("*", new Types[] {Types.VEC4_T}, Types.VEC4_T, 22);
        fl.add("/", new Types[] {Types.VEC4_T}, Types.VEC4_T, 23);

        fl.add("+", new Types[] {Types.VEC2_T}, Types.VEC2_T, 30);
        fl.add("-", new Types[] {Types.VEC2_T}, Types.VEC2_T, 31);
        fl.add("*", new Types[] {Types.VEC2_T}, Types.VEC2_T, 32);
        fl.add("/", new Types[] {Types.VEC2_T}, Types.VEC2_T, 33);
    }

    public Type_Float() { value = 0; }

    public Type_Float(float value) {
        this.value = value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getValue() {
        return value;
    }

    public Types getTypeName() { return Types.FLOAT_T; }

    public Types getMethodArgs(String name, List<Types> args) {
        if(fl.exists(name, args)) return fl.getFunction(name,args).ret;
        return null;
    }

    public TypeFunctionInterface callMethod(String name, List<TypeFunctionInterface> args) {
        if(!fl.existsByInterface(name,args)) return null;

        FunctionSignature fs = fl.getFunctionByInterface(name, args);
        switch (fs.id) {
            case 0:
                return new Type_Float( value + ((Type_Float)args.get(0)).getValue() );
            case 1:
                return new Type_Float( value - ((Type_Float)args.get(0)).getValue() );
            case 2:
                return new Type_Float( value * ((Type_Float)args.get(0)).getValue() );
            case 3:
                return new Type_Float( value / ((Type_Float)args.get(0)).getValue() );
            case 4:
                return new Type_Float( -value );

            case 10:
                return new Type_Bool( value == ((Type_Float)args.get(0)).getValue() );
            case 11:
                return new Type_Bool( value != ((Type_Float)args.get(0)).getValue() );
            case 12:
                return new Type_Bool(  value >= ((Type_Float)args.get(0)).getValue() );
            case 13:
                return new Type_Bool(  value <= ((Type_Float)args.get(0)).getValue() );
            case 14:
                return new Type_Bool(  value < ((Type_Float)args.get(0)).getValue() );
            case 15:
                return new Type_Bool(  value > ((Type_Float)args.get(0)).getValue() );

            case 20:
                return new Type_Vec4(((Type_Vec4)args.get(0)).getX()+value,
                                     ((Type_Vec4)args.get(0)).getY()+value,
                                     ((Type_Vec4)args.get(0)).getZ()+value,
                                     ((Type_Vec4)args.get(0)).getW()+value);
            case 21:
                return new Type_Vec4(((Type_Vec4)args.get(0)).getX()-value,
                                     ((Type_Vec4)args.get(0)).getY()-value,
                                     ((Type_Vec4)args.get(0)).getZ()-value,
                                     ((Type_Vec4)args.get(0)).getW()-value);
            case 22:
                return new Type_Vec4(((Type_Vec4)args.get(0)).getX()*value,
                                     ((Type_Vec4)args.get(0)).getY()*value,
                                     ((Type_Vec4)args.get(0)).getZ()*value,
                                     ((Type_Vec4)args.get(0)).getW()*value);
            case 23:
                return new Type_Vec4(((Type_Vec4)args.get(0)).getX()/value,
                                     ((Type_Vec4)args.get(0)).getY()/value,
                                     ((Type_Vec4)args.get(0)).getZ()/value,
                                     ((Type_Vec4)args.get(0)).getW()/value);



            case 30:
                return new Type_Vec2(((Type_Vec2)args.get(0)).getX()+value,
                                     ((Type_Vec2)args.get(0)).getY()+value);
            case 31:
                return new Type_Vec2(((Type_Vec2)args.get(0)).getX()-value,
                                     ((Type_Vec2)args.get(0)).getY()-value);
            case 32:
                return new Type_Vec2(((Type_Vec2)args.get(0)).getX()*value,
                                     ((Type_Vec2)args.get(0)).getY()*value);
            case 33:
                return new Type_Vec2(((Type_Vec2)args.get(0)).getX()/value,
                                     ((Type_Vec2)args.get(0)).getY()/value);
        }

        return null;
    }

    public Types getAttributeType(String name) { return null; }
    public TypeFunctionInterface getAttribute(String name) { return null; }

    public void set(TypeInterface obj) {
        value = ((Type_Float)obj).getValue();
    }

    public void passToShader(PShader shad, String name) {
        shad.set(name, value);
    }

    public String callMethod(String left, String name, List<Types> args_types, List<String> args) {
        if(args.size() == 1) {
            if(name.equals("+") || name.equals("-") || name.equals("*") || name.equals("/") || name.equals("-") || name.equals("==") || name.equals("!=") ||
                    name.equals(">") || name.equals("<") ||
                    name.equals(">=") || name.equals("<=")) {
                return "(" + left + ")" + name + "(" + args.get(0) + ")";
            }
        } else if(args.size() == 0) {
            return "-(" + left + ")";
        }
        return "";
    }

    public String getAttribute(String left, String name) {
        return left + "." + name;
    }
}
package interp.Types;

import processing.opengl.PShader;

import java.util.List;

public class Type_Vec4 implements TypeFunctionInterface,TypeFilterInterface {
    private Type_Float valX, valY, valZ, valW;

    static private FunctionList fl;
    static {
        fl = new FunctionList();
        fl.add("+", new Types[] {Types.VEC4_T}, Types.VEC4_T, 0);
        fl.add("-", new Types[] {Types.VEC4_T}, Types.VEC4_T, 1);
        fl.add("*", new Types[] {Types.VEC4_T}, Types.VEC4_T, 2);
        fl.add("/", new Types[] {Types.VEC4_T}, Types.VEC4_T, 3);

        fl.add("-", new Types[] {}, Types.VEC4_T, 4);

        fl.add("==", new Types[] {Types.VEC4_T}, Types.BOOL_T, 10);
        fl.add("!=", new Types[] {Types.VEC4_T}, Types.BOOL_T, 11);

        fl.add("+", new Types[] {Types.FLOAT_T}, Types.VEC4_T, 20);
        fl.add("-", new Types[] {Types.FLOAT_T}, Types.VEC4_T, 21);
        fl.add("*", new Types[] {Types.FLOAT_T}, Types.VEC4_T, 22);
        fl.add("/", new Types[] {Types.FLOAT_T}, Types.VEC4_T, 23);
    }

    public Type_Vec4() {
        valX = new Type_Float();
        valY = new Type_Float();
        valZ = new Type_Float();
        valW = new Type_Float();
    }

    public Type_Vec4(float x, float y, float z, float w) {
        valX = new Type_Float(x);
        valY = new Type_Float(y);
        valZ = new Type_Float(z);
        valW = new Type_Float(w);
    }

    public void setValue(float x, float y, float z, float w) {
        valX.setValue(x);
        valY.setValue(y);
        valZ.setValue(z);
        valW.setValue(w);
    }

    public float getX() { return valX.getValue(); }
    public float getY() { return valY.getValue(); }
    public float getZ() { return valZ.getValue(); }
    public float getW() { return valW.getValue(); }

    public Types getTypeName() { return Types.VEC4_T; }

    public Types getMethodArgs(String name, List<Types> args) {
        if(fl.exists(name, args)) return fl.getFunction(name,args).ret;
        return null;
    }


    public TypeFunctionInterface callMethod(String name, List<TypeFunctionInterface> args) {
        if(!fl.existsByInterface(name,args)) return null;

        FunctionSignature fs = fl.getFunctionByInterface(name, args);
        switch (fs.id) {
            case 0:
                return new Type_Vec4(
                        valX.getValue() + ((Type_Vec4)args.get(0)).getX(),
                        valY.getValue() + ((Type_Vec4)args.get(0)).getY(),
                        valZ.getValue() + ((Type_Vec4)args.get(0)).getZ(),
                        valW.getValue() + ((Type_Vec4)args.get(0)).getW()
                        );
            case 1:
                return new Type_Vec4(
                        valX.getValue() - ((Type_Vec4)args.get(0)).getX(),
                        valY.getValue() - ((Type_Vec4)args.get(0)).getY(),
                        valZ.getValue() - ((Type_Vec4)args.get(0)).getZ(),
                        valW.getValue() - ((Type_Vec4)args.get(0)).getW()
                );
            case 2:
                return new Type_Vec4(
                        valX.getValue() * ((Type_Vec4)args.get(0)).getX(),
                        valY.getValue() * ((Type_Vec4)args.get(0)).getY(),
                        valZ.getValue() * ((Type_Vec4)args.get(0)).getZ(),
                        valW.getValue() * ((Type_Vec4)args.get(0)).getW()
                );
            case 3:
                return new Type_Vec4(
                        valX.getValue() / ((Type_Vec4)args.get(0)).getX(),
                        valY.getValue() / ((Type_Vec4)args.get(0)).getY(),
                        valZ.getValue() / ((Type_Vec4)args.get(0)).getZ(),
                        valW.getValue() / ((Type_Vec4)args.get(0)).getW()
                );
            case 4:
                return new Type_Vec4( -valX.getValue(), -valY.getValue(), -valZ.getValue(), -valW.getValue() );

            case 10:
                return new Type_Bool(
                        valX.getValue() == ((Type_Vec4)args.get(0)).getX() &&
                        valY.getValue() == ((Type_Vec4)args.get(0)).getY() &&
                        valZ.getValue() == ((Type_Vec4)args.get(0)).getZ() &&
                        valW.getValue() == ((Type_Vec4)args.get(0)).getW()
                );
            case 11:
                return new Type_Bool(
                        valX.getValue() != ((Type_Vec4)args.get(0)).getX() ||
                        valY.getValue() != ((Type_Vec4)args.get(0)).getY() ||
                        valZ.getValue() != ((Type_Vec4)args.get(0)).getZ() ||
                        valW.getValue() != ((Type_Vec4)args.get(0)).getW()
                );

            case 20:
                return new Type_Vec4(
                        valX.getValue() + ((Type_Float)args.get(0)).getValue(),
                        valY.getValue() + ((Type_Float)args.get(0)).getValue(),
                        valZ.getValue() + ((Type_Float)args.get(0)).getValue(),
                        valW.getValue() + ((Type_Float)args.get(0)).getValue()
                );
            case 21:
                return new Type_Vec4(
                        valX.getValue() - ((Type_Float)args.get(0)).getValue(),
                        valY.getValue() - ((Type_Float)args.get(0)).getValue(),
                        valZ.getValue() - ((Type_Float)args.get(0)).getValue(),
                        valW.getValue() - ((Type_Float)args.get(0)).getValue()
                );
            case 22:
                return new Type_Vec4(
                        valX.getValue() * ((Type_Float)args.get(0)).getValue(),
                        valY.getValue() * ((Type_Float)args.get(0)).getValue(),
                        valZ.getValue() * ((Type_Float)args.get(0)).getValue(),
                        valW.getValue() * ((Type_Float)args.get(0)).getValue()
                );
            case 23:
                return new Type_Vec4(
                        valX.getValue() / ((Type_Float)args.get(0)).getValue(),
                        valY.getValue() / ((Type_Float)args.get(0)).getValue(),
                        valZ.getValue() / ((Type_Float)args.get(0)).getValue(),
                        valW.getValue() / ((Type_Float)args.get(0)).getValue()
                );
        }

        return null;
    }

    public Types getAttributeType(String name) {
        if(name.equals("x") || name.equals("y") || name.equals("z") || name.equals("w")) return Types.FLOAT_T;
        return null;
    }
    public TypeFunctionInterface getAttribute(String name) {
        if(name.equals("x")) return valX;
        if(name.equals("y")) return valY;
        if(name.equals("z")) return valZ;
        if(name.equals("w")) return valW;
        return null;
    }

    public void set(TypeInterface obj) {
        valX = ((Type_Vec4)obj).valX;
        valY = ((Type_Vec4)obj).valY;
        valZ = ((Type_Vec4)obj).valZ;
        valW = ((Type_Vec4)obj).valW;
    }


    public void passToShader(PShader shad, String name) {
        shad.set(name, valX.getValue(), valY.getValue(), valZ.getValue(), valW.getValue());
    }

    public String callMethod(String left, String name, List<Types> args_types, List<String> args) {
        if(args.size() == 1) {
            if(name.equals("+") || name.equals("-") || name.equals("*")  || name.equals("/") || name.equals("-") || name.equals("==") || name.equals("!=")) {
                return "(" + left + ")" + name + "(" + args.get(0) + ")";
            }
        }
        else if(args.size()==0) {
            return "-(" + left + ")";
        }
        return "";
    }

    public String getAttribute(String left, String name) {
        return left + "." + name;
    }
}

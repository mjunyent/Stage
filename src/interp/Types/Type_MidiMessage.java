package interp.Types;

import java.util.List;

public class Type_MidiMessage implements TypeFunctionInterface {
    public String bus_name;
    public Type_String type;
    public Type_Int channel;
    public Type_Int number; //aka pitch
    public Type_Float value; //aka velocity

    public Types getTypeName() { return Types.MIDI_BUS_T; }

    public Type_MidiMessage() {
        bus_name = "";
        type = new Type_String("CC");
        channel = new Type_Int(0);
        number = new Type_Int(0);
        value = new Type_Float(0.0f);
    }

    public Type_MidiMessage(String bus_name, String type, int channel, int number, float value) {
        this.bus_name = bus_name;
        this.type = new Type_String(type);
        this.channel = new Type_Int(channel);
        this.number = new Type_Int(number);
        this.value = new Type_Float(value);
    }

    public Types getMethodArgs(String name, List<Types> args) { return null; }

    public TypeFunctionInterface callMethod(String name, List<TypeFunctionInterface> args) { return null; }

    public Types getAttributeType(String name) {
        if(name.equals("channel")) return Types.INT_T;
        if(name.equals("type")) return Types.STRING_T;
        if(name.equals("number") || name.equals("pitch")) return Types.INT_T;
        if(name.equals("value") || name.equals("value")) return Types.FLOAT_T;
        return null;
    }

    public TypeFunctionInterface getAttribute(String name) {
        if(name.equals("channel")) return channel;
        if(name.equals("type")) return type;
        if(name.equals("number") || name.equals("pitch")) return number;
        if(name.equals("value") || name.equals("value")) return value;
        return null;
    }

    public void set(TypeInterface obj) {
        bus_name = ((Type_MidiMessage)obj).bus_name;
        channel = ((Type_MidiMessage)obj).channel;
        number = ((Type_MidiMessage)obj).number;
        value = ((Type_MidiMessage)obj).value;
    }
}

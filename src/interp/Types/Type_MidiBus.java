package interp.Types;

import interp.Semantic.FunctionGlobalFuncs;
import interp.Semantic.FunctionGlobalVars;
import themidibus.*;

import java.util.List;

public class Type_MidiBus implements TypeFunctionInterface {
    static private FunctionList fl;
    static {
        fl = new FunctionList();
        fl.add("messages", new Types[] {}, Types.A_MIDI_MSG_T, 0);
        fl.add("send", new Types[] {Types.MIDI_MSG_T}, Types.VOID_T, 1);
    }
    public MidiBus midibus;
    public String name;

    public Types getTypeName() { return Types.MIDI_BUS_T; }

    public Type_MidiBus() {
        midibus = null;
        name = null;
    }

    public Type_MidiBus(String name, String input, String output) {
        if(input == null && output == null)
            midibus = new MidiBus(FunctionGlobalVars.screen, -1, -1, name);
        else if(input == null)
            midibus = new MidiBus(FunctionGlobalVars.screen, -1, output, name);
        else if(output == null)
            midibus = new MidiBus(FunctionGlobalVars.screen, input, -1, name);
        else
            midibus = new MidiBus(FunctionGlobalVars.screen, input, output, name);

        this.name = name;
    }

    public Types getMethodArgs(String name, List<Types> args) {
        if(fl.exists(name, args)) return fl.getFunction(name,args).ret;
        return null;
    }

    public TypeFunctionInterface callMethod(String name, List<TypeFunctionInterface> args) {
        if(!fl.existsByInterface(name,args)) return null;

        FunctionSignature fs = fl.getFunctionByInterface(name, args);
        switch (fs.id) {
            case 0:
                Type_Array ray = new Type_Array();
                ray.setType(Types.A_MIDI_MSG_T);

                try {
                    for(Type_MidiMessage mm : FunctionGlobalVars.queued_messages) {
                        if(mm.bus_name.equals(this.name)) ray.array.add(mm);
                    }
                }
                catch (Exception e) { }
                return ray;
            case 1:
                Type_MidiMessage mm = (Type_MidiMessage)args.get(0);
                if(mm.type.getValue().equals("CC")) {
                    midibus.sendControllerChange(mm.channel.getValue(), mm.number.getValue(), (int)mm.value.getValue()*127);
                } else if(mm.type.getValue().equals("ON")) {
                    midibus.sendNoteOn(mm.channel.getValue(), mm.number.getValue(), (int)mm.value.getValue()*127);
                } else if(mm.type.getValue().equals("OFF")) {
                    midibus.sendNoteOff(mm.channel.getValue(), mm.number.getValue(), (int) mm.value.getValue() * 127);
                }
                return new Type_Void();
            default:
                return null;
        }
    }

    public Types getAttributeType(String name) {
        if(name.equals("name")) return Types.STRING_T;
        return null;
    }

    public TypeFunctionInterface getAttribute(String name) {
        if(name.equals("name")) return new Type_String(this.name);
        return null;
    }

    public void set(TypeInterface obj) {
        midibus = ((Type_MidiBus)obj).midibus;
        name = ((Type_MidiBus)obj).name;
    }
}

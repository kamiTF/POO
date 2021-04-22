package casainteligente.casainteligente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CasaInteligente {
    private String morada;
    private Map<String, SmartDevice> devices;
    private Map<String, List<SmartDevice>> salas;


    public CasaInteligente(){
        this.morada = "";
        this.devices = new HashMap<>();
        this.salas = new HashMap<>();
    }
    public CasaInteligente(String novamorada){
        this.morada = novamorada;
        this.devices = new HashMap<>();
        this.salas = new HashMap<>();
    }

    public boolean existsDevice(String devID){
        return this.devices.containsKey(devID);
    }
    public void addDevice(SmartDevice d){
        if(d instanceof SmartBulb){
            SmartBulb sb = (SmartBulb) d;
            this.devices.put(sb.getId(),sb.clone());
        }
        else if(d instanceof SmartSpeaker){
            SmartSpeaker sb = (SmartSpeaker) d;
            this.devices.put(sb.getId(),sb.clone());
        }
    }
    public SmartDevice getDevice(String id){
        if(this.devices.get(id) != null) return this.devices.get(id).clone();
        else return null;
    }
    public void setAllOn(boolean state){
        for(SmartDevice dev : devices.values()){
            dev.setOn(state);
        }
    }
    public void addRoom(String divisao){
        if(this.salas.containsKey(divisao)==false){
            this.salas.put(divisao, new ArrayList<>());
        }
    }
    public boolean hasRoom(String divisao){
        return  this.salas.containsKey(divisao);
    }
    public void addToRoom(String divisao, String device){
        if(this.salas.containsKey(divisao)==true){
            if(this.devices.containsKey(device)==true){
                List<SmartDevice> listdev = this.salas.get(divisao);
                listdev.add(this.devices.get(device).clone());
                this.salas.put(divisao,listdev);
            }
        }
    }
    public boolean roomHasDevice(String divisao, String devID){
        if(this.salas.containsKey(divisao)==false) return false;

        for(SmartDevice sd: salas.get(divisao)){
            if(sd.getId().equals(devID))return true;
        }
        return false;
    }










}

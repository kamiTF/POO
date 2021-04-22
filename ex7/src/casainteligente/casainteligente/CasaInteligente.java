package casainteligente.casainteligente;

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
        return this.devices.containsKey();
    }
    public void addDevice(SmartDevice d){
        if(d instanceof SmartBulb){
            SmartBulb sb = (SmartBulb) d;
            this.devices.put(sb.getId(),sb.clone());
        }
    }
    public SmartDevice getDevice(String id){
        if(this.devices.get(id) != null) return this.devices.get(id).clone();
        else return null;
    }
    public void setAllOn










}

package casainteligente.casainteligente;

public class SmartDevice {
    private String id;
    private boolean on;



    public SmartDevice(){
        this.id = "";
        this.on = false;
    }
    public SmartDevice(String nID){
        this.id = nID;
        this.on = false;
    }
    public SmartDevice(String nID, Boolean state){
        this.id = nID;
        this.on = state;
    }
    public String getId(){
        return id;
    }
    public Boolean getOn(){
        return on;
    }
    public void setOn(Boolean state){
        this.on = state;
    }
    public void setId(String nId){
        this.id = nId;
    }

}

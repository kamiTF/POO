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
    public SmartDevice(String nID, boolean state){
        this.id = nID;
        this.on = state;
    }
    public SmartDevice (SmartDevice s){
        this.id = s.getId();
        this.on = s.getOn();
    }
    public boolean equals (Object o){
        if(this == o ) return true;
        if((o == null) | (this.getClass() != o.getClass())) return false;

        SmartDevice sd = (SmartDevice) o;
        return sd.on == this.on & this.id.equals(sd.id);

    }

    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("Id : ")
                .append(this.getId())
                .append("\nOn: ")
                .append(this.getOn());
        return sb.toString();

    }

    public SmartDevice clone(){
        return new SmartDevice(this);
    }


    public String getId(){
        return id;
    }
    public boolean getOn(){
        return on;
    }
    public void setOn(boolean state){
        this.on = state;
    }
    public void setId(String nId){
        this.id = nId;
    }

}

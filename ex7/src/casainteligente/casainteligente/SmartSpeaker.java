package casainteligente.casainteligente;

public class SmartSpeaker extends SmartDevice {

    public static final int MAX = 20;
    private String channel;
    private int volume;

    public SmartSpeaker(){
        super();
        channel = "";
        volume = 10;
    }
    public SmartSpeaker(String id){
        super(id);
        channel = "";
        volume = 50;
    }
    public SmartSpeaker(String id, String nchannel, int nvolume){
        super(id);
        channel = nchannel;
        volume = nvolume;
    }

    public int getVolume() {
        return volume;
    }
    public void setVolume(int n){
        volume = n;
    }
    public void volumeUp() {
        if (this.getVolume() < 20) {
            this.setVolume(getVolume() + 1);
        }
    }
    public void volumeDown() {
        if (this.getVolume() > 0) {
            this.setVolume(getVolume() - 1);
        }
    }
    public String getChannel(){
        return this.channel;
    }
    public void setChannel(String nchannel){
        channel = nchannel;
    }






}

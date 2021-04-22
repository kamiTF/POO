package casainteligente.casainteligente;

import java.lang.String;

public class SmartBulb extends SmartDevice{

    public static final int WARM = 10;
    public static final int COLD = -10;
    public static final int NEUTRAL = 2;
    private  int tone;

    //CONSTRUTORES
    public SmartBulb(){
        super();
        this.tone = NEUTRAL;

    }
    public SmartBulb(String n){
        super(n);
        this.tone = NEUTRAL;

    }
    public SmartBulb(String n,int t ){
        super(n);
        this.tone = t;

    }

    public SmartBulb(SmartBulb sb){
        super();
        setId(sb.getId());
        super.setOn(sb.getOn());
        this.setTone(sb.getTone());
    }
    //FIM DOS CONSTRUTORES

    public void setTone(int temp){
        tone = temp;

    }

    public int getTone(){
        return this.tone;
    }

    public boolean equals(Object o){
        if(this == o ) return true;
        if((o == null)| this.getClass() != o.getClass()) return false;
        SmartBulb sb = (SmartBulb) o;
        return super.equals(o) & this.tone == sb.getTone();
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString()).append("\nTone: ").append(this.getTone());
        return sb.toString();
    }

    public SmartBulb clone(){
        return new SmartBulb(this);
    }






}

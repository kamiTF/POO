package Projeto_POO.src;

public class Lateral extends Jogador{
    private int cruzamento;



    public Lateral(){
        super(Jogador.LATERAL);
        this.cruzamento = 50;
    }
    public Lateral(int num ,int vel , int res , int des , int imp , int jC, int rem , int cP, int cruz){
        super(Jogador.LATERAL,num,vel,res,des,imp,jC,rem,cP);
        this.cruzamento = cruz;
    }
    public Lateral (Lateral lateral){
        super(lateral);
        this.cruzamento = lateral.getCruzamento();
    }

    public int getCruzamento() {
        return cruzamento;
    }

    public void setCruzamento(int cruzamento) {
        this.cruzamento = cruzamento;
    }

    //EQUALS
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Lateral lateral = (Lateral) object;
        return lateral.equals(this) && lateral.getCruzamento() == this.cruzamento;
    }
    //CLONE
    public Lateral clone(){
        return new Lateral(this);
    }

    //TOSTRING
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append("Capacidade de Cruzamento: ").append(this.getCruzamento());
        return sb.toString();
    }
    public int eval(){
        int overall = 100;
        overall = (int) (overall    -(((100-this.getCruzamento())       *0.95)
                                    + ((100-this.getVelocidade())       *0.9)
                                    + ((100-this.getResistencia())      *0.7)
                                    + ((100-this.getDestreza())         *0.6)
                                    + ((100-this.getImpulsao())         *0.4)
                                    + ((100-this.getJogoCabeca())       *0.3)
                                    + ((100-this.getRemate())           *0.5)
                                    + ((100-this.getCapacidadePasse())  *0.9))/8);


        return overall;
    }




}

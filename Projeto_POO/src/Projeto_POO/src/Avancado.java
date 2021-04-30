package Projeto_POO.src;

public class Avancado extends Jogador{
    private int aceleracao;



    public Avancado(){
        super(Jogador.AVANCADO);
        this.aceleracao = 50;
    }
    public Avancado(int vel , int res , int des , int imp , int jC, int rem , int cP, int acel){
        super(Jogador.AVANCADO,vel,res,des,imp,jC,rem,cP);
        this.aceleracao = acel;
    }
    public Avancado (Avancado avancado){
        super(avancado);
        this.aceleracao = avancado.getAceleracao();
    }

    public int getAceleracao() {
        return aceleracao;
    }

    public void setAceleracao(int acel) {
        this.aceleracao = acel;
    }

    //EQUALS
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Avancado avancado = (Avancado) object;
        return avancado.equals(this) && avancado.getAceleracao() == this.aceleracao;
    }
    //CLONE
    public Avancado clone(){
        return new Avancado(this);
    }

    //TOSTRING
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append("Aceleracao: ").append(this.getAceleracao());
        return sb.toString();
    }
    public int eval(){
        int overall = 100;
        overall = (int) (overall    -(((100-this.getAceleracao())       *0.95)
                                    + ((100-this.getVelocidade())       *0.9)
                                    + ((100-this.getResistencia())      *0.7)
                                    + ((100-this.getDestreza())         *0.9)
                                    + ((100-this.getImpulsao())         *0.7)
                                    + ((100-this.getJogoCabeca())       *0.9)
                                    + ((100-this.getRemate())           *0.5)
                                    + ((100-this.getCapacidadePasse())  *0.5))/8);


        return overall;
    }
}

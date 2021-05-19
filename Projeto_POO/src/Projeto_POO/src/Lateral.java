package Projeto_POO.src;

public class Lateral extends Jogador{
    private int cruzamento;



    public Lateral(String nomeJ, int numeroJ, int vel, int res, int des, int imp, int cab, int rem, int p, int cruz) {
        super(nomeJ, numeroJ, vel, res, des, imp, cab, rem, p);
        cruzamento = cruz;
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
                                    + ((100-this.getCabeca())           *0.3)
                                    + ((100-this.getRemate())           *0.5)
                                    + ((100-this.getPasse())            *0.9))/8);


        return overall;
    }


    public static Lateral parse(String input){
        String[] campos = input.split(",");
        return new Lateral(campos[0], Integer.parseInt(campos[1]),
                Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]),
                Integer.parseInt(campos[4]),
                Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]),
                Integer.parseInt(campos[7]),
                Integer.parseInt(campos[8]),
                Integer.parseInt(campos[9]));
    }




}

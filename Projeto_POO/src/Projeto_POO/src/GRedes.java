package Projeto_POO.src;



public class GRedes extends Jogador {
    //Classe Guarda Redes criada a partir de uma super classe Jogador

    private int elasticidade;


    //GETTERS E SETTERS
    public int getElasticidade() {
        return elasticidade;
    }

    public void setElasticidade(int elasticidade) {
        this.elasticidade = elasticidade;
    }
    //FIM GETTERS E SETTERS


    //CONSTRUTORES
    public GRedes() {
        super(Jogador.GREDES, 50, 50, 50, 50, 50, 50, 50);
        this.elasticidade = 50;
    }

    public GRedes(int vel, int res, int des, int imp, int jC, int rem, int cP, int elas) {
        super(Jogador.GREDES, vel, res, des, imp, jC, rem, cP);
        this.elasticidade = elas;
    }

    public GRedes(GRedes g) {
        super(g);
        this.elasticidade = g.getElasticidade();
    }


    //TOSTRING , CLONE E EQUALS
    public String toString() {
        return (super.toString() + "\nElasticidade: " + this.elasticidade);
    }

    public GRedes clone() {
        return new GRedes(this);
    }


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        GRedes gredes = (GRedes) object;
        return gredes.equals(this) & gredes.getElasticidade() == this.elasticidade;

    }
    public int eval(){
        int overall = 100;
        overall = (int) (overall    -(((100-this.getElasticidade())       *0.95)
                                    //Nao precisa de velocidade
                                    //Nao precisa de resitencia
                                    + ((100-this.getDestreza())         *0.6)
                                    + ((100-this.getImpulsao())         *0.9)
                                    + ((100-this.getJogoCabeca())       *0.1)
                                    + ((100-this.getRemate())           *0.6)
                                    + ((100-this.getCapacidadePasse())  *0.9))/6);


        return overall;
    }
}

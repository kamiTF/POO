package Projeto_POO.src;
import Projeto_POO.src.Jogador;


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

    public GRedes clone()  {
        GRedes gRedes = (GRedes) super.clone();
        return new GRedes(this);
    }


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        GRedes gredes = (GRedes) object;
        return gredes.equals(this) & gredes.getElasticidade() == this.elasticidade;

    }
}

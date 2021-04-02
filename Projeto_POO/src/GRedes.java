package Projeto_POO.src;
import Projeto_POO.src.Jogador;
public class GRedes extends Projeto_POO.src.Jogador {
    //Classe Guarda Redes criada a partir de uma super classe Jogador
    private Posicao pos;
    private int velocidade;
    private int resistencia;
    private int destreza;
    private int impulsao;
    private int jogoCabeca;
    private int remate;
    private int capacidadePasse;
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
        super(Posicao.GREDES, 50, 50, 50, 50, 50, 50, 50);
        this.elasticidade = 50;
    }

    public GRedes(int vel, int res, int des, int imp, int jC, int rem, int cP, int elas) {
        super(Posicao.GREDES, vel, res, des, imp, jC, rem, cP);
        this.elasticidade = elas;
    }

    public GRedes(GRedes g) {
        this.pos = g.getPos();
        this.velocidade = g.getVelocidade();
        this.resistencia = g.getResistencia();
        this.destreza = g.getDestreza();
        this.impulsao = g.getImpulsao();
        this.jogoCabeca = g.getJogoCabeca();
        this.remate = g.getRemate();
        this.capacidadePasse = g.getCapacidadePasse();
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
        return gredes.getPos() == this.pos &&
                gredes.getVelocidade() == this.velocidade &&
                gredes.getResistencia() == this.resistencia &&
                gredes.getDestreza() == this.destreza &&
                gredes.getImpulsao() == this.impulsao &&
                gredes.getJogoCabeca() == this.jogoCabeca &&
                gredes.getRemate() == this.remate &&
                gredes.getCapacidadePasse() == this.capacidadePasse &&
                gredes.getElasticidade() == this.elasticidade;

    }
}

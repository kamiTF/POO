package Projeto_POO;

public class Jogador {


    private int velocidade;
    private int resistencia;
    private int destreza;
    private int impulsao;
    private int jogoCabeca;
    private int remate;
    private int capacidadePasse;


    //CONSTRUTOR VAZIO
    public Jogador() {
        this.velocidade = 50;
        this.resistencia = 50;
        this.destreza = 50;
        this.impulsao = 50;
        this.jogoCabeca = 50;
        this.remate = 50;
        this.capacidadePasse = 50;
    }

    //CONSTRUTOR PARAMETRIZADO
    public Jogador(int vel, int res, int des, int imp, int jC, int rem, int cP) {
        this.velocidade = vel;
        this.resistencia = res;
        this.destreza = des;
        this.impulsao = imp;
        this.jogoCabeca = jC;
        this.remate = rem;
        this.capacidadePasse = cP;
    }

    //CONSTRUTOR DE CÓPIA
    public Jogador(Jogador j) {
        this.velocidade = j.getVelocidade();
        this.resistencia = j.getResistencia();
        this.destreza = j.getDestreza();
        this.impulsao = j.getImpulsao();
        this.jogoCabeca = j.getJogoCabeca();
        this.remate = j.getRemate();
        this.capacidadePasse = j.getCapacidadePasse();
    }

    //GETTERS E SETTERS
    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public int getImpulsao() {
        return impulsao;
    }

    public void setImpulsao(int impulsao) {
        this.impulsao = impulsao;
    }

    public int getJogoCabeca() {
        return jogoCabeca;
    }

    public void setJogoCabeca(int jogoCabeca) {
        this.jogoCabeca = jogoCabeca;
    }

    public int getRemate() {
        return remate;
    }

    public void setRemate(int remate) {
        this.remate = remate;
    }

    public int getCapacidadePasse() {
        return capacidadePasse;
    }

    public void setCapacidadePasse(int capacidadePasse) {
        this.capacidadePasse = capacidadePasse;
    }
    //FIM GETTERS E SETTERS

    //EQUALS , TOSTRING E CLONE




    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Jogador jogador = (Jogador) object;
        return velocidade == jogador.velocidade &&
                resistencia == jogador.resistencia &&
                destreza == jogador.destreza &&
                impulsao == jogador.impulsao &&
                jogoCabeca == jogador.jogoCabeca &&
                remate == jogador.remate &&
                capacidadePasse == jogador.capacidadePasse;
    }

    public Jogador clone() {
        return new Jogador(this);
    }

    public String toString() {
        return ("Atributos do jogador:\n"
                + "Velocidade: " + this.velocidade
                + "\nResistência: " + this.resistencia
                + "\nDestreza: " + this.destreza
                + "\nImplusão: " + this.impulsao
                + "\nJogo de cabeça: " + this.jogoCabeca
                + "\nRemate: " + this.remate
                + "\nCapacidade de passe" + this.capacidadePasse);
    }
}


public class GRedes extends Jogador{
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
    public GRedes(){
        super();
        this.elasticidade = 50;
    }
    public GRedes(int vel, int res, int des, int imp, int jC, int rem, int cP, int elas){
        super(vel, res, des, imp, jC, rem, cP);
        this.elasticidade = elas;
    }
    public GRedes(GRedes g){
        super(g);
        this.elasticidade = g.getElasticidade();
    }


    //TOSTRING , CLONE E EQUALS
    public String toString(){
        return (super.toString()+ "\nElasticidade: " + this.elasticidade);
    }
    public GRedes clone(){
        return new GRedes(this);
    }


    public boolean equals(Object g) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        GRedes gredes = (GRedes) object;
        return velocidade == gredes.velocidade           &&
                resistencia == gredes.resistencia          &&
                destreza == gredes.destreza                &&
                impulsão == gredes.impulsão                &&
                jogoCabeca == gredes.jogoCabeca            &&
                remate == gredes.remate                    &&
                capacidadePasse == gredes.capacidadePasse  &&
                elasticidade == gredes.elasticidade;

    }
}






















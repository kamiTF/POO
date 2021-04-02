package Projeto_POO.src;

public class Jogador {

    public enum Posicao{
        GREDES,
        DEFESA,
        MEDIO,
        AVANCADO,
        LATERAL
    }
    private Posicao pos;
    private int velocidade;
    private int resistencia;
    private int destreza;
    private int impulsao;
    private int jogoCabeca;
    private int remate;
    private int capacidadePasse;


    //CONSTRUTOR VAZIO
    public Jogador() {
        this.pos = Posicao.MEDIO;
        this.velocidade = 50;
        this.resistencia = 50;
        this.destreza = 50;
        this.impulsao = 50;
        this.jogoCabeca = 50;
        this.remate = 50;
        this.capacidadePasse = 50;
    }

    //CONSTRUTOR PARAMETRIZADO
    public Jogador(Posicao p,int vel, int res, int des, int imp, int jC, int rem, int cP) {
        this.pos = p;
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
        this.pos = j.getPos();
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

    public Posicao getPos() {
        return pos;
    }

    public void setPos(Posicao pos) {
        this.pos = pos;
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

    public Jogador clone() throws CloneNotSupportedException {
        Jogador jogador = (Jogador) super.clone();
        return new Jogador(this);
    }

    public String toString() {
        return ("Atributos do jogador:\n"
                + "Posição: " + this.pos
                + "Velocidade: " + this.velocidade
                + "\nResistência: " + this.resistencia
                + "\nDestreza: " + this.destreza
                + "\nImplusão: " + this.impulsao
                + "\nJogo de cabeça: " + this.jogoCabeca
                + "\nRemate: " + this.remate
                + "\nCapacidade de passe" + this.capacidadePasse);
    }
}






















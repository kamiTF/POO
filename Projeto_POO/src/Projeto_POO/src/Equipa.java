package Projeto_POO.src;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Equipa{
    private String nome;
    private List<Jogador> jogadores;
    private List<Jogador> banco;

    public Equipa(String nomeE) {
        nome=nomeE;
        jogadores = new ArrayList<>();
    }

    public static Equipa parse(String input){
        String[] campos = input.split(",");
        return new Equipa(campos[0]);
    }

    public void insereJogador(Jogador j) {
        jogadores.add(j.clone());
    }
    public void insereBanco(Jogador j) {
        banco.add(j.clone());
    }


    public String getNome(){
        return nome;
    }
    public ArrayList<Integer> getJogadores(){
        ArrayList<Integer> jog = new ArrayList<>();
        for(Jogador j : jogadores){
            jog.add(j.getNumero());
        }
        return jog;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Jogador> getJog(){
        ArrayList<Jogador> jog = new ArrayList<>();
        for(Jogador j: jogadores){
            jog.add(j.clone());
        }
        return jog;
    }
    public String toString(){
        String r =  "Equipa:" + nome + "\n";
        for (Jogador j : jogadores){
            r += j.toString();
        }
        return r;
    }



}


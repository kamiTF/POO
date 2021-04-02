package Projeto_POO.src;
import Projeto_POO.src.Jogador;
import Projeto_POO.src.GRedes;
import java.util.ArrayList;

public class Equipa{
    private ArrayList<Jogador> jogadores;


    public Equipa(){
        jogadores = new ArrayList<Jogador>();
    }
    public Equipa(ArrayList<Jogador> j) throws CloneNotSupportedException {
        this.setJogadores(j);
    }
    public Equipa(Equipa e) throws CloneNotSupportedException {
        this.setJogadores(e.getJogadores());
    }
    public void setJogadores(ArrayList<Jogador> j) throws CloneNotSupportedException {
        jogadores = new ArrayList<Jogador>();
        for(Jogador jog: j){
            this.jogadores.add(jog.clone());
        }
    }

    public ArrayList<Jogador> getJogadores() throws CloneNotSupportedException {
        ArrayList<Jogador> ret = new ArrayList<>();
        for(Jogador jog : this.jogadores){
            ret.add(jog.clone());
        }
        return ret;
    }


}
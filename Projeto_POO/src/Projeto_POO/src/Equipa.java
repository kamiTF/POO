package Projeto_POO.src;
import Projeto_POO.src.Jogador;
import Projeto_POO.src.GRedes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Equipa{
    private Map<Integer ,Jogador> jogadores;


    public Equipa(){
        jogadores = new HashMap<>();
    }
    public Equipa(Map<Integer , Jogador> j) {
        this.setJogadores(j);
    }
    public Equipa(Equipa e)  {
        this.setJogadores(e.getJogadores());
    }
    public void setJogadores(Map<Integer ,Jogador> j) {
        jogadores = new HashMap<>();
        for(Jogador jog: j.values()){
            jogadores.put(jog.getPos(),jog.clone());
        }
    }

    public Map<Integer ,Jogador> getJogadores()  {
        return jogadores.values().stream().collect(Collectors.toMap(Jogador::getPos,Jogador::clone));
    }


}
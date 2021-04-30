package Projeto_POO.src;
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
    public int equipaOverAll(Map<Integer, Jogador> equipa){
        int average = 0;
        for(Jogador j : equipa.values()){
            average += j.eval();
        }
        return average/equipa.values().size();
    }


}
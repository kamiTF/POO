package Projeto_POO.src;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Equipa{
    private Map<Integer ,Jogador> jogadoresTitulares;
    private Map<Integer ,Jogador> jogadoresBanco;

    public Equipa(){
        jogadoresTitulares = new HashMap<>();
        jogadoresBanco= new HashMap<>();
    }
    public Equipa(Map<Integer , Jogador> jT,Map<Integer , Jogador> jB) {
        this.setJogadoresTitulares(jT);
        this.setJogadoresBanco(jB);
    }
    public Equipa(Equipa e)  {
        this.setJogadoresTitulares(e.getJogadoresTitulares());
        this.setJogadoresBanco(e.getJogadoresBanco());
    }

    public void setJogadoresTitulares(Map<Integer ,Jogador> j) {
        jogadoresTitulares = new HashMap<>();
        for(Jogador jog: j.values()){
            jogadoresTitulares.put(jog.getNumero(),jog.clone());
        }
    }
    public void setJogadoresBanco(Map<Integer ,Jogador> j) {
        jogadoresBanco = new HashMap<>();
        for(Jogador jog: j.values()){
            jogadoresBanco.put(jog.getNumero(),jog.clone());
        }
    }

    public Map<Integer ,Jogador> getJogadoresTitulares()  {
        return jogadoresTitulares.values().stream().collect(Collectors.toMap(Jogador::getNumero,Jogador::clone));
    }
    public Map<Integer ,Jogador> getJogadoresBanco()  {
        return jogadoresBanco.values().stream().collect(Collectors.toMap(Jogador::getNumero,Jogador::clone));
    }
    public int equipaOverAll(Equipa e){
        int average = 0;
        for(Jogador j : e.getJogadoresTitulares().values()){
            average += j.eval();
        }
        return average/e.getJogadoresTitulares().values().size();
    }


}
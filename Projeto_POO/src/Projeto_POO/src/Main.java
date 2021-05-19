package Projeto_POO.src;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args){

        Equipa casa = new Equipa("Sporting");
        Equipa fora = new Equipa("Arouca");


        Avancado casaA = new Avancado("Cristiano Rinaldo",7,90,90,90,90,90,85,90,90);
        Medio casaM = new Medio("Jose Socrates",20,70,70,70,70,70,70,70,70);
        Lateral casaL= new Lateral("Mesis",5,80,80,80,80,80,80,80,80);
        Defesa casaD = new Defesa("PEPE",2,80,80,80,80,80,80,80);
        GuardaRedes casaGR = new GuardaRedes("Patricia",1,10,10,50,90,60,80,65,86);

        casa.insereJogador(casaA);
        casa.insereJogador(casaM);
        casa.insereJogador(casaL);
        casa.insereJogador(casaD);
        casa.insereJogador(casaGR);


        Avancado foraA = new Avancado("Cristiano Rinaldo",7,90,90,90,90,90,85,90,90);
        Medio foraM = new Medio("Jose Socrates",20,70,70,70,70,70,70,70,70);
        Lateral foraL= new Lateral("Mesis",5,80,80,80,80,80,80,80,80);
        Defesa foraD = new Defesa("PEPE",2,80,80,80,80,80,80,80);
        GuardaRedes foraGR = new GuardaRedes("Patricia",1,10,10,50,90,60,80,65,86);

        fora.insereJogador(foraA);
        fora.insereJogador(foraM);
        fora.insereJogador(foraL);
        fora.insereJogador(foraD);
        fora.insereJogador(foraGR);

        Map<Integer,Integer> c = new HashMap<>();
        Map<Integer,Integer> f = new HashMap<>();
        Jogo jogo = new Jogo("Sporting","Arouca",0,0,LocalDate.now(),casa.getJogadores(),c,fora.getJogadores(),f);
        int coin = ThreadLocalRandom.current().nextInt(0, 2);
        if(coin==0){
            System.out.println("A bola começa do lado do: "+casa.getNome());
            jogo.iniciarJogo(casa,fora,jogo,0);
        }
        else {
            System.out.println("A bola começa do lado do: "+fora.getNome());
            jogo.iniciarJogo(fora, casa, jogo, 0);
        }
        System.out.println("Golos Casa: "+jogo.getGolosCasa());
        System.out.println("Golos Fora: "+jogo.getGolosFora());







    }

}

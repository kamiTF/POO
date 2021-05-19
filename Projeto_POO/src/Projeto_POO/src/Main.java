package Projeto_POO.src;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args){

        Equipa casa = new Equipa("Sporting");
        Equipa fora = new Equipa("Arouca");


        Avancado casaA = new Avancado("Cristiano Rinaldo",7,99,99,99,99,99,99,99,99);
        Medio casaM = new Medio("Jose Socrates",20,70,70,70,70,70,70,70,70);
        Lateral casaL= new Lateral("Mesis",5,80,80,80,80,80,80,80,80);
        Defesa casaD = new Defesa("PEPE",2,60,60,60,60,60,60,60);
        GuardaRedes casaGR = new GuardaRedes("Patricia",1,10,10,50,90,60,80,65,86);

        casa.insereJogador(casaA);
        casa.insereJogador(casaM);
        casa.insereJogador(casaL);
        casa.insereJogador(casaD);
        casa.insereJogador(casaGR);


        Avancado foraA = new Avancado("Cristiano Rinaldo",7,99,99,99,99,99,99,99,99);
        Medio foraM = new Medio("Jose Socrates",20,70,70,70,70,70,70,70,70);
        Lateral foraL= new Lateral("Mesis",5,80,80,80,80,80,80,80,80);
        Defesa foraD = new Defesa("PEPE",2,60,60,60,60,60,60,60);
        GuardaRedes foraGR = new GuardaRedes("Patricia",1,10,10,50,90,60,80,65,86);

        fora.insereJogador(foraA);
        fora.insereJogador(foraM);
        fora.insereJogador(foraL);
        fora.insereJogador(foraD);
        fora.insereJogador(foraGR);

        Map<Integer,Integer> c = new HashMap<>();
        Map<Integer,Integer> f = new HashMap<>();
        Jogo jogo = new Jogo("Sporting","Arouca",0,0,LocalDate.now(),casa.getJogadores(),c,fora.getJogadores(),f);

        System.out.println(jogo.iniciarJogo(casa,fora,jogo));

        System.out.println(jogo.getGolosCasa());System.out.println(jogo.getGolosFora());







    }

}

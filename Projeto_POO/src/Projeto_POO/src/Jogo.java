package Projeto_POO.src;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Jogo {
    private String equipaCasa;
    private String equipaFora;
    private int golosCasa;
    private int golosFora;
    private LocalDate date;
    private List<Integer> jogadoresCasa;
    private List<Integer> jogadoresFora;
    Map<Integer, Integer> substituicoesCasa = new HashMap<>();
    Map<Integer, Integer> substitucoesFora = new HashMap<>();
    private int duracao;

    public Jogo (String ec, String ef, int gc, int gf, LocalDate d, ArrayList<Integer> jc, Map<Integer, Integer> sc, ArrayList<Integer> jf, Map<Integer, Integer> sf){
        equipaCasa = ec;
        equipaFora = ef;
        golosCasa = gc;
        golosFora = gf;
        date = d;
        jogadoresCasa = new ArrayList<>(jc);
        jogadoresFora = new ArrayList<>(jf);
        substituicoesCasa = new HashMap<>(sc);
        substitucoesFora = new HashMap<>(sf);
    }

    public static Jogo parse(String input){
        String[] campos = input.split(",");
        String[] data = campos[4].split("-");
        List<Integer> jc = new ArrayList<>();
        List<Integer> jf = new ArrayList<>();
        Map<Integer, Integer> subsC = new HashMap<>();
        Map<Integer, Integer> subsF = new HashMap<>();
        for (int i = 5; i < 16; i++){
            jc.add(Integer.parseInt(campos[i]));
        }
        for (int i = 16; i < 19; i++){
            String[] sub = campos[i].split("->");
            subsC.put(Integer.parseInt(sub[0]), Integer.parseInt(sub[1]));
        }
        for (int i = 19; i < 30; i++){
            jf.add(Integer.parseInt(campos[i]));
        }
        for (int i = 30; i < 33; i++){
            String[] sub = campos[i].split("->");
            subsF.put(Integer.parseInt(sub[0]), Integer.parseInt(sub[1]));
        }
        return new Jogo(campos[0], campos[1], Integer.parseInt(campos[2]), Integer.parseInt(campos[3]),
                LocalDate.of(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])),
                (ArrayList<Integer>) jc, subsC, (ArrayList<Integer>) jf, subsF);
    }

    public String toString() {
        return  "Jogo:" + equipaCasa + " - " + equipaFora;
        //+ " -> " + substituicoesCasa.toString()
        //+ " -> " + substitucoesFora.toString();
    }

    public int getGolosCasa() {
        return golosCasa;
    }

    public void setGolosCasa(int golosCasa) {
        this.golosCasa = golosCasa;
    }

    public int getGolosFora() {
        return golosFora;
    }

    public void setGolosFora(int golosFora) {
        this.golosFora = golosFora;
    }

    public void addGolo(Equipa e){
        if(e.getNome().equals(equipaCasa)){
            golosCasa++;
        }
        else if (e.getNome().equals(equipaFora)){
            golosFora++;
        }
    }

    public boolean iniciarJogo(Equipa casa, Equipa fora, Jogo jogo,int duracao){
        medsVSmeds(casa,fora,duracao,jogo);

        return false;
    }
    public boolean avanVSdef(Equipa atq,Equipa adv, int duracao,Jogo jogo){


        while(duracao<7) {
            int nAvanc = 0;
            int averageAvanc = 0;
            //OVERALL DOS AVANCADOS
            for (Jogador j : atq.getJog()) {
                if (j instanceof Avancado) {
                    nAvanc++;
                    averageAvanc += j.eval();
                }

            }
            averageAvanc = averageAvanc / nAvanc;

            //OVERALL DOS DEFESAS
            int nDefs = 0;
            int averageDefs = 0;
            for (Jogador j : adv.getJog()) {
                if (j instanceof Defesa) {
                    nDefs++;
                    averageDefs += j.eval();
                }

            }
            averageDefs = averageDefs / nDefs;
            //CALCULO DO RESUTADO
            int probAvan = ThreadLocalRandom.current().nextInt(0, averageAvanc + 1);
            int probDefs = ThreadLocalRandom.current().nextInt(averageDefs/2, averageDefs + 1);
            duracao++;
            //CHAMAR OUTROS METODOS
            if (probAvan > probDefs) {
                this.avanVSgR(atq,adv, duracao, jogo);
            } else defVSmeds(adv,atq,duracao, jogo);

        }
        return true;
    }

    public boolean avanVSgR(Equipa atq,Equipa adv,int duracao,Jogo jogo){



        while(duracao<7) {
            int nAvanc = 0;
            int averageAvanc = 0;
            //OVERALL DOS AVANCADOS
            for (Jogador j : atq.getJog()) {
                if (j instanceof Avancado) {
                    nAvanc++;
                    averageAvanc += j.eval();
                }

            }
            averageAvanc = averageAvanc / nAvanc;

            //OVERALL DO GUARDA RDES

            int averageGR = 0;
            for (Jogador j : adv.getJog()) {
                if (j instanceof GuardaRedes) {

                    averageGR += j.eval();
                }

            }

            //CALCULO DO RESUTADO
            int probAvan = ThreadLocalRandom.current().nextInt(0, averageAvanc + 1);
            int probGR = ThreadLocalRandom.current().nextInt(averageGR-10, averageGR + 1);
            duracao++;
            //CHAMAR OUTROS METODOS
            if (probAvan > probGR) {
                System.out.println("Golo Equipa:"+atq.getNome());
                jogo.addGolo(atq);
                iniciarJogo(adv,atq,jogo,duracao);

            } else this.defVSmeds(adv,atq,duracao, jogo);
        }
        return true;


    }
    public boolean defVSmeds(Equipa atq,Equipa adv,int duracao,Jogo jogo){




        while(duracao<7) {
            int nDefs = 0;
            int averageDefs = 0;
            //OVERALL DOS AVANCADOS
            for (Jogador j : atq.getJog()) {
                if (j instanceof Defesa) {
                    nDefs++;
                    averageDefs += j.eval();
                }

            }
            averageDefs = averageDefs / nDefs;

            //OVERALL DOS DEFESAS
            int nMeds = 0;
            int averageMeds = 0;
            for (Jogador j : adv.getJog()) {
                if (j instanceof Defesa) {
                    nMeds++;
                    averageMeds += j.eval();
                }

            }
            averageMeds = averageMeds / nMeds;
            //CALCULO DO RESUTADO
            int probDefs = ThreadLocalRandom.current().nextInt(averageDefs/2, averageDefs + 1);
            int probMeds = ThreadLocalRandom.current().nextInt(0, averageMeds + 1);
            duracao++;
            //CHAMAR OUTROS METODOS
            if (probDefs > probMeds) {
                medsVSmeds(atq,adv, duracao , jogo);
            } else avanVSdef(adv,atq,duracao, jogo);

        }
        return true;


    }
    public boolean medsVSmeds(Equipa atq,Equipa adv,int duracao,Jogo jogo) {


        while (duracao < 7) {
            int nMeds = 0;
            int averageMeds = 0;
            //OVERALL DOS AVANCADOS
            for (Jogador j : atq.getJog()) {
                if (j instanceof Medio || j instanceof Lateral) {
                    nMeds++;
                    averageMeds += j.eval();
                }


            }
            averageMeds = averageMeds / nMeds;

            //OVERALL DOS DEFESAS
            int nMedsAdv = 0;
            int averageMedsAdv = 0;
            for (Jogador j : adv.getJog()) {
                if (j instanceof Defesa) {
                    nMedsAdv++;
                    averageMedsAdv += j.eval();
                }

            }
            averageMedsAdv = averageMedsAdv / nMedsAdv;
            //CALCULO DO RESUTADO
            int probMeds = ThreadLocalRandom.current().nextInt(averageMeds-10, averageMeds + 1);
            int probMedsAdv = ThreadLocalRandom.current().nextInt(averageMedsAdv-10, averageMedsAdv + 1);
            duracao++;
            //CHAMAR OUTROS METODOS
            if (probMeds > probMedsAdv) {
                avanVSdef(atq,adv, duracao , jogo);
            } else medsVSmeds(adv,atq,duracao, jogo);
        }
        return true;
    }

}

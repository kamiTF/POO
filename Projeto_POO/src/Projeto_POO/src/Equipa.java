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
    public String toString(){
        String r =  "Equipa:" + nome + "\n";
        for (Jogador j : jogadores){
            r += j.toString();
        }
        return r;
    }
    public boolean avanVSdef(Equipa adv, int duracao,Jogo jogo){
        if(duracao+1>=5) {
            System.out.println("Golos Casa: "+jogo.getGolosCasa());
            System.out.println("Golos Fora: "+jogo.getGolosFora());
            return true;

        }
        System.out.println(duracao);

        while(duracao<5) {
            int nAvanc = 0;
            int averageAvanc = 0;
            //OVERALL DOS AVANCADOS
            for (Jogador j : jogadores) {
                if (j instanceof Avancado) {
                    nAvanc++;
                    averageAvanc += j.eval();
                }

            }
            averageAvanc = averageAvanc / nAvanc;

            //OVERALL DOS DEFESAS
            int nDefs = 0;
            int averageDefs = 0;
            for (Jogador j : adv.jogadores) {
                if (j instanceof Defesa) {
                    nDefs++;
                    averageDefs += j.eval();
                }

            }
            averageDefs = averageDefs / nDefs;
            //CALCULO DO RESUTADO
            int probAvan = ThreadLocalRandom.current().nextInt(0, averageAvanc + 1);
            int probDefs = ThreadLocalRandom.current().nextInt(0, averageDefs + 1);
            //CHAMAR OUTROS METODOS
            if (probAvan > probDefs) {
                 adv.avanVSgR(this, duracao + 1, jogo);
            } else adv.defVSmeds(this,duracao+1, jogo);

        }
        return true;
    }

    public boolean avanVSgR(Equipa adv,int duracao,Jogo jogo){
        if(duracao+1>=5) {
            System.out.println("Golos Casa: "+jogo.getGolosCasa());
            System.out.println("Golos Fora: "+jogo.getGolosFora());
            return true;

        }
        System.out.println(duracao);

        while(duracao<5) {
            int nAvanc = 0;
            int averageAvanc = 0;
            //OVERALL DOS AVANCADOS
            for (Jogador j : jogadores) {
                if (j instanceof Avancado) {
                    nAvanc++;
                    averageAvanc += j.eval();
                }

            }
            averageAvanc = averageAvanc / nAvanc;

            //OVERALL DO GUARDA RDES

            int averageGR = 0;
            for (Jogador j : adv.jogadores) {
                if (j instanceof GuardaRedes) {

                    averageGR += j.eval();
                }

            }

            //CALCULO DO RESUTADO
            int probAvan = ThreadLocalRandom.current().nextInt(0, averageAvanc + 1);
            int probGR = ThreadLocalRandom.current().nextInt(0, averageGR + 1);
            //CHAMAR OUTROS METODOS
            if (probAvan > probGR) {
                System.out.println("Golo Men");
                jogo.addGolo(this);
                adv.medsVSmeds(this, duracao + 1, jogo);

            } else adv.defVSmeds(this,duracao+1, jogo);
        }
        return true;


    }
    public boolean defVSmeds(Equipa adv,int duracao,Jogo jogo){
        if(duracao+1>=5) {
        System.out.println("Golos Casa: "+jogo.getGolosCasa());
        System.out.println("Golos Fora: "+jogo.getGolosFora());
        return true;

    }

        System.out.println(duracao);

        while(duracao<5) {
            int nDefs = 0;
            int averageDefs = 0;
            //OVERALL DOS AVANCADOS
            for (Jogador j : jogadores) {
                if (j instanceof Defesa) {
                    nDefs++;
                    averageDefs += j.eval();
                }

            }
            averageDefs = averageDefs / nDefs;

            //OVERALL DOS DEFESAS
            int nMeds = 0;
            int averageMeds = 0;
            for (Jogador j : adv.jogadores) {
                if (j instanceof Defesa) {
                    nMeds++;
                    averageMeds += j.eval();
                }

            }
            averageMeds = averageMeds / nMeds;
            //CALCULO DO RESUTADO
            int probDefs = ThreadLocalRandom.current().nextInt(0, averageDefs + 1);
            int probMeds = ThreadLocalRandom.current().nextInt(0, averageMeds + 1);
            //CHAMAR OUTROS METODOS
            if (probDefs > probMeds) { this.medsVSmeds(adv, duracao + 1, jogo);
            } else adv.avanVSdef(this,duracao+1, jogo);

        }
        return true;


    }
    public boolean medsVSmeds(Equipa adv,int duracao,Jogo jogo) {
        if(duracao>=5) {
            System.out.println("Golos Casa: "+jogo.getGolosCasa());
            System.out.println("Golos Fora: "+jogo.getGolosFora());
            return true;

        }
        System.out.println(duracao);
        while (duracao < 5) {
            int nMeds = 0;
            int averageMeds = 0;
            //OVERALL DOS AVANCADOS
            for (Jogador j : jogadores) {
                if (j instanceof Medio || j instanceof Lateral) {
                    nMeds++;
                    averageMeds += j.eval();
                }


            }
            averageMeds = averageMeds / nMeds;

            //OVERALL DOS DEFESAS
            int nMedsAdv = 0;
            int averageMedsAdv = 0;
            for (Jogador j : adv.jogadores) {
                if (j instanceof Defesa) {
                    nMedsAdv++;
                    averageMedsAdv += j.eval();
                }

            }
            averageMedsAdv = averageMedsAdv / nMedsAdv;
            //CALCULO DO RESUTADO
            int probMeds = ThreadLocalRandom.current().nextInt(0, averageMeds + 1);
            int probMedsAdv = ThreadLocalRandom.current().nextInt(0, averageMedsAdv + 1);
            //CHAMAR OUTROS METODOS
            if (probMeds > probMedsAdv) {
                this.avanVSdef(adv, duracao + 1, jogo);
            } else adv.avanVSdef(this,duracao+1, jogo);
        }
        return true;
    }


}


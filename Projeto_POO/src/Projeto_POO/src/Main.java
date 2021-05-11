package Projeto_POO.src;

public class Main {
    public static void main(String[] args){

        Lateral lat = new Lateral(4,90,70,80,65,50,75,85,90);
        Avancado avan = new Avancado();
        System.out.println("Avaliacao: " + lat.eval());
        System.out.println("Avaliacao: " + avan.eval());

    }
}

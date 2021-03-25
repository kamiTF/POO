package aula4;

public class Lampada {
    //ex4 ficha 3
    public enum Modo{
        ON,
        OFF,
        ECO
    }
   
    //3 estados - ligado , desligado ,eco
    private Modo modo;


    //consumo ligado, eco
    private double consLigado;
    private double consEco;


    //consumo total
    private double consTotal;


    //incio do estado mais recente
    private double inicioEstado; // vamos usar System.currentTimeMillis();   - daí o double


    public Lampada(){
        modo = Modo.OFF;
        consLigado = 2;
        consEco = 1;
        consTotal = 0;
        inicioEstado = System.currentTimeMillis();
    }

    public Lampada(Modo m,double nconsLigado, double nconsEco, double nconsTotal, double ninicioEstado ){
        modo = m;
        consLigado = nconsLigado;
        consEco = nconsEco;
        consTotal = nconsTotal;
        inicioEstado = ninicioEstado;
    }
    public Lampada(Lampada l){
        modo = l.getModo();
        consLigado = l.getConL();
        consEco = l.getConE();
        consTotal = l.getConT();
        inicioEstado = l.getInicioEstado();
    }

    public Modo getModo(){
        return modo;
    }
    public void setModo(Modo nmodo){
        modo = nmodo;
    }
    public double getConL(){
        return consLigado;
    }
    public void getConL(double nConL){
        consLigado = nConL;
    }
    public double getConE(){
        return consEco;
    }
    public void setConE(double nConE){
        consEco = nConE;
    }
    public double getConT(){
        return consTotal;
    }
    public void setConT(double nConT){
        consTotal = nConT;
    }
    public double getInicioEstado(){
        return inicioEstado;
    }
    public void setInicioEstado(double nInicioEstado){
        inicioEstado = nInicioEstado;
    }
    public boolean equals(Object o){
        if(this == o) return true;
        if((o==null) || (this.getClass() != o.getClass())) return false;

        Lampada l = (Lampada) o;
        return  l.getModo() == this.modo        &&
                l.getConL() == this.consLigado  &&
                l.getConE() == this.consEco     &&
                l.getConT() == this.consTotal   &&
                l.getInicioEstado() == this.inicioEstado;

    }
    public Lampada clone(){
        return new Lampada(this);
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Lampada Modo: ").append(modo)
          .append("\nConsumo por segundo ON: ").append(consLigado)
          .append("\nConsumo por segundo ECO: ").append(consEco)
          .append("\nConsumo Total: ").append(consTotal)
          .append("\nUltimo reset feito à: ").append(inicioEstado);
        return sb.toString();
    }
    private void calculaECO(){
        double deltaTempo = System.currentTimeMillis() - inicioEstado;
        //numero de millisegundo * consumo por millisegundo
        this.consTotal += deltaTempo * consEco;
    }
    private void calculaON(){
        double deltaTempo = System.currentTimeMillis() - inicioEstado;
        //numero de millisegundo * consumo por millisegundo
        this.consTotal += deltaTempo * consLigado;
    }



    //a
    public void lampON(){
        if(this.modo == Modo.ECO){
            calculaECO();
        }
        this.inicioEstado = System.currentTimeMillis();
        this.modo = Modo.ON;

    }
    //b
    public void lampOFF(){
        if(this.modo == Modo.ECO){
            calculaECO();
        }
        if(this.modo == Modo.ON){
            calculaON();
        }
        this.inicioEstado = System.currentTimeMillis();
        this.modo = Modo.OFF;
    }

    //c
    public void lampECO(){
        
        if(this.modo == Modo.ON){
           calculaON();
        }
        this.inicioEstado = System.currentTimeMillis();
        this.modo = Modo.ECO;
    
        
    }
    //d
    public double totalConsumo(){
        
        return this.consTotal + periodoConsumo();
    }
    //e
    public double periodoConsumo(){
        double cAtual = 0;
        if(this.modo == Modo.ON){
            cAtual = (System.currentTimeMillis() - inicioEstado)* consLigado;
        }
        if(this.modo == Modo.ECO){
            cAtual = (System.currentTimeMillis() - inicioEstado)* consEco;
        }
        return cAtual;
    }


}

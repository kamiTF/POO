package aula3.src;

public class Futebol {
    private int visitado;
    private int visitante;
    //Estado: 0-nao iniciado 1-a decorrer 2- terminado
    private int estado;

    public Futebol (){
        this.visitado = 0;
        this.visitante = 0;
        this.estado=0;
    }
    public Futebol (int x, int y, int est){
        this.visitado = x;
        this.visitante = y;
        this.estado=est;
    }
    public Futebol (Futebol jogo){
        this.visitado = jogo.getVisitado();
        this.visitante = jogo.getVisitante();
        this.estado = jogo.getEstado();
    }

    public boolean equals(Object o){
        if(this == o) return true;
            if((o==null) || (this.getClass() != o.getClass())) return false;
            Futebol c = (Futebol) o;
            return (this.getVisitado() == c.getVisitado() &&
                    this.getVisitante() == c.getVisitante() &&
                    this.getEstado() == c.getEstado());
    }



    public int getVisitado(){
        return this.visitado;
    }
    public int getVisitante(){
        return this.visitante;
    }
    public int getEstado(){
        return this.estado;
    }
    public void setVisitado(int x){
        this.visitado = x;
    }
    public void setVisitante(int x){
        this.visitante = x;
    }
    public void setEstado(int x){
        this.estado = x;
    }
    public Futebol clone(){
        return new Futebol(this);
    }
    public String toString(){
        return("Futebol - Visitado: " + this.visitado + "- Visitante: " + this.visitante + "-Estado: " + this.estado);
    }


    public void startGame(){
        if(estado == 0) this.estado = 1;
    }
    public void endGame(){
        if(estado == 1) this.estado = 2;
    }
    public void goloVisitado(){
        if(this.getEstado() == 1){
            setVisitado(getVisitado()+1);
        }
    }
    public void goloVisitante(){
        if(this.getEstado()==1){
            setVisitante(getVisitante()+1);
        }
    }
    public String resultadoAtual(){
        return ("Visitado: " + getVisitado() + "Visitante: " + getVisitante() );
    }



}

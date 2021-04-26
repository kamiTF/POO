package Projeto_POO.src;



public class Medio extends Jogador {
    private int recBolas;

    //CONSTRUTOR VAZIO
    public Medio(){
        super(Jogador.MEDIO);
        this.recBolas = 50;
    }
    //CONTRUTOR PARAMETERIZADO
    public Medio(int vel, int res , int des , int imp , int jC, int rem, int cP, int recBol){
        super(Jogador.MEDIO,vel,res,des,imp,jC,rem,cP);
        this.recBolas = recBol;

    }
    //CONSTRUTOR DE COPIA
    public Medio(Medio medio){
        super(medio);
        this.recBolas = medio.getRecBolas();
    }
    //GETTER E SETTER PARA RECUPERACAO DE BOLAS
    public int getRecBolas(){
        return  recBolas;
    }
    public void setRecBolas(int rB){
        this.recBolas = rB;
    }

    //EQUALS
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Medio medio = (Medio) object;
        return medio.equals(this) && medio.getRecBolas() == this.recBolas;
    }
    //CLONE


    public Medio clone(){
        return  new Medio(this);
    }

    //TOSTRING
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append("Recuperacao de Bolas: ").append(this.getRecBolas());
        return sb.toString();
    }




}

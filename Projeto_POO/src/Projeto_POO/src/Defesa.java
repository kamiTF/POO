package Projeto_POO.src;

public class Defesa extends Jogador {
    private int desarme;
    public Defesa(){
        super(DEFESA);
        this.desarme = 50;
    }
    public Defesa(int vel , int res , int des , int imp , int jC, int rem , int cP, int desar){
        super(Jogador.DEFESA,vel,res,des,imp,jC,rem,cP);
        this.desarme = desar;
    }
    public Defesa(Defesa defesa){
        super(defesa);
        this.desarme = defesa.getDesarme();
    }
    public int getDesarme() {
        return desarme;
    }

    public void setDesarme(int desarme) {
        this.desarme = desarme;
    }
    //EQUALS
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Defesa defesa = (Defesa) object;
        return defesa.equals(this) && defesa.getDesarme() == this.desarme;
    }
    //CLONE
    public Defesa clone(){
        return new Defesa(this);
    }
    //TOSTRING
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append("Desarme: ").append(this.getDesarme());
        return sb.toString();
    }








}
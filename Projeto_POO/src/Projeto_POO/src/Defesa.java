package Projeto_POO.src;

public class Defesa extends Jogador {
    private int desarme;



    public Defesa(String nomeJ, int numeroJ, int vel, int res, int des, int imp, int cab, int rem, int p) {
        super(nomeJ, numeroJ, vel, res, des, imp, cab, rem, p);
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
    public int eval(){
        int overall = 100;
        overall = (int) (overall    -(((100-this.getDesarme())          *0.95)
                                    + ((100-this.getVelocidade())       *0.4)
                                    + ((100-this.getResistencia())      *0.5)
                                    + ((100-this.getDestreza())         *0.7)
                                    + ((100-this.getImpulsao())         *0.7)
                                    + ((100-this.getCabeca())       *0.8)
                                    + ((100-this.getRemate())           *0.5)
                                    + ((100-this.getPasse())  *0.9))/8);


        return overall;
    }


    public static Defesa parse(String input){
        String[] campos = input.split(",");
        return new Defesa(campos[0], Integer.parseInt(campos[1]),
                Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]),
                Integer.parseInt(campos[4]),
                Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]),
                Integer.parseInt(campos[7]),
                Integer.parseInt(campos[8]));
    }







}

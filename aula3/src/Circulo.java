package aula3.src;

 
public class Circulo{

    private double x;
    private double y;
    private double raio;
    
        public Circulo(){
            this.x = 0;
            this.y = 0;
            this.raio = 1;
        }

        public Circulo(double cx, double cy, double nraio){
            this.x = cx;
            this.y = cy;
            this.raio = nraio;
        }

        public Circulo(Circulo umcirculo){
            this.x = umcirculo.getX();
            this.y = umcirculo.getY();
            this.raio = umcirculo.getRaio();
        }

        public void alteraCentro(double cx, double cy){
            this.x = cx;
            this.y = cy;
        }

        public double calculaArea(){
            return Math.PI * Math.pow(this.raio, 2);
        }

        public double calculaPerimetro(){
            return Math.PI * this.raio * 2;
        }

        public boolean equals(Object o){
            if(this == o) return true;
            if((o==null) || (this.getClass() != o.getClass())) return false;
            Circulo c = (Circulo) o;
            return (this.getX() == c.getX() &&
                    this.getY() == c.getY() &&
                    this.getRaio() == c.getRaio());
        }

        public String toString(){
            return("Circulo - X: " + this.x + "-Y: " + this.y + "-Raio: " + this.raio);
        }
        
        public Circulo clone(){
            return new Circulo(this);
        }

        public double getX(){
            return this.x;
        }

        public double getY(){
            return this.y;
        }

        public double getRaio(){
            return this.raio;
        }

        public void setX(double cx){
            this.x = cx;
        }

        public void setY(double cy){
            this.x = cy;
        }

        public void setRaio(double raio){
            this.x = raio;
        }



}


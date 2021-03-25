package encomenda;
import java.time.LocalDateTime;
import java.util.ArrayList;
public class EncomendaEficiente {
    private String nomCliente;
    private int numFiscal;
    private String morada;
    private int numEncomenda;
    private LocalDateTime data;
    private ArrayList<LinhaEncomenda> linhas;

    //Diag classes
    // construtores
    public  EncomendaEficiente(){
        this.nomCliente = "n/a";
        this.numFiscal = 0;
        this.morada = "n/a";
        this.numEncomenda = 0;
        this.data = LocalDateTime.now();
        linhas = new ArrayList<LinhaEncomenda>();
    }
    public EncomendaEficiente(String nomeCliente, int nFiscal, String nMorada,int nEncomenda,LocalDateTime nData,ArrayList<LinhaEncomenda> nLinhas){
        this.nomCliente = nomeCliente;
        this.numFiscal = nFiscal;
        this.morada = nMorada;
        this.numEncomenda = nEncomenda;
        this.data = nData;
        this.setLinhaEncomenda(nLinhas);


    }
    public EncomendaEficiente(EncomendaEficiente e){
        this.nomCliente = e.getNomCliente();
        this.numFiscal = e.getNumFiscal();
        this.morada = e.getMorada();
        this.numEncomenda = e.getNumEncomenda();
        this.data = e.getData();
        this.setLinhaEncomenda(e.getLinhaEncomenda());
    }

    //getters setters



    public String getNomCliente(){
        return this.nomCliente;
    }

    public int getNumFiscal(){
     return this.numFiscal;
    }
    
    public String getMorada(){
     return this.morada;   
    }
    
    public int getNumEncomenda(){
     return this.numEncomenda;
    }
    
    public LocalDateTime getData(){
     return this.data;
    }
    
    public ArrayList<LinhaEncomenda> getLinhaEncomenda(){

        ArrayList<LinhaEncomenda> ret = new ArrayList<>();
        for(LinhaEncomenda linha : this.linhas){
            ret.add(linha.clone());
        }
        return ret;
    }
    public void setNomCliente(String nome){
        this.nomCliente = nome;
    }
    
    public void setNumFiscal(int nFiscal){
     this.numFiscal = nFiscal;   
    }
    
    public void setMorada(String nMorada ){
     this.morada = nMorada;   
    }
    
    public void setNumEncomenda(int nEncomenda ){
     this.numEncomenda = nEncomenda;   
    }
    
    public void setData(LocalDateTime nData){
     this.data = nData;   
    }
    
    public void setLinhaEncomenda(ArrayList<LinhaEncomenda> l){

        this.linhas = new ArrayList<>();
        for (LinhaEncomenda linha: l){
            this.linhas.add(linha.clone());
        }
    }
    
    



    



    

    //equals, toString, clone
    public boolean equals(Object o){
        if (this == o) return true;
        if (( o == null) || (this.getClass() != o.getClass())) return false;
        EncomendaEficiente c = (EncomendaEficiente) o;
        return c.getNomCliente()       == this.nomCliente      && 
               c.getNumFiscal()        == this.numFiscal       &&
               c.getMorada()           == this.morada          &&
               c.getNumEncomenda()     == this.numEncomenda    &&
               c.getData()             == this.data            &&
               c.getLinhaEncomenda()   == this.linhas;
              
    } 

    public EncomendaEficiente clone(){
        return new EncomendaEficiente(this);   
    }

    public String toString(){
    StringBuilder sb = new StringBuilder();
    sb.append("Nome do cliente: ").append(nomCliente)
      .append("\nNumero fiscal: ").append(numFiscal)
      .append("\nMorada: ").append(morada)
      .append("\nNumero do cliente: ").append(numEncomenda)
      .append("\nData da encomenda: ").append(data.toString())
      .append("\nlinhas da encomenda: ").append(linhas.toString());

      return sb.toString();
    } 
    //resolucao do exercicios

    // Entregar :
    //LinhaEncomenda, EncomendaEficiente, TesteEncomenda e diag de classes num zip


}

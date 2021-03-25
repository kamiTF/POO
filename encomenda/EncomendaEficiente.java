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
    public EncomendaEficiente(String nomeCliente, int nFiscal, String nmorada,int nEncomenda,LocalDateTime ndata,ArrayList<LinhaEncomenda> nlinhas){
        this.nomCliente = nomeCliente;
        this.numFiscal = nFiscal;
        this.morada = nmorada;
        this.numEncomenda = nEncomenda;
        this.data = ndata;
        this.setLinhaEncomenda(nlinhas);


    }
    public EncomendaEficiente(EncomendaEficiente e){
        this.nomCliente = e.getNomCliente();
        this.numFiscal = e.getNumFiscal();
        this.morada = e.getMorada();
        this.numEncomenda = e.getNumEncomenda();
        this.data = e.getData();
        this.setLinhaEncomenda(e.getLinhaEncomenda());
    }
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
    
    
    public void setNumFiscal(int nFiscal){
     this.numFiscal = nFiscal;   
    }
    
    public void setMorada(String nmorada ){
     this.morada = nmorada;   
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
    
    public EncomendaEficiente clone(){
        return new EncomendaEficiente(this);   
    }




    //getters setters

    //equals, toString, clone

    //resolucao do exercicios

    // Entregar :
    //LinhaEncomenda, EncomendaEficiente, TesteEncomenda e diag de classes num zip


}

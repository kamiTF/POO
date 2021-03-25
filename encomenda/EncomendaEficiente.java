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
        this.nomCliente = e.getnom;
        this.numFiscal = nFiscal;
        this.morada = nmorada;
        this.numEncomenda = nEncomenda;
        this.data = ndata;
    }

    




    //getters setters

    //equals, toString, clone

    //resolucao do exercicios

    // Entregar :
    //LinhaEncomenda, EncomendaEficiente, TesteEncomenda e diag de classes num zip


}
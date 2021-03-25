package encomenda;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class TesteEncomenda {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);



            EncomendaEficiente teste = new EncomendaEficiente("José Sócrates", 123456789, "Estabelecimento Prisional de Évora", 6, LocalDateTime.now(), new ArrayList<LinhaEncomenda>());
            System.out.println("\nA encomenda foi criada com os seguintes dados: \n" + teste.toString());
            LinhaEncomenda linha1 = new LinhaEncomenda("000001", "Pizza de Peperonni extra queijo", 5, 1, 5, 20);
            teste.adicionaLinha(linha1);
            


            System.out.println("Inserido na linha de encomenda: " + linha1.toString()+"\n");
              LinhaEncomenda linha2 = new LinhaEncomenda("000002", "Apartamento em Paris", 2000000, 1, 0, 90);
              teste.adicionaLinha(linha2);


            System.out.println("" + linha2.toString()+"\n");
            System.out.println("Introduza qual método quer testar: ");
            int alinea = ler.nextInt();
            switch(alinea) {
                            case 2:{ 
                                ler.close();
                                System.out.println("\nO valor de desconto foi "+teste.calculaValorDescontoTotal()+"€.\n");
                                      
                            break;
                            }
                            case 3:{ 
                                ler.close();
                                System.out.println("\nO valor total da encomenda foi "+teste.calculaValorTotal()+"€.\n");
                            break;
                            }
                            case 4:{
                                ler.close();
                                System.out.println("\nVocê deverá receber "+teste.numeroTotalProdutos()+" produtos.\n");
                            break;
                            }
                            case 5:{
                                System.out.println("\nQual é a referência do produto que procura?");
                                String refProduto = ler.next();
                                ler.close();
                                if(teste.existeProdutoEncomenda(refProduto)==true){
                                    System.out.println("O produto que procura existe.\n");
                                }
                                else{
                                   System.out.println("O produto que procura não existe.\n");
                                }

                            break;
                            }
                            case 6:{
                                    System.out.println("\nQual é o código do produto que deseja remover?");
                                    String codProd = ler.next();
                                    System.out.println(codProd);
                                    ler.close();
                                    teste.removeProduto(codProd);
                                    System.out.println("O produto com o código "+codProd+", "+teste.existeProdutoEncomenda(codProd)+" foi removido.\n");
                            break;
                            }
                            default:{
                                    ler.close();
                                    System.out.println("\nEssa opção não existe");
                            break;
                            }
                }
    }
    
}

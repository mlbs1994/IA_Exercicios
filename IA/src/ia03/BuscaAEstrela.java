/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia03;

import ia03.Estacao;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Matheus Levi
 */
public class BuscaAEstrela 
{

    Mapa mapa;
    Estacao estacaoDestino;
    Fila fila = new Fila();
    
    public void inicializarMapa()
    {
        //Criando as estacoes
        ArrayList<Estacao> estacoesCriadas = criarEstacoes();
        
        //Inicializando a tabela heurística
        int[][] tabelaHeuristica = criarHeuristica();
       
        //Carregando o mapa
        mapa = new Mapa(tabelaHeuristica, estacoesCriadas);

    }
    
    private ArrayList<Estacao> criarEstacoes()
    {
        
        Estacao estacao1 = new Estacao("E1", 0);
        Estacao estacao2 = new Estacao("E2", 1);
        Estacao estacao3 = new Estacao("E3", 2);
        Estacao estacao4 = new Estacao("E4", 3);
        Estacao estacao5 = new Estacao("E5", 4);
        Estacao estacao6 = new Estacao("E6", 5);
        Estacao estacao7 = new Estacao("E7", 6);
        Estacao estacao8 = new Estacao("E8", 7);
        Estacao estacao9 = new Estacao("E9", 8);
        Estacao estacao10 = new Estacao("E10" , 9);
        Estacao estacao11 = new Estacao("E11", 10);
        Estacao estacao12 = new Estacao("E12", 11);
        Estacao estacao13 = new Estacao("E13", 12);
        Estacao estacao14 = new Estacao("E14", 13);
        

        //Ligando as estacoes criadas e definindo a cor das linhas (trechos) entre as estações
        estacao1.adicionarVizinhos(new ArrayList<Estacao>(){{add(estacao2);}}, new int[]{11},
                                                                               new String[]{"Azul"});
        estacao2.adicionarVizinhos(new ArrayList<Estacao>(){
                                                             {add(estacao1);}
                                                             {add(estacao3);}
                                                             {add(estacao9);}
                                                             {add(estacao10);};}, new int[]{11, 9, 11, 4},
                                                                                  new String[]{"Azul","Azul","Amarelo","Amarelo"});
        estacao3.adicionarVizinhos(new ArrayList<Estacao>(){
                                                             {add(estacao2);}
                                                             {add(estacao4);}
                                                             {add(estacao9);}
                                                             {add(estacao13);};}, new int[]{9, 7, 10, 19},
                                                                                  new String[]{"Azul","Azul","Vermelho","Vermelho"});
        estacao4.adicionarVizinhos(new ArrayList<Estacao>(){
                                                             {add(estacao3);}
                                                             {add(estacao5);}
                                                             {add(estacao8);}
                                                             {add(estacao13);};}, new int[]{7, 14, 16, 12},
                                                                                  new String[]{"Azul","Azul","Verde","Verde"});
        estacao5.adicionarVizinhos(new ArrayList<Estacao>(){
                                                             {add(estacao4);}
                                                             {add(estacao6);}
                                                             {add(estacao7);}
                                                             {add(estacao8);};}, new int[]{14, 3, 2, 33}, 
                                                                                 new String[]{"Azul","Azul","Amarelo","Amarelo"});
        estacao6.adicionarVizinhos(new ArrayList<Estacao>(){
                                                             {add(estacao5);};}, new int[]{3},
                                                                                 new String[]{"Azul"});
        estacao7.adicionarVizinhos(new ArrayList<Estacao>(){
                                                             {add(estacao5);};}, new int[]{2},
                                                                                 new String[]{"Amarelo"});
        estacao8.adicionarVizinhos(new ArrayList<Estacao>(){
                                                             {add(estacao4);}
                                                             {add(estacao5);}
                                                             {add(estacao9);}
                                                             {add(estacao12);};}, new int[]{16, 33, 10, 7}, 
                                                                                  new String[]{"Verde","Amarelo","Amarelo","Verde"});
        estacao9.adicionarVizinhos(new ArrayList<Estacao>(){
                                                             {add(estacao2);}
                                                             {add(estacao3);}
                                                             {add(estacao8);}
                                                             {add(estacao11);};}, new int[]{11, 10, 10, 14},
                                                                                  new String[]{"Amarelo","Vermelho","Amarelo","Vermelho"});
        estacao10.adicionarVizinhos(new ArrayList<Estacao>(){
                                                             {add(estacao2);};}, new int[]{4},
                                                                                 new String[]{"Amarelo"});
        estacao11.adicionarVizinhos(new ArrayList<Estacao>(){
                                                             {add(estacao9);};}, new int[]{14},
                                                                                 new String[]{"Vermelho"});
        estacao12.adicionarVizinhos(new ArrayList<Estacao>(){
                                                             {add(estacao8);};}, new int[]{7},
                                                                                 new String[]{"Verde"});
        estacao13.adicionarVizinhos(new ArrayList<Estacao>(){
                                                             {add(estacao3);}
                                                             {add(estacao4);}
                                                             {add(estacao14);};}, new int[]{19, 12, 5},
                                                                                  new String[]{"Vermelho","Verde","Verde"});
        estacao14.adicionarVizinhos(new ArrayList<Estacao>(){
                                                             {add(estacao13);};}, new int[]{5}, 
                                                                                  new String[]{"Verde"});
        
        return new ArrayList(){
                               {add(estacao1);}
                               {add(estacao2);}
                               {add(estacao3);}
                               {add(estacao4);}
                               {add(estacao5);}
                               {add(estacao6);}
                               {add(estacao7);}
                               {add(estacao8);}
                               {add(estacao9);}
                               {add(estacao10);}
                               {add(estacao11);}
                               {add(estacao12);}
                               {add(estacao13);}
                               {add(estacao14);}
                                 };
    }
    
    private int[][] criarHeuristica() 
    {
        return new int[][]{
                               {0,11,20,27,40,43,39,28,18,10,18,30,30,32},
                               {11,0,9,16,29,32,28,19,11,4,17,23,21,24},
                               {20,9,0,7,20,22,19,15,10,11,21,21,13,18},
                               {27,16,7,0,13,16,12,13,13,18,26,21,11,17},
                               {40,29,20,13,0,3,2,21,25,31,38,27,16,20},
                               {43,32,22,16,3,0,4,23,28,33,41,30,17,20},
                               {39,28,19,12,2,4,0,22,25,29,38,28,13,17},
                               {28,19,15,13,21,23,22,0,9,22,18,7,25,30},
                               {18,11,10,13,25,28,25,9,0,13,12,12,23,28},
                               {10,4,11,18,31,33,29,22,13,0,20,27,20,23},
                               {18,17,21,26,38,41,38,18,12,20,0,15,035,39},
                               {30,23,21,21,27,30,28,7,12,27,15,0,31,37},
                               {30,21,13,11,16,17,13,25,23,20,35,31,0,5},
                               {32,24,18,17,20,20,17,30,28,23,39,37,5,0}
                               };
                               
    }
    
    public Mapa getMapa() {
        return mapa;
    }

    public Estacao getEstacaoDestino() {
        return estacaoDestino;
    }

    public void setEstacaoDestino(Estacao estacaoDestino) {
        this.estacaoDestino = estacaoDestino;
    }
    
    
    public boolean testeObjetivo(No noCorrente)
    {
        return (noCorrente.getEstacao().getNomeEstacao().equals(this.estacaoDestino.getNomeEstacao()));
    }
    
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        String estacaoOrigem="";
        String estacaoDestino="";
        
        BuscaAEstrela bae = new BuscaAEstrela();
        
        bae.inicializarMapa();
        
        System.out.println("----------+------------METRO DE PARIS----------------------------------\n");
        System.out.println("Esse programa encontra o melhor caminho entre uma estação"
                                                             + " de origem e uma estação de destino\n");
        
        System.out.println("Digite o nome da estação de origem (E1-E14)");
        estacaoOrigem = input.nextLine();
        
        System.out.println("Digite o nome da estação de destino (E1-E14)");
        estacaoDestino = input.nextLine();
        
        System.out.println("\nEstação de Origem = "+estacaoOrigem);
        System.out.println("Estação de Destino = "+estacaoDestino);
        
        System.out.println("\n");
        
        //Converter as Strings
        bae.estacaoDestino = bae.mapa.getEstacaoPorNome(estacaoDestino);
        
        No noRaiz = new No(bae.mapa.getEstacaoPorNome(estacaoOrigem), bae.mapa, bae.estacaoDestino);
        bae.fila.adicionarNaFila(noRaiz);
        
        
        boolean encontrouSolucao=false;
        No noSolucao = null;
        No noCorrente; //Não declarar variaveis em loops
        int contador=0;
        
        do {
            noCorrente = bae.fila.removerPrimeiro();
            
            //Teste Objetivo
            encontrouSolucao = bae.testeObjetivo(noCorrente);
            
            System.out.println("encontrouSolucao = "+encontrouSolucao);
            System.out.println("contador = "+contador);
            
            if (encontrouSolucao == false) {
                bae.fila.adicionarNaFila(noCorrente.gerarFilhos());
            } else {
                noSolucao = noCorrente;
            }
        } while (encontrouSolucao == false);
      
        System.out.println("SOLUÇÃO ENCONTRADA");
        System.out.println("Imprimindo caminho de solução...\n\n");

        bae.imprimirCaminhoSolucao(noSolucao);
    }

    private void imprimirCaminhoSolucao(No noSolucao)
    {
         System.out.println("CUSTO = " + noSolucao.getCusto());

        System.out.println("CAMINHO DA SOLUÇÃO\n");

          //Imprimindo tabuleiro do no solução

          No noTemporario = noSolucao;
          
          while(noTemporario!=null)
          {
              if(noTemporario.getNoPai()!=null)
              {
                System.out.print(noTemporario.getEstacao().getNomeEstacao()+" <- ");
              }
              else
              {
                System.out.print(noTemporario.getEstacao().getNomeEstacao());
              }
              
              noTemporario = noTemporario.getNoPai();
          }
          
          System.out.println("\nTempo total = "+noSolucao.getCusto()+ " minutos");
    }
}

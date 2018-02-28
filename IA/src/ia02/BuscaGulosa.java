/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Matheus Levi
 */

/*Heurística: Número de conflitos por posição do tabuleiro
    
 Essa heurística funcionará do seguinte modo
    
 Ela informará o numero de conflitos para cada posicao do tabuleiro com a configuração corrente das rainhas
    
 Ex:  Dado uma coluna da matriz que contém os respectivos numeros de ataques para cada posição:
        
 3
 3
 3
 2
 2
 1
 0
 1
 1        
    
 Ele selecionará a rainha que está na coluna e moverá ela na posição onde não se atestou o menor numero de ataques 
    
 


*/

//Heuristica deve ir para o nó
// heuristia = numero total de ataques

package ia02;

import java.util.Scanner;

public class BuscaGulosa {

    Fila fila = new Fila();

    private boolean testeObjetivo(No noCorrente)
    {
        return noCorrente.getNumeroAtaques()==0;
    }

    
    private void imprimirCaminhoSolucao(No noSolucao) {
        System.out.println("CUSTO = " + noSolucao.getCusto());

        System.out.println("CAMINHO DA SOLUÇÃO\n");

          //Imprimindo tabuleiro do no solução

          No noTemporario = noSolucao;
          
          while(noTemporario!=null)
          {
              noTemporario.imprimirTabuleiro();
              
              System.out.println("\n\n");
              
              noTemporario = noTemporario.getNoPai();
          }
    }

    public static void main(String args[]) {

        BuscaGulosa bg = new BuscaGulosa();

        int posicoes[] = {0, 0, 0, 0, 0, 0, 0, 0};
        Scanner in = new Scanner(System.in);
        boolean encontrouSolucao;

        System.out.println("Problema das oito rainhas\n");

        System.out.println("Configurar o estado inicial");
        
        
        
        for(int cont=0; cont <= 7; cont++)
        {
             System.out.println("Digite a posicao(linha) da rainha na " + (cont + 1) + " coluna do tabuleiro");
            
             posicoes[cont] = in.nextInt();
             
             for (int i = 0; i < cont; i++) 
             {
                 if(posicoes[cont]==posicoes[i])
                 {
                     cont--;
                 }
             }
        }

        No no = new No(posicoes);
        bg.fila.adicionarNaFila(no);

        No noSolucao = null;
        No noCorrente; //Não declarar variaveis em loops

        do {
            noCorrente = bg.fila.removerPrimeiro();
            noCorrente.imprimirTabuleiro();
            
            //Teste Objetivo
            encontrouSolucao = bg.testeObjetivo(noCorrente);
            
            if (encontrouSolucao == false) {
                bg.fila.adicionarNaFila(noCorrente.gerarFilhos());
            } else {
                noSolucao = noCorrente;
            }
        } while (encontrouSolucao == false);

        System.out.println("SOLUÇÃO ENCONTRADA");
        System.out.println("Imprimindo caminho de solução...\n\n");

        bg.imprimirCaminhoSolucao(noSolucao);

    }
}


 /*for(int k=0; k<=7; k++)
           {
               int numPosSubjacentes = this.posicoesMinimoAtaques[k];
               int[] coluna = new int[7-numPosSubjacentes];

               System.out.println("new int -> "+(7-numPosSubjacentes));
               System.out.println("l = "+numPosSubjacentes+"; l<=7; l++");
               for(int l=0; l<coluna.length; l++)
               {
                  System.out.println("l = "+l);
                  coluna[l] = this.numeroAtaquesPosicao[numPosSubjacentes+(l+1)][k];
                  System.out.println("coluna["+l+"] = "+coluna[l]);
               }

               for(int o=0;o<coluna.length;o++)
               {
                   System.out.print(coluna[o]+" ");
               }
               
               System.out.println();
               
               if(coluna.length>0)
               {
                   int candidatoPosMin = 0;
                   int aux=coluna[0];

                   for(int m=0;m<coluna.length;m++)
                   {
                      // System.out.println(aux+" > "+coluna[m]+" ?");
                       if(aux>coluna[m])
                       {
                            //System.out.println("Sim");
                            aux = coluna[m];
                           // System.out.println("aux = "+aux);
                            candidatoPosMin = m;
                            // System.out.println("candidatoMinPos = "+candidatoPosMin);
                       }
                   }

                     //System.out.println("Final candidatoMinPos = "+candidatoPosMin);
                   this.posicoesMinimoAtaques[k] = candidatoPosMin;

                   System.out.println("minimoAtaquesAtualizado");

                   for(int p=0;p<this.posicoesMinimoAtaques.length;p++)
                   {
                       System.out.print(this.posicoesMinimoAtaques[p]+" ");
                   }

                   System.out.println();
               }
               

               }*/

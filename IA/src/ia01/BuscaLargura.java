package ia01;

import java.util.ArrayList;
import java.util.HashMap;

/*
     
 PROBLEMA DO QUEBRA CABEÇA DE OITO PEÇAS

 Descrição: Um tabuleiro 3x3 (sendo que uma casa é vázia) precisa se dispor de certa
 forma que a primeira casa seja vazia e que as casas precedentes apresentem uma ordenação
 crescente

 Estados
        
 ->Estado inicial: Qualquer estado pode ser designado como estado inicial
 ->Estado Objetivo: Primeira casa vazia e demais casas em ordem crescente

 Função sucessor
    
 -> Gera os estados válidos que resultam da tentativa de executar as três ações. O
 espaço vazio se desloca
 - Esquerda
 - Direita
 - Acima 
 - Abaixo

 Teste de objetivo

 -> Verifica se o estado corrente corresponde à configuração de objetivo (ver estado
 objetivo)
           
 Custo de caminho

 -> Cada passo custa 1, e assim o custo do caminho é o número de passos do caminho

 -> Pseudo-código
    
 listaVisitados;
 fila.add(estadoInicial);
    
 do
 {
 no = fila.removeFirst();
 achou = ehObjetivo(no);
    
 if(! achou && ! listaVisitados.contains(no))
 {
 expandeNos(Fila, no);
 listaVisitados.add(no);
 }

 }while(!(achou || fila.empty()));
    
 if(achou)
 {
 imprimirSolucao;
 }
 else
 {
 "Solução impossível";
 }
    
 */
public class BuscaLargura {

    static int[][] estadoObjetivo = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};

    Fila fila = new Fila();
    No noRaiz = new No();
    //ArrayList<No> listaNosVisitados = new ArrayList();
    HashMap<String,No> listaVisitados = new HashMap();
    boolean achou = false;
    int contadorCusto = 0;

    //Teste Objetivo
    public static boolean ehObjetivo(No noCorrente) {
        boolean ok = true;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int x = noCorrente.getTabuleiro()[i][j];
                int y = estadoObjetivo[i][j];

               // System.out.println("noCorrente["+i+"]["+j+"] - "+x+" = "
                //       + "estadoObjetivo["+i+"]["+j+"] - "+y+" ?");
                if (x != y) {
                    //System.out.println("Falso para "+i+","+j);
                    ok = false;
                    break;
                } else {
                    // System.out.println("OK");
                }

            }
        }

        return ok;

    }

    /*Analisa o nó corrente para buscar a solução do problema. 
     Cria nós filhos que correspondem a possiveis estados sucessores do nó corrente
     */
    public ArrayList<No> expandirNos(Fila fila, No noCorrente) {
        ArrayList novosNos = new ArrayList();

        No noFilhoCima;
        No noFilhoBaixo;
        No noFilhoDir;
        No noFilhoEsq;
        
        //Mover cima = [x+1][y]
        //Mover abaixo = [x-1][y]
        //Mover esquerda = [x][y+1]
        //Mover direita = [x][y-1]
        
        if (noCorrente.getEspacoBrancoX() == 0 && noCorrente.getEspacoBrancoY() == 0) {
            
            noFilhoCima = this.moverCima(noCorrente);
            noFilhoEsq = this.moverEsquerda(noCorrente);

            novosNos.add(noFilhoCima); // Mover cima
            novosNos.add(noFilhoEsq); //Mover esquerda,
            noCorrente.setNoFilhos(novosNos);

            fila.adicionarNaFila(noFilhoEsq);
            fila.adicionarNaFila(noFilhoCima);
        }
        if (noCorrente.getEspacoBrancoX() == 0 && noCorrente.getEspacoBrancoY() == 1) {
            noFilhoCima = this.moverCima(noCorrente);
            noFilhoDir = this.moverDireita(noCorrente);
            noFilhoEsq = this.moverEsquerda(noCorrente);

            novosNos.add(noFilhoCima);
            novosNos.add(noFilhoDir);
            novosNos.add(noFilhoEsq);

            noCorrente.setNoFilhos(novosNos);

            fila.adicionarNaFila(noFilhoCima);
            fila.adicionarNaFila(noFilhoDir);
            fila.adicionarNaFila(noFilhoEsq);

        }
        if (noCorrente.getEspacoBrancoX() == 0 && noCorrente.getEspacoBrancoY() == 2) {
            noFilhoCima = this.moverCima(noCorrente);
            noFilhoDir = this.moverDireita(noCorrente);

            novosNos.add(noFilhoCima);
            novosNos.add(noFilhoDir);

            noCorrente.setNoFilhos(novosNos);

            fila.adicionarNaFila(noFilhoCima);
            fila.adicionarNaFila(noFilhoDir);
        }
        if (noCorrente.getEspacoBrancoX() == 1 && noCorrente.getEspacoBrancoY() == 0) {
            noFilhoEsq = this.moverEsquerda(noCorrente);
            noFilhoCima = this.moverCima(noCorrente);
            noFilhoBaixo = this.moverBaixo(noCorrente);

            novosNos.add(noFilhoEsq);
            novosNos.add(noFilhoCima);
            novosNos.add(noFilhoBaixo);

            noCorrente.setNoFilhos(novosNos);

            fila.adicionarNaFila(noFilhoEsq);
            fila.adicionarNaFila(noFilhoCima);
            fila.adicionarNaFila(noFilhoBaixo);
        }
        if (noCorrente.getEspacoBrancoX() == 1 && noCorrente.getEspacoBrancoY() == 1) {
            noFilhoCima = this.moverCima(noCorrente);
            noFilhoDir = this.moverDireita(noCorrente);
            noFilhoBaixo = this.moverBaixo(noCorrente);
            noFilhoEsq = this.moverEsquerda(noCorrente);

            novosNos.add(noFilhoCima);
            novosNos.add(noFilhoDir);
            novosNos.add(noFilhoBaixo);
            novosNos.add(noFilhoEsq);

            noCorrente.setNoFilhos(novosNos);

            fila.adicionarNaFila(noFilhoCima);
            fila.adicionarNaFila(noFilhoDir);
            fila.adicionarNaFila(noFilhoBaixo);
            fila.adicionarNaFila(noFilhoEsq);
        }
        if (noCorrente.getEspacoBrancoX() == 1 && noCorrente.getEspacoBrancoY() == 2) {
            noFilhoBaixo = this.moverBaixo(noCorrente);
            noFilhoCima = this.moverCima(noCorrente);
            noFilhoDir = this.moverDireita(noCorrente);

            novosNos.add(noFilhoCima);
            novosNos.add(noFilhoBaixo);
            novosNos.add(noFilhoDir);

            noCorrente.setNoFilhos(novosNos);

            fila.adicionarNaFila(noFilhoCima);
            fila.adicionarNaFila(noFilhoBaixo);
            fila.adicionarNaFila(noFilhoDir);

        }
        if (noCorrente.getEspacoBrancoX() == 2 && noCorrente.getEspacoBrancoY() == 0) {
            noFilhoBaixo = this.moverBaixo(noCorrente);
            noFilhoEsq = this.moverEsquerda(noCorrente);

            novosNos.add(noFilhoBaixo);
            novosNos.add(noFilhoEsq);

            noCorrente.setNoFilhos(novosNos);

            fila.adicionarNaFila(noFilhoBaixo);
            fila.adicionarNaFila(noFilhoEsq);
        }
        if (noCorrente.getEspacoBrancoX() == 2 && noCorrente.getEspacoBrancoY() == 1) {
            noFilhoBaixo = this.moverBaixo(noCorrente);
            noFilhoDir = this.moverDireita(noCorrente);
            noFilhoEsq = this.moverEsquerda(noCorrente);

            novosNos.add(noFilhoBaixo);
            novosNos.add(noFilhoDir);
            novosNos.add(noFilhoEsq);

            noCorrente.setNoFilhos(novosNos);

            fila.adicionarNaFila(noFilhoBaixo);
            fila.adicionarNaFila(noFilhoDir);
            fila.adicionarNaFila(noFilhoEsq);
        }
        if (noCorrente.getEspacoBrancoX() == 2 && noCorrente.getEspacoBrancoY() == 2) {
            noFilhoBaixo = this.moverBaixo(noCorrente);
            noFilhoDir = this.moverDireita(noCorrente);

            novosNos.add(noFilhoBaixo);
            novosNos.add(noFilhoDir);

            noCorrente.setNoFilhos(novosNos);

            fila.adicionarNaFila(noFilhoBaixo);
            fila.adicionarNaFila(noFilhoDir);
        }

        return novosNos;
    }

      //Funçoes sucessoras: Devem retornar os estados sucessores
    public No moverDireita(No noCorrente) {
       
        return new No(noCorrente,noCorrente.getEspacoBrancoX(),noCorrente.getEspacoBrancoY()-1);
    }

    public No moverEsquerda(No noCorrente) {

        return new No(noCorrente,noCorrente.getEspacoBrancoX(),noCorrente.getEspacoBrancoY()+1);
    }

    public No moverBaixo(No noCorrente) {
       
        return new No(noCorrente,noCorrente.getEspacoBrancoX()-1,noCorrente.getEspacoBrancoY());
    }

    public No moverCima(No noCorrente) {
             
        return new No(noCorrente,noCorrente.getEspacoBrancoX()+1,noCorrente.getEspacoBrancoY());
    }

    //Imprimir a solução
    private void imprimirSolucao(No noSolucao)
    {
        System.out.println("SOLUÇÃO ENCONTRADA!\n___________________________");
        System.out.println("\nCusto = " + this.contadorCusto + "\n");

        System.out.println("CAMINHO DA SOLUÇÃO\n");

          //Imprimindo tabuleiro do no solução
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(noSolucao.getTabuleiro()[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\n");
        
        No noCorrenteSolucao = noSolucao.getNoPai();
          //Imprimindo os nós pai do nó solução
        while (noCorrenteSolucao != null)
        {
            
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(noCorrenteSolucao.getTabuleiro()[i][j] + " ");
                }
                System.out.println();
            }
           
            System.out.println("\n");
            
            try
            {
                noCorrenteSolucao = noCorrenteSolucao.getNoPai();
            }catch(NullPointerException e)
            {
                break;
            }    
            
        }
            

    }

    public void executarIA() {
        
        System.out.println("PUZZLE DE 9 PEÇAS");
        
        this.fila.adicionarNaFila(noRaiz);
        No noCorrente;

        System.out.println("Buscando solução...");
        boolean ehIgual=false;

        
        do {
        
            noCorrente = this.fila.removerPrimeiro();

           /* for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(noCorrente.getTabuleiro()[i][j] + " ");
                }
                System.out.println();
            }*/

            achou = ehObjetivo(noCorrente);
            ehIgual = this.listaVisitados.containsKey(noCorrente.gerarChaveTabuleiro());
            //ehIgual = this.listaNosVisitados.contains(noCorrente);
            
            
            
            if (!this.achou && !ehIgual) {
                noCorrente.setNoFilhos(expandirNos(fila, noCorrente));
                //this.listaNosVisitados.put(contadorCusto, noCorrente);
                this.listaVisitados.put(noCorrente.gerarChaveTabuleiro(),noCorrente);
                

                
                
                

            }

        } while (!(this.achou || this.fila.estaVazio()));

        if (this.achou) {
            imprimirSolucao(noCorrente);
        } else {
            System.out.println("Solução não encontrada");
        }

    }

    public static void main(String[] args) {
        BuscaLargura ia = new BuscaLargura();

        ia.executarIA();
    }

}

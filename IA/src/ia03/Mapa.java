/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia03;

import java.util.ArrayList;

/**
 *
 * @author Matheus Levi
 */
public class Mapa
{
    public ArrayList<Estacao> estacoes;
    public int[][] distanciaLinhaReta; //Tabela Heurística
    private final int NUM_ESTACOES = 14;
    private final int VELOCIDADE_TREM = 30;
    
    public Mapa(int[][] distancias, ArrayList<Estacao> estacoesCriadas)
    {
        estacoes = new ArrayList();
        distanciaLinhaReta = new int[NUM_ESTACOES][NUM_ESTACOES];
        carregarEstacoes(estacoesCriadas);
        inicializarTabelaHeuristica(distancias);
    }

    private void carregarEstacoes(ArrayList<Estacao> estacoesCriadas)
    {
        Estacao estacao;
        
        for(int i=0; i<NUM_ESTACOES; i++)
        {
            estacoes.add(estacoesCriadas.get(i));
        }
    }

    private void inicializarTabelaHeuristica(int[][] distancias)
    {
        for(int i=0; i<NUM_ESTACOES; i++)
        {
             distanciaLinhaReta[i] = distancias[i];
        }
       
    }
    
    public Estacao getEstacaoPorNome(String nome)
    {
       Estacao estacaoSelecionada=null;
       
       for(int i=0;i<NUM_ESTACOES;i++)
       {
           if(estacoes.get(i).nomeEstacao.equals(nome))
           {
               estacaoSelecionada = estacoes.get(i);
               break;
           }
       }
       
       return estacaoSelecionada;
    }

    public int[][] getDistanciaLinhaReta() {
        return distanciaLinhaReta;
    }

    public int getNUM_ESTACOES() {
        return NUM_ESTACOES;
    }

    public int getVELOCIDADE_TREM() {
        return VELOCIDADE_TREM;
    }
    
    

    public ArrayList<Estacao> getEstacoes() {
        return estacoes;
    }
    
    
    
    
    
    

}

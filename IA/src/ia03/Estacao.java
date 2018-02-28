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
public class Estacao
{
    int id;
    
    public ArrayList<Estacao> estacoesVizinhas;
    public String[] corLinhaTrechos;
    public int[] distanciaEstacoesVizinhas;
    public int[] custoTempoVizinhos; 
    public String nomeEstacao;
    
    public Estacao(String nome, int idEstacao)
    {
        nomeEstacao = nome;
        id = idEstacao;
    }

    public String getNomeEstacao() {
        return nomeEstacao;
    }  

    public ArrayList<Estacao> getEstacoesVizinhas() {
        return estacoesVizinhas;
    }

    public String[] getCorLinha() {
        return corLinhaTrechos;
    }

    public int[] getDistanciaEstacoesVizinhas() {
        return distanciaEstacoesVizinhas;
    }
    
    public void adicionarVizinhos(ArrayList<Estacao> vizinhos, int[] distancias, String[] corLinha)
    {
        estacoesVizinhas = new ArrayList();
        distanciaEstacoesVizinhas = new int[distancias.length];
        corLinhaTrechos = new String[corLinha.length];
        
        for(int i=0; i<vizinhos.size();i++)
        {
            estacoesVizinhas.add(vizinhos.get(i));
            distanciaEstacoesVizinhas[i] = distancias[i];
            corLinhaTrechos[i] = corLinha[i];
        }
        
    }

    public int getId() {
        return id;
    }

    public String[] getCorLinhaTrechos() {
        return corLinhaTrechos;
    }

    public int[] getCustoTempoVizinhos() {
        return custoTempoVizinhos;
    }
    
    
    
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia02;

import java.util.ArrayList;

/**
 *
 * @author Matheus Levi
 */
public class No 
{
 
    private int posicoesRainhas[];
    private int numeroAtaques; //Heurística
    private int custo;
    private No noPai;
    private ArrayList<No> noFilhos;

    public No(int posicoes[]) 
    {
        inicializar(posicoes);
        this.custo = 0;
       
    }
    
    public No(int posicoes[], No noPai)
    {
        inicializar(posicoes);
        this.noPai = noPai;
        this.custo = this.noPai.custo+1;
    }
    
    private void calcularNumAtaques()
    {
        for(int i=0;i<posicoesRainhas.length;i++)
        {
            for(int j=i+1; j<posicoesRainhas.length;j++)
            {
                if(Math.abs(posicoesRainhas[i] - posicoesRainhas[j])
                        == Math.abs(i-j))
                        {
                            this.numeroAtaques++;
                        }
            }
        }
    }
    
    public ArrayList<No> gerarFilhos()
    {
        this.noFilhos = new ArrayList();
        
        int posicoesRainhasFilhos[];
        
        for(int i=0; i<posicoesRainhas.length; i++)
        {
            for(int j=i+1; j<posicoesRainhas.length; j++)
            {
                posicoesRainhasFilhos = getCopiaPosicoesRainhas(this.posicoesRainhas);
                int aux =  posicoesRainhasFilhos[i];
                posicoesRainhasFilhos[i] =  posicoesRainhasFilhos[j];
                posicoesRainhasFilhos[j] = aux;
                noFilhos.add(new No(posicoesRainhasFilhos,this));
            }
            
        }
        
        return noFilhos;
    }
    
    public void imprimirTabuleiro()
    {
        System.out.println();
        
        for(int i=0; i<posicoesRainhas.length;i++)
        {
            for(int j=0; j<posicoesRainhas.length;j++)
            {
                if(posicoesRainhas[i]==j)
                {
                    System.out.print("1 ");
                }
                else
                {
                    System.out.print("0 ");
                }
            }
            
            System.out.println();
            
        }
        
        System.out.println("Número de Ataques = "+numeroAtaques);
        System.out.print("Posicoes Rainhas = ");
        for(int k=0;k<posicoesRainhas.length;k++)
        {
            System.out.print(posicoesRainhas[k]+" ");
        }
        System.out.println("Custo = "+custo);
        System.out.println();
    }
    
    public int[] getPosicoesRainhas() {
        return posicoesRainhas;
    }

    public void setPosicoesRainhas(int[] posicoesRainhas) {
        this.posicoesRainhas = posicoesRainhas;
    }
    
    public No getNoPai() {
        return noPai;
    }

    public void setNoPai(No noPai) {
        this.noPai = noPai;
    }

    public int getNumeroAtaques() {
        return numeroAtaques;
    }

    public void setNumeroAtaques(int numeroAtaques) {
        this.numeroAtaques = numeroAtaques;
    }

    public ArrayList<No> getNoFilhos() {
        return noFilhos;
    }

    public void setNoFilhos(ArrayList<No> noFilhos) {
        this.noFilhos = noFilhos;
    }

    public int getCusto() {
        return custo;
    }

    public void setCusto(int custo) {
        this.custo = custo;
    }
    
    
    
    
    
    public int[] getCopiaPosicoesRainhas(int posicoes[])
    {
        int[] copiaPosRainhas = {0,0,0,0,0,0,0,0};

       
        for(int i=0;i<posicoes.length;i++)
        {
            copiaPosRainhas[i] = posicoes[i];
        }
           
        return copiaPosRainhas;
    }

    /*@Override
    */

    private void inicializar(int[] posicoes)
    {
        //Inicializar No
        this.posicoesRainhas = getCopiaPosicoesRainhas(posicoes);
        this.numeroAtaques = 0;

        
        //Calcular Heurística
        calcularNumAtaques();
    }
    
    


  
   

    
    
    
    
}

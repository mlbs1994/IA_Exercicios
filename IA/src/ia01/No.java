/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia01;

import java.util.ArrayList;
import java.util.Arrays;

public class No {

    private No noPai;
    private int[][] tabuleiro;
    private ArrayList<No> noFilhos;
    private int espacoBrancoX;
    private int espacoBrancoY;

    //Construtor para o Nó Raiz
    public No() { 
        this.tabuleiro = new int[3][3];
        this.noFilhos = new ArrayList();
        setEstadoInicial();
    }
    
  
    //Construtor para o nos descendentes
    public No(No noPai, int espacoBrancoX, int espacoBrancoY) {
        this.noPai = noPai;
        this.tabuleiro = new int[3][3];
    
        for (int i = 0; i < 3; i++) {
            System.arraycopy(this.noPai.getTabuleiro()[i], 0, this.tabuleiro[i], 0, 3);
            
        }
        
        this.tabuleiro[espacoBrancoX][espacoBrancoY] = 0;
        this.tabuleiro[noPai.getEspacoBrancoX()][noPai.getEspacoBrancoY()] = noPai.getTabuleiro()[espacoBrancoX][espacoBrancoY]; 
        
        this.noFilhos = new ArrayList();
        this.espacoBrancoX = espacoBrancoX;
        this.espacoBrancoY = espacoBrancoY;
    }
    
    

    public void setEstadoInicial() {

        this.tabuleiro[0][0] = 6;
        this.tabuleiro[0][1] = 4;
        this.tabuleiro[0][2] = 2;

        this.tabuleiro[1][0] = 8;
        this.tabuleiro[1][1] = 1;
        this.tabuleiro[1][2] = 3;

        this.tabuleiro[2][0] = 7;
        this.tabuleiro[2][1] = 5;
        this.tabuleiro[2][2] = 0;

        this.espacoBrancoX = 2;
        this.espacoBrancoY = 2;

        /*
         4  2  6
         8  1  3
         7  5 
        
         2,2
         */
    }

    private int[][] getCopiaTabuleiro() {
        int[][] copiaTabuleiro = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                copiaTabuleiro[i][j] = this.getTabuleiro()[i][j];
            }
        }

        return copiaTabuleiro;
    }

    public No getNoPai() {
        return noPai;
    }

    public ArrayList<No> getNoFilhos() {
        return noFilhos;
    }

    public void setNoFilhos(ArrayList<No> noFilhos) {
        this.noFilhos = noFilhos;
    }

    public int[][] getTabuleiro() {
        return tabuleiro;
    }

    public int getEspacoBrancoX() {
        return espacoBrancoX;
    }

    public int getEspacoBrancoY() {
        return espacoBrancoY;
    }
    
    @Override
    public boolean equals(Object no) {
        
        if(!(no instanceof No))
        {
            return false;
        }
        
        No noTemp = (No) no;

        boolean ok = true;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int x = noTemp.getTabuleiro()[i][j];
                int y = this.getTabuleiro()[i][j];

                if (x != y) {
            
                    ok = false;
                    break;
                } else {
        
                }

            }
        }

        return ok;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Arrays.deepHashCode(this.tabuleiro);
        return hash;
    }

    String gerarChaveTabuleiro()
    {
        String chave="";
        
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                chave = chave + this.getTabuleiro()[i][j];
            }
        }
        
        return chave;
    }
    
    
    
   

}

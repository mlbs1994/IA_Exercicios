/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia03;

import ia02.*;
import java.util.ArrayList;
import java.util.Collections;



public class Fila 
{
    
    private ArrayList<No> fila;
    
    public Fila()
    {
        this.fila = new ArrayList();
    }
    
    public void adicionarNaFila(No noAdicionado)
    {
        this.fila.add(noAdicionado);
    }
    
    public void adicionarNaFila(ArrayList<No> nos)
    {
        
        for(int i=0; i<nos.size();i++)
        {
            this.fila.add(nos.get(i));
        }
        
        Collections.sort(this.fila, new Comparador());
       
    }
    
    public No removerPrimeiro()
    {
        No primeiroNo = this.fila.get(0);
        this.fila.remove(0);
        return primeiroNo;
    }
    
    public boolean estaVazio()
    {
        return this.fila.isEmpty();
    }
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia01;

import java.util.ArrayList;



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


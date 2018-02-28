/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia03;

import ia02.*;
import java.util.Comparator;

/**
 *
 * @author Matheus Levi
 */
public class Comparador implements Comparator<No>{

    @Override
    public int compare(No no1, No no2) {
        return no1.getCustoHeuristica()- no2.getCustoHeuristica();
    }

  
}

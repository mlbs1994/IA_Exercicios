/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia03;

import ia02.*;
import java.util.ArrayList;

/**
 *
 * @author Matheus Levi
 */
public class No {

    private Estacao estacao;
    private Estacao estacaoDestino;
    private int custo;
    private No noPai;
    private ArrayList<No> noFilhos;
    String corLinha = "";

    int[] custoTotalVizinhos;

    Mapa mapa;

    public No(Estacao e, Mapa m, Estacao ed) {
        estacao = e;
        estacaoDestino = ed;
        mapa = m;
        custo = 0;
        this.noFilhos = new ArrayList();
    }

    public No(Estacao e, No np, int custoTotal, String cor) {
        estacao = e;
        noPai = np;
        estacaoDestino = np.getEstacaoDestino();
        mapa = np.getMapa();
        custo = np.custo + custoTotal;
        corLinha = cor;
        this.noFilhos = new ArrayList();
    }

    public ArrayList<No> gerarFilhos() {
        custoTotalVizinhos = new int[estacao.estacoesVizinhas.size()];
        int distanciaTrecho = 0;
        int idEstacaoCorrente = estacao.getId();
        int idEstacaoDestino = estacaoDestino.getId();
        No noFilhoCorrente;
        String corLinhaVizinho;

        for (int i = 0; i < estacao.estacoesVizinhas.size(); i++) {
            if (!(noPai != null && estacao.getNomeEstacao().equals(noPai.estacao.getNomeEstacao()))) {

                distanciaTrecho = (estacao.distanciaEstacoesVizinhas[i]);
                corLinhaVizinho = estacao.corLinhaTrechos[i]; //Essa linha ocorre o erro

                custoTotalVizinhos[i] = calcularTempoTrecho(distanciaTrecho, corLinhaVizinho);

                noFilhoCorrente = new No(estacao.estacoesVizinhas.get(i),
                        this, custoTotalVizinhos[i],
                        corLinhaVizinho);

                this.noFilhos.add(noFilhoCorrente);
            }

        }

        return noFilhos;
    }

    private int calcularTempoTrecho(int distanciaTrecho, String corLinha) {

        if (this.corLinha.equals(corLinha) || this.corLinha.equals("")) {
            return (60 * distanciaTrecho) / mapa.getVELOCIDADE_TREM();
        } else {
            return ((60 * distanciaTrecho) / mapa.getVELOCIDADE_TREM()) + 5;
        }

    }

    private int calcularTempoTrecho(int distanciaTrecho) {
        return (60 * distanciaTrecho) / mapa.getVELOCIDADE_TREM();

    }

    public No getNoPai() {
        return noPai;
    }

    public void setNoPai(No noPai) {
        this.noPai = noPai;
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

    public int getCustoHeuristica() {
        return custo
                + this.calcularTempoTrecho(mapa.getDistanciaLinhaReta()[estacao.getId()][estacaoDestino.getId()]);
    }

    public void setCusto(int custo) {
        this.custo = custo;
    }

    public Estacao getEstacao() {
        return estacao;
    }

    public Estacao getEstacaoDestino() {
        return estacaoDestino;
    }

    public int[] getCustoTotalVizinhos() {
        return custoTotalVizinhos;
    }

    public Mapa getMapa() {
        return mapa;
    }

    public String getCorLinha() {
        return corLinha;
    }

}

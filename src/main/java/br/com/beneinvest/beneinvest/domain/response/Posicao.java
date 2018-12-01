package br.com.beneinvest.beneinvest.domain.response;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Posicao {

    private List<PosicaoPorAtivo> listaPosicaoPorAtivos = new ArrayList<>();

    private BigDecimal lucroPrejuizo = new BigDecimal(0);

    private BigDecimal valorInvestido = new BigDecimal(0);

    private BigDecimal valorAtual = new BigDecimal(0);

    public List<PosicaoPorAtivo> getListaPosicaoPorAtivos() {
        return listaPosicaoPorAtivos;
    }

    public void setListaPosicaoPorAtivos(List<PosicaoPorAtivo> listaPosicaoPorAtivos) {
        this.listaPosicaoPorAtivos = listaPosicaoPorAtivos;
    }

    public BigDecimal getLucroPrejuizo() {
        return lucroPrejuizo;
    }

    public void setLucroPrejuizo(BigDecimal lucroPrejuizo) {
        this.lucroPrejuizo = lucroPrejuizo;
    }

    public BigDecimal getValorInvestido() {
        return valorInvestido;
    }

    public void setValorInvestido(BigDecimal valorInvestido) {
        this.valorInvestido = valorInvestido;
    }

    public BigDecimal getValorAtual() {
        return valorAtual;
    }

    public void setValorAtual(BigDecimal valorAtual) {
        this.valorAtual = valorAtual;
    }
}

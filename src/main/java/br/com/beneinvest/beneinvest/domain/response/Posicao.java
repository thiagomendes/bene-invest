package br.com.beneinvest.beneinvest.domain.response;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Posicao {

    private List<PosicaoPorAtivo> listaPosicaoPorAtivos = new ArrayList<>();

    private BigDecimal lucroPrejuizo = BigDecimal.ZERO;

    private BigDecimal valorInvestido = BigDecimal.ZERO;

    private BigDecimal valorAtual = BigDecimal.ZERO;

    public List<PosicaoPorAtivo> getListaPosicaoPorAtivos() {
        return listaPosicaoPorAtivos;
    }

    public void setListaPosicaoPorAtivos(List<PosicaoPorAtivo> listaPosicaoPorAtivos) {
        this.listaPosicaoPorAtivos = listaPosicaoPorAtivos;
    }

    public BigDecimal getLucroPrejuizo() {
        return lucroPrejuizo.setScale(2, BigDecimal.ROUND_UP);
    }

    public void setLucroPrejuizo(BigDecimal lucroPrejuizo) {
        this.lucroPrejuizo = lucroPrejuizo;
    }

    public BigDecimal getValorInvestido() {
        return valorInvestido.setScale(2, BigDecimal.ROUND_UP);
    }

    public void setValorInvestido(BigDecimal valorInvestido) {
        this.valorInvestido = valorInvestido;
    }

    public BigDecimal getValorAtual() {
        return valorAtual.setScale(2, BigDecimal.ROUND_UP);
    }

    public void setValorAtual(BigDecimal valorAtual) {
        this.valorAtual = valorAtual;
    }
}

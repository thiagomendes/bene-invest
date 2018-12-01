package br.com.beneinvest.beneinvest.domain.response;

import br.com.beneinvest.beneinvest.domain.entity.AtivoPortfolioRendaVariavel;

import java.math.BigDecimal;

public class PosicaoPorAtivo {

    private AtivoPortfolioRendaVariavel ativoPortfolioRendaVariavel;

    private BigDecimal cotacaoAtual = new BigDecimal(0);

    private String percentualVariacaoDia;

    private BigDecimal variacaoDia = new BigDecimal(0);

    private BigDecimal lucroPrejuizo = new BigDecimal(0);

    public AtivoPortfolioRendaVariavel getAtivoPortfolioRendaVariavel() {
        return ativoPortfolioRendaVariavel;
    }

    public void setAtivoPortfolioRendaVariavel(AtivoPortfolioRendaVariavel ativoPortfolioRendaVariavel) {
        this.ativoPortfolioRendaVariavel = ativoPortfolioRendaVariavel;
    }

    public BigDecimal getCotacaoAtual() {
        return cotacaoAtual;
    }

    public void setCotacaoAtual(BigDecimal cotacaoAtual) {
        this.cotacaoAtual = cotacaoAtual;
    }

    public String getPercentualVariacaoDia() {
        return percentualVariacaoDia;
    }

    public void setPercentualVariacaoDia(String percentualVariacaoDia) {
        this.percentualVariacaoDia = percentualVariacaoDia;
    }

    public BigDecimal getVariacaoDia() {
        return variacaoDia;
    }

    public void setVariacaoDia(BigDecimal variacaoDia) {
        this.variacaoDia = variacaoDia;
    }

    public BigDecimal getLucroPrejuizo() {
        return lucroPrejuizo;
    }

    public void setLucroPrejuizo(BigDecimal lucroPrejuizo) {
        this.lucroPrejuizo = lucroPrejuizo;
    }
}

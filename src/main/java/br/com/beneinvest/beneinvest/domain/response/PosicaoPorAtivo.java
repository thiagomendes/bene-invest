package br.com.beneinvest.beneinvest.domain.response;

import br.com.beneinvest.beneinvest.domain.entity.AtivoPortfolioRendaVariavel;

import java.math.BigDecimal;

public class PosicaoPorAtivo {

    private AtivoPortfolioRendaVariavel ativoPortfolioRendaVariavel;

    private BigDecimal lucroPrejuizo = BigDecimal.ZERO;

    private BigDecimal valorTotalInvestido = BigDecimal.ZERO;

    private BigDecimal valorTotalAtual = BigDecimal.ZERO;

    public AtivoPortfolioRendaVariavel getAtivoPortfolioRendaVariavel() {
        return ativoPortfolioRendaVariavel;
    }

    public void setAtivoPortfolioRendaVariavel(AtivoPortfolioRendaVariavel ativoPortfolioRendaVariavel) {
        this.ativoPortfolioRendaVariavel = ativoPortfolioRendaVariavel;
    }

    public BigDecimal getLucroPrejuizo() {
        return lucroPrejuizo.setScale(2, BigDecimal.ROUND_UP);
    }

    public void setLucroPrejuizo(BigDecimal lucroPrejuizo) {
        this.lucroPrejuizo = lucroPrejuizo;
    }

    public BigDecimal getValorTotalInvestido() {
        return valorTotalInvestido.setScale(2, BigDecimal.ROUND_UP);
    }

    public void setValorTotalInvestido(BigDecimal valorTotalInvestido) {
        this.valorTotalInvestido = valorTotalInvestido;
    }

    public BigDecimal getValorTotalAtual() {
        return valorTotalAtual.setScale(2, BigDecimal.ROUND_UP);
    }

    public void setValorTotalAtual(BigDecimal valorTotalAtual) {
        this.valorTotalAtual = valorTotalAtual;
    }
}

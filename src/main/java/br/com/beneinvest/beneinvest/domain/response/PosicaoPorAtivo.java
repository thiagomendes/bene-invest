package br.com.beneinvest.beneinvest.domain.response;

import br.com.beneinvest.beneinvest.domain.entity.AtivoPortfolioRendaVariavel;

import java.math.BigDecimal;

public class PosicaoPorAtivo {

    private AtivoPortfolioRendaVariavel ativoPortfolioRendaVariavel;

    private CotacaoAtivoResponse cotacaoAtivoResponse;

    private BigDecimal lucroPrejuizo = new BigDecimal(0);

    public AtivoPortfolioRendaVariavel getAtivoPortfolioRendaVariavel() {
        return ativoPortfolioRendaVariavel;
    }

    public void setAtivoPortfolioRendaVariavel(AtivoPortfolioRendaVariavel ativoPortfolioRendaVariavel) {
        this.ativoPortfolioRendaVariavel = ativoPortfolioRendaVariavel;
    }

    public CotacaoAtivoResponse getCotacaoAtivoResponse() {
        return cotacaoAtivoResponse;
    }

    public void setCotacaoAtivoResponse(CotacaoAtivoResponse cotacaoAtivoResponse) {
        this.cotacaoAtivoResponse = cotacaoAtivoResponse;
    }

    public BigDecimal getLucroPrejuizo() {
        return lucroPrejuizo;
    }

    public void setLucroPrejuizo(BigDecimal lucroPrejuizo) {
        this.lucroPrejuizo = lucroPrejuizo;
    }
}

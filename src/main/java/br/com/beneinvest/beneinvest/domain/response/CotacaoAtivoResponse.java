
package br.com.beneinvest.beneinvest.domain.response;

import java.math.BigDecimal;

public class CotacaoAtivoResponse {

    private String codigoPapel;

    private String nome;

    private BigDecimal preco;

    private BigDecimal percentualVariacao;

    private BigDecimal variacao;

    public CotacaoAtivoResponse(String codigoPapel, String nome, BigDecimal preco, BigDecimal percentualVariacao, BigDecimal variacao) {
        this.codigoPapel = codigoPapel;
        this.nome = nome;
        this.preco = preco;
        this.percentualVariacao = percentualVariacao;
        this.variacao = variacao;
    }

    public String getCodigoPapel() {
        return codigoPapel;
    }

    public void setCodigoPapel(String codigoPapel) {
        this.codigoPapel = codigoPapel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public BigDecimal getPercentualVariacao() {
        return percentualVariacao;
    }

    public void setPercentualVariacao(BigDecimal percentualVariacao) {
        this.percentualVariacao = percentualVariacao;
    }

    public BigDecimal getVariacao() {
        return variacao;
    }

    public void setVariacao(BigDecimal variacao) {
        this.variacao = variacao;
    }
}

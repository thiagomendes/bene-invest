package br.com.beneinvest.beneinvest.domain.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class AtivoPortfolioRendaVariavel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String codigo;

    private String nome;

    private LocalDate dataCompra;

    private BigDecimal valorPagoUnidade = BigDecimal.ZERO;

    private Integer quantidade;

    @ManyToOne
    private TipoAtivo tipoAtivo;

    private BigDecimal preco = BigDecimal.ZERO;

    private BigDecimal percentualVariacao = BigDecimal.ZERO;

    private BigDecimal variacao = BigDecimal.ZERO;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public BigDecimal getValorPagoUnidade() {
        return valorPagoUnidade.setScale(2, BigDecimal.ROUND_UP);
    }

    public void setValorPagoUnidade(BigDecimal valorPagoUnidade) {
        this.valorPagoUnidade = valorPagoUnidade;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public TipoAtivo getTipoAtivo() {
        return tipoAtivo;
    }

    public void setTipoAtivo(TipoAtivo tipoAtivo) {
        this.tipoAtivo = tipoAtivo;
    }

    public BigDecimal getPreco() {
        return preco.setScale(2, BigDecimal.ROUND_UP);
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public BigDecimal getPercentualVariacao() {
        return percentualVariacao.setScale(2, BigDecimal.ROUND_UP);
    }

    public void setPercentualVariacao(BigDecimal percentualVariacao) {
        this.percentualVariacao = percentualVariacao;
    }

    public BigDecimal getVariacao() {
        return variacao.setScale(2, BigDecimal.ROUND_UP);
    }

    public void setVariacao(BigDecimal variacao) {
        this.variacao = variacao;
    }
}

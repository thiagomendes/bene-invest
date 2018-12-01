package br.com.beneinvest.beneinvest.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Entity
public class AtivoRendaVariavel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String codigo;

    private String nome;

    private ZonedDateTime dataCompra;

    private BigDecimal valorPagoUnidade;

    private Integer quantidade;

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

    public ZonedDateTime getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(ZonedDateTime dataCompra) {
        this.dataCompra = dataCompra;
    }

    public BigDecimal getValorPagoUnidade() {
        return valorPagoUnidade;
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
}

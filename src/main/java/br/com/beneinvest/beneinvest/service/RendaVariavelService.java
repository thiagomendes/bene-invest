package br.com.beneinvest.beneinvest.service;

import br.com.beneinvest.beneinvest.domain.client.AlphaVantageClient;
import br.com.beneinvest.beneinvest.domain.client.YahooFinanceClient;
import br.com.beneinvest.beneinvest.domain.entity.AtivoPortfolioRendaVariavel;
import br.com.beneinvest.beneinvest.domain.response.ConsultaAtivosResponse;
import br.com.beneinvest.beneinvest.domain.response.CotacaoAtivoResponse;
import br.com.beneinvest.beneinvest.domain.response.Posicao;
import br.com.beneinvest.beneinvest.domain.response.PosicaoPorAtivo;
import br.com.beneinvest.beneinvest.repository.AtivoRendaVariavelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Objects;

@Service
public class RendaVariavelService {

    @Value("${alpha.vantage.apiKey}")
    private String alphaVantageApiKey;

    @Autowired
    private AlphaVantageClient alphaVantageClient;

    @Autowired
    private YahooFinanceClient yahooFinanceClient;

    @Autowired
    private AtivoRendaVariavelRepository ativoRendaVariavelRepository;

    public ConsultaAtivosResponse consultarAtivos(String codigoPapel) {
        return alphaVantageClient.consultarAtivos(codigoPapel, alphaVantageApiKey);
    }

    public CotacaoAtivoResponse cotarAtivo(String codigoPapel) {
        return yahooFinanceClient.cotarAtivo(codigoPapel);
    }

    public AtivoPortfolioRendaVariavel adicionarAtivoPortfolio(AtivoPortfolioRendaVariavel ativoPortfolioRendaVariavel) {
        return ativoRendaVariavelRepository.save(ativoPortfolioRendaVariavel);
    }

    public Iterable<AtivoPortfolioRendaVariavel> obterPortfolio() {
        Iterable<AtivoPortfolioRendaVariavel> all = ativoRendaVariavelRepository.findAll();
        all.forEach(i -> {
            atualizaValoresAtivo(i);
        });
        return all;
    }

    public Posicao obterPosicaoAtual() {

        Posicao posicao = new Posicao();

        Iterable<AtivoPortfolioRendaVariavel> ativos = ativoRendaVariavelRepository.findAll();

        ativos.forEach(i -> {

            PosicaoPorAtivo posicaoPorAtivo = new PosicaoPorAtivo();
            posicaoPorAtivo.setAtivoPortfolioRendaVariavel(i);
            atualizaValoresAtivo(i);

            posicaoPorAtivo.setLucroPrejuizo(
                    (i.getPreco().multiply(BigDecimal.valueOf(i.getQuantidade())))
                            .subtract((i.getValorPagoUnidade().multiply(BigDecimal.valueOf(i.getQuantidade())))));

            posicaoPorAtivo.setValorTotalInvestido(
                    posicaoPorAtivo.getAtivoPortfolioRendaVariavel().getValorPagoUnidade()
                            .multiply(BigDecimal.valueOf(posicaoPorAtivo.getAtivoPortfolioRendaVariavel().getQuantidade())));

            posicaoPorAtivo.setValorTotalAtual(
                    i.getPreco().multiply(BigDecimal.valueOf(posicaoPorAtivo.getAtivoPortfolioRendaVariavel().getQuantidade())));

            posicao.getListaPosicaoPorAtivos().add(posicaoPorAtivo);
            posicao.setValorAtual(posicao.getValorAtual().add(i.getPreco().multiply(new BigDecimal(i.getQuantidade()))));
            posicao.setValorInvestido(posicao.getValorInvestido().add(new BigDecimal(i.getValorPagoUnidade().doubleValue() * i.getQuantidade())));
            posicao.setLucroPrejuizo(posicao.getLucroPrejuizo().add(posicaoPorAtivo.getLucroPrejuizo()));
        });

        return posicao;
    }

    public void atualizaValoresAtivo(AtivoPortfolioRendaVariavel ativo) {
        if (Objects.equals("Ações", ativo.getTipoAtivo().getDescricao())) {
            CotacaoAtivoResponse cotacaoAtivoResponse = yahooFinanceClient.cotarAtivo(ativo.getCodigo());
            if (Objects.nonNull(cotacaoAtivoResponse)) {
                ativo.setPreco(cotacaoAtivoResponse.getPreco());
                ativo.setVariacao(cotacaoAtivoResponse.getVariacao());
                ativo.setPercentualVariacao(cotacaoAtivoResponse.getPercentualVariacao());
                ativoRendaVariavelRepository.save(ativo);
            }
        }
    }
}

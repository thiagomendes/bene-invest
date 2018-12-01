package br.com.beneinvest.beneinvest.service;

import br.com.beneinvest.beneinvest.domain.client.AlphaVantageClient;
import br.com.beneinvest.beneinvest.domain.entity.AtivoRendaVariavel;
import br.com.beneinvest.beneinvest.domain.response.ConsultaAtivosResponse;
import br.com.beneinvest.beneinvest.domain.response.CotacaoAtivoResponse;
import br.com.beneinvest.beneinvest.repository.AtivoRendaVariavelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RendaVariavelService {

    @Value("${alpha.vantage.apiKey}")
    private String alphaVantageApiKey;

    @Autowired
    private AlphaVantageClient alphaVantageClient;

    @Autowired
    private AtivoRendaVariavelRepository ativoRendaVariavelRepository;

    public ConsultaAtivosResponse consultarAtivos(String codigoPapel) {
        return alphaVantageClient.consultarAtivos(codigoPapel, alphaVantageApiKey);
    }

    public CotacaoAtivoResponse cotarAtivo(String codigoPapel) {
        return alphaVantageClient.cotarAtivo(codigoPapel, alphaVantageApiKey);
    }

    public AtivoRendaVariavel adicionarAtivoPortfolio(AtivoRendaVariavel ativoRendaVariavel) {
        return ativoRendaVariavelRepository.save(ativoRendaVariavel);
    }

    public Iterable<AtivoRendaVariavel> obterPortfolio() {
        return ativoRendaVariavelRepository.findAll();
    }
}

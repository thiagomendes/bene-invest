package br.com.beneinvest.beneinvest.service;

import br.com.beneinvest.beneinvest.domain.client.AlphaVantageClient;
import br.com.beneinvest.beneinvest.domain.response.ConsultaAtivosResponse;
import br.com.beneinvest.beneinvest.domain.response.CotacaoAtivoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RendaVariavelService {

    @Value("${alpha.vantage.apiKey}")
    private String alphaVantageApiKey;

    @Autowired
    private AlphaVantageClient alphaVantageClient;

    public ConsultaAtivosResponse consultarAtivos(String codigoPapel) {
        return alphaVantageClient.consultarAtivos(codigoPapel, alphaVantageApiKey);
    }

    public CotacaoAtivoResponse cotarAtivo(String codigoPapel) {
        return alphaVantageClient.cotarAtivo(codigoPapel, alphaVantageApiKey);
    }
}

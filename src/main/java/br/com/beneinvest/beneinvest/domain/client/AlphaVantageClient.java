package br.com.beneinvest.beneinvest.domain.client;

import br.com.beneinvest.beneinvest.domain.response.ConsultaAtivosResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "alphaVantageClient", url = "https://www.alphavantage.co")
public interface AlphaVantageClient {

    @GetMapping("query?function=SYMBOL_SEARCH&keywords={codigoPapel}&apikey={apiKey}")
    public ConsultaAtivosResponse consultaAtivos(
            @RequestParam("codigoPapel") String codigoPapel,
            @RequestParam("apiKey") String apiKey);

}

package br.com.beneinvest.beneinvest.domain.client;

import br.com.beneinvest.beneinvest.domain.response.CotacaoAtivoResponse;
import org.springframework.stereotype.Component;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.util.Objects;

@Component
public class YahooFinanceClient {

    public CotacaoAtivoResponse cotarAtivo(String codigoPapel) {

        CotacaoAtivoResponse cotacaoAtivoResponse = null;

        try {

            Stock stock = YahooFinance.get(codigoPapel);

            if (Objects.nonNull(stock)) {
                cotacaoAtivoResponse = new CotacaoAtivoResponse(
                        stock.getSymbol(),
                        stock.getName(),
                        stock.getQuote().getPrice(),
                        stock.getQuote().getChangeInPercent(),
                        stock.getQuote().getChange());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return cotacaoAtivoResponse;
    }
}

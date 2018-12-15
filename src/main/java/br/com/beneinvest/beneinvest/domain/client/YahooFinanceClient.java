package br.com.beneinvest.beneinvest.domain.client;

import br.com.beneinvest.beneinvest.domain.response.CotacaoAtivoResponse;
import org.springframework.stereotype.Component;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Objects;

@Component
public class YahooFinanceClient {

    public static void main(String[] args) throws Exception {
        Stock stock = YahooFinance.get("ITSA4.SA");

        BigDecimal price = stock.getQuote().getPrice();
        BigDecimal change = stock.getQuote().getChangeInPercent();
        BigDecimal peg = stock.getStats().getPeg();
        BigDecimal dividend = stock.getDividend().getAnnualYieldPercent();

        stock.print();
        System.out.println(stock.getQuote().getChange());
    }

    public CotacaoAtivoResponse cotarAtivo(String codigoPapel) {

        CotacaoAtivoResponse cotacaoAtivoResponse = null;

        try {

            Stock stock = YahooFinance.get(codigoPapel);

            if (Objects.nonNull(stock)) {
                cotacaoAtivoResponse = new CotacaoAtivoResponse(stock.getSymbol(), stock.getName(), stock.getQuote().getPrice(), stock.getQuote().getChangeInPercent(), stock.getQuote().getChange());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return cotacaoAtivoResponse;
    }
}

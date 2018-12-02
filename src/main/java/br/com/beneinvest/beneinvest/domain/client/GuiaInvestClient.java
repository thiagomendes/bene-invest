package br.com.beneinvest.beneinvest.domain.client;

import br.com.beneinvest.beneinvest.domain.response.CotacaoAtivoResponse;
import br.com.beneinvest.beneinvest.domain.response.GlobalQuote;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

@Component
public class GuiaInvestClient {

    public CotacaoAtivoResponse cotarAtivo(String codigoPapel) {

        CotacaoAtivoResponse cotacaoAtivoResponse = null;

        try {

            cotacaoAtivoResponse = new CotacaoAtivoResponse();
            GlobalQuote globalQuote = new GlobalQuote();

            URL url = new URL("https://www.guiainvest.com.br/mural/" + codigoPapel.toLowerCase() + ".aspx");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

            while (br.ready()) {

                String linha = br.readLine();

                // cotação
                if (linha.contains("liCotacao") && linha.contains("newchangeinicial")) {
                    String nohtml = linha.toString().replaceAll("\\<.*?>", "");
                    globalQuote.set05Price(nohtml.trim().replaceAll(",", "."));
                }

                // variação
                if (linha.contains("liOscilacao")) {

                    String nohtml = linha.toString().replaceAll("\\<.*?>", "");
                    String variacao = nohtml.trim().split(";")[1];

                    if (nohtml.contains("&#9660")) {
                        variacao = "-" + variacao;
                    }

                    globalQuote.set10ChangePercent(variacao);
                }

                if (linha.contains("liData")) {
                    String nohtml = linha.toString().replaceAll("\\<.*?>", "");
                    globalQuote.set07LatestTradingDay(nohtml.trim());
                }
            }

            globalQuote.set01Symbol(codigoPapel.toUpperCase());
            cotacaoAtivoResponse.setGlobalQuote(globalQuote);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cotacaoAtivoResponse;
    }
}

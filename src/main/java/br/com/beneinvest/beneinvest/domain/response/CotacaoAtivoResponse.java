
package br.com.beneinvest.beneinvest.domain.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Global Quote"
})
public class CotacaoAtivoResponse {

    @JsonProperty("Global Quote")
    private GlobalQuote globalQuote;

    @JsonProperty("Global Quote")
    public GlobalQuote getGlobalQuote() {
        return globalQuote;
    }

    @JsonProperty("Global Quote")
    public void setGlobalQuote(GlobalQuote globalQuote) {
        this.globalQuote = globalQuote;
    }

    @Override
    public String toString() {
        return globalQuote.get05Price() + "|" + globalQuote.get10ChangePercent();
    }
}

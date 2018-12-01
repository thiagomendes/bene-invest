
package br.com.beneinvest.beneinvest.domain.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "bestMatches"
})
public class ConsultaAtivosResponse {

    @JsonProperty("bestMatches")
    private List<BestMatch> bestMatches = null;

    @JsonProperty("bestMatches")
    public List<BestMatch> getBestMatches() {
        return bestMatches;
    }

    @JsonProperty("bestMatches")
    public void setBestMatches(List<BestMatch> bestMatches) {
        this.bestMatches = bestMatches;
    }

}

package br.com.beneinvest.beneinvest.controller;

import br.com.beneinvest.beneinvest.domain.entity.AtivoPortfolioRendaVariavel;
import br.com.beneinvest.beneinvest.domain.response.ConsultaAtivosResponse;
import br.com.beneinvest.beneinvest.domain.response.CotacaoAtivoResponse;
import br.com.beneinvest.beneinvest.domain.response.Posicao;
import br.com.beneinvest.beneinvest.service.RendaVariavelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/rendaVariavel")
public class RendaVariavelController {

    @Autowired
    private RendaVariavelService rendaVariavelService;

    @GetMapping("/consultarAtivos")
    public ResponseEntity<ConsultaAtivosResponse> consultarAtivos(@RequestParam("codigoPapel") String codigoPapel) {
        return new ResponseEntity<ConsultaAtivosResponse>(rendaVariavelService.consultarAtivos(codigoPapel), HttpStatus.OK);
    }

    @GetMapping("/cotarAtivo")
    public ResponseEntity<CotacaoAtivoResponse> cotarAtivo(@RequestParam("codigoPapel") String codigoPapel) {
        return new ResponseEntity<CotacaoAtivoResponse>(rendaVariavelService.cotarAtivo(codigoPapel), HttpStatus.OK);
    }

    @PostMapping("/adicionarAtivoPortfolio")
    public ResponseEntity<AtivoPortfolioRendaVariavel> adicionarAtivoPortfolio(@RequestBody AtivoPortfolioRendaVariavel ativoPortfolioRendaVariavel) {
        return new ResponseEntity<AtivoPortfolioRendaVariavel>(rendaVariavelService.adicionarAtivoPortfolio(ativoPortfolioRendaVariavel), HttpStatus.CREATED);
    }

    @GetMapping("/portfolio")
    public ResponseEntity<Iterable<AtivoPortfolioRendaVariavel>> obterPortfolio() {
        return new ResponseEntity<Iterable<AtivoPortfolioRendaVariavel>>(rendaVariavelService.obterPortfolio(), HttpStatus.OK);
    }

    @GetMapping("/posicao")
    public ResponseEntity<Posicao> obterPosicaoAtual() {
        return new ResponseEntity<Posicao>(rendaVariavelService.obterPosicaoAtual(), HttpStatus.OK);
    }

}

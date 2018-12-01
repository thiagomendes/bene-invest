package br.com.beneinvest.beneinvest.controller;

import br.com.beneinvest.beneinvest.domain.entity.AtivoRendaVariavel;
import br.com.beneinvest.beneinvest.domain.response.ConsultaAtivosResponse;
import br.com.beneinvest.beneinvest.domain.response.CotacaoAtivoResponse;
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
    public ResponseEntity<AtivoRendaVariavel> adicionarAtivoPortfolio(@RequestBody AtivoRendaVariavel ativoRendaVariavel) {
        return new ResponseEntity<AtivoRendaVariavel>(rendaVariavelService.adicionarAtivoPortfolio(ativoRendaVariavel), HttpStatus.CREATED);
    }

    @GetMapping("/portfolio")
    public ResponseEntity<Iterable<AtivoRendaVariavel>> obterPortfolio() {
        return new ResponseEntity<Iterable<AtivoRendaVariavel>>(rendaVariavelService.obterPortfolio(), HttpStatus.OK);
    }

}

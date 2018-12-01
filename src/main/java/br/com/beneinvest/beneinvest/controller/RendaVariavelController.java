package br.com.beneinvest.beneinvest.controller;

import br.com.beneinvest.beneinvest.domain.response.ConsultaAtivosResponse;
import br.com.beneinvest.beneinvest.service.RendaVariavelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rendaVariavel")
public class RendaVariavelController {

    @Autowired
    private RendaVariavelService rendaVariavelService;

    @GetMapping("/consultaAtivos")
    public ResponseEntity<ConsultaAtivosResponse> consultaAtivos(@RequestParam("codigoPapel") String codigoPapel) {
        return new ResponseEntity<ConsultaAtivosResponse>(rendaVariavelService.consultarAtivos(codigoPapel), HttpStatus.OK);
    }

}

package br.com.beneinvest.beneinvest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/variableIncome")
public class VariableIncomeController {

    @RequestMapping(value = "/testController", method = RequestMethod.GET)
    public ResponseEntity<String> testController() {
        return new ResponseEntity<String>("Ok", HttpStatus.OK);
    }

}

package br.com.betsoccer.controller;

import br.com.betsoccer.model.Match;
import br.com.betsoccer.service.MatchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MatchController {

    private final MatchService service;

    public MatchController(MatchService service) {
        this.service = service;
    }


    @GetMapping("match")
    public ResponseEntity<List<Match>> findAllMatches() {
        return service.findAllMatch();

    }


}

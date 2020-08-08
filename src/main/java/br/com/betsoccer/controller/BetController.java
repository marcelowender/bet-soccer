package br.com.betsoccer.controller;

import br.com.betsoccer.controller.request.BetRequest;
import br.com.betsoccer.model.Bet;
import br.com.betsoccer.service.BetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class BetController {

    private final BetService service;

    public BetController(BetService service) {
        this.service = service;
    }


    @PostMapping("bet")
    public ResponseEntity<List<Bet>> creteBet(@RequestBody Map<String, BetRequest> bets) {
        return service.saveBets(bets);

    }


}

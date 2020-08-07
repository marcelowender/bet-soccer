package br.com.betsoccer.controller;

import br.com.betsoccer.model.Game;
import br.com.betsoccer.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class GameController {

    private final GameService service;

    public GameController(GameService service) {
        this.service = service;
    }


    @GetMapping("game")
    public ResponseEntity<List<Game>> findAllMatches(@RequestParam("round") Optional<Integer> round) {
        return service.findGames(round);

    }


}

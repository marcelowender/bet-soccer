package br.com.betsoccer.service;

import br.com.betsoccer.model.Game;
import br.com.betsoccer.repository.GameRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {


    private final GameRepository repository;

    public GameService(GameRepository repository) {
        this.repository = repository;
    }


    public ResponseEntity<List<Game>> findGames(Optional<Integer> round) {
        return round.map(value -> ResponseEntity.ok(repository.findByRound(value))).orElse(ResponseEntity.ok(repository.findAll()));


    }


}

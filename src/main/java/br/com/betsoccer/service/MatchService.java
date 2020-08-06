package br.com.betsoccer.service;

import br.com.betsoccer.model.Match;
import br.com.betsoccer.repository.MatchRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {


    private final MatchRepository repository;

    public MatchService(MatchRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<List<Match>> findAllMatch() {
        return ResponseEntity.ok(repository.findAll());

    }


}

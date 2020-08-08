package br.com.betsoccer.service;

import br.com.betsoccer.controller.request.BetRequest;
import br.com.betsoccer.model.Bet;
import br.com.betsoccer.model.key.BetKey;
import br.com.betsoccer.repository.BetRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BetService {


    private final BetRepository repository;

    public BetService(BetRepository repository) {
        this.repository = repository;
    }


    public ResponseEntity saveBets(Map<String, BetRequest> betsMap) {

        List<Bet> bets = betsMap.values().stream().map(bet -> {
            return Bet.builder().key(BetKey.builder().idUser(1L).id(bet.getId()).idGame(bet.getIdGame()).build()).goalsHome(bet.getGoalsHome()).goalsVisitor(bet.getGoalsVisitor()).betDate(new Date()).build();
        }).collect(Collectors.toList());
        repository.saveAll(bets);
        return ResponseEntity.noContent().build();
    }


}

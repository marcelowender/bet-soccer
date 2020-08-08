package br.com.betsoccer.repository;

import br.com.betsoccer.model.Bet;
import br.com.betsoccer.model.key.BetKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BetRepository extends JpaRepository<Bet, BetKey> {

}

package br.com.betsoccer.model.key;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

@Embeddable
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BetKey implements Serializable {


    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_BET")
    private Long id;

    @Column(name = "ID_GAME")
    protected Long idGame;
    @Column(name = "ID_USER")
    protected Long idUser;

}

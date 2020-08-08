package br.com.betsoccer.controller.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BetRequest {

    private Long id;
    private Long idGame;
    private Integer goalsHome;
    private Integer goalsVisitor;


}

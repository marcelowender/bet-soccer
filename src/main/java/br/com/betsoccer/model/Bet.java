package br.com.betsoccer.model;

import br.com.betsoccer.model.key.BetKey;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Builder
@Data
@Entity
@Table(name = "bet")
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Bet implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private BetKey key;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_GAME", nullable = false, updatable = false, insertable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Game game;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USER", nullable = false, updatable = false, insertable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User user;


    @Column(name = "GOALS_HOME")
    private Integer goalsHome;

    @Column(name = "GOALS_VISITOR")
    private Integer goalsVisitor;

    @Column(name = "BET_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date betDate;

}
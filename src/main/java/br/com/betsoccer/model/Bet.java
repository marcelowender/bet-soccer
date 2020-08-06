package br.com.betsoccer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "bet")
@EntityListeners(AuditingEntityListener.class)
public class Bet implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_BET")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_MATCH", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Match match;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USER", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User user;

    @Column(name = "GOALS_HOME")
    private Integer goalsHome;

    @Column(name = "GOALS_VISITORS")
    private Integer goalsVisitors;

    @Column(name = "BET_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date betDate;

}
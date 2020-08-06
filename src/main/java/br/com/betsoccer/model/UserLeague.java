package br.com.betsoccer.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "user_league")
@EntityListeners(AuditingEntityListener.class)

public class UserLeague implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ManyToOne
    @JoinColumn(name = "ID_USER")
    @JsonBackReference(value = "user-league")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "ID_LEAGUE")
    @JsonBackReference(value = "league-user")
    private League league;

    @Column(name = "ENTRY_DATE_LEAGUE", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date entryDateLeague;

}
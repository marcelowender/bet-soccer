package br.com.betsoccer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "match")
@EntityListeners(AuditingEntityListener.class)
public class Match implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_MATCH")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_COMPETITION", nullable = false)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Competition competition;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TEAM_HOME", nullable = false)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Team teamHome;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TEAM_VISITOR", nullable = false)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Team teamVisitor;

	@Column(name = "GOALS_HOME")
	private Integer goalsHome;

	@Column(name = "GOALS_VISITOR")
	private Integer goalsVisitor;

	@Column(name = "MATCH_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date matchDate;

}
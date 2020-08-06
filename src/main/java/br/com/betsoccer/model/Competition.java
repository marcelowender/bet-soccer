package br.com.betsoccer.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "competition")
@EntityListeners(AuditingEntityListener.class)
public class Competition implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_COMPETITION")
	private long id;

	@Column(name = "COMPETITION_NAME")
	private String competitionName;

	@Column(name = "BEGIN_DATE", nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date beginDate;

	@Column(name = "END_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDAte;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "competition")
	@JsonManagedReference (value="competition-league")
	private List<League> league;

}
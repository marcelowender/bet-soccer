package br.com.betsoccer.model;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "team")
@EntityListeners(AuditingEntityListener.class)

public class Team implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_TEAM")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "UF")
	private String ufTeam;

	@Column(name = "NAME_LOGO_TEAM")
	private String nameLogoTeam;

	@Column(name = "COUNTRY_TEAM")
	private String countryTeam;

}
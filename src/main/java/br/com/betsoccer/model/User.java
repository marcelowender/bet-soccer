package br.com.betsoccer.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, 
property  = "id", 
scope     = Long.class)
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_USER")
	private Long id;

	@Column(name = "ID_USER_FIREBASE")
	private String idUserFirebase;

	@Column(name = "NAME_USER")
	private String nameUser;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "LOGIN")
	private String login;

	@Column(name = "CREATION_USER", nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date creationUser;

	@OneToMany(mappedBy = "user")
	@JsonManagedReference(value="user-league")
	private List<UserLeague> userLeague;

}
package com.av1.cinema.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "diretor")
public class Diretor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_diretor")
	private Integer idDiretor;
	
	@Column(name = "nome")
	private String nome;
	
	@OneToMany(mappedBy = "diretor")
	@JoinColumn(name = "id_filme")
	private Set<Filme> filmes;
}

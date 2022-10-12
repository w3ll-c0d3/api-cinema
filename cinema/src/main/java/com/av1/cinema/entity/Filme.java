package com.av1.cinema.entity;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "filme")
public class Filme {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_filme")
	private Integer idFilme;
	
	@Column(name = "nome_br")
	private String nomeBr;

	@Column(name = "nome_en")
	private String nomeEn;

	@Column(name = "ano_lancamento")
	private Instant anoLancamento;

	@Column(name = "sinopse")
	private String sinopse;
	
	@ManyToOne
	@JsonBackReference(value = "FilmeDiretor")
	@JoinColumn(name = "id_diretor", referencedColumnName = "id_diretor")
	// @JsonIgnore
	private Diretor diretor;
	
	@JsonBackReference(value = "FilmeGenero")
	@ManyToOne
	@JoinColumn(name = "id_genero", referencedColumnName = "id_genero")
	// @JsonIgnore
	private Genero genero;

//	Getters and Setters
	public Integer getIdFilme() {
		return idFilme;
	}

	public void setIdFilme(Integer idFilme) {
		this.idFilme = idFilme;
	}

	public String getNomeBr() {
		return nomeBr;
	}

	public void setNomeBr(String nomeBr) {
		this.nomeBr = nomeBr;
	}

	public String getNomeEn() {
		return nomeEn;
	}

	public void setNomeEn(String nomeEn) {
		this.nomeEn = nomeEn;
	}

	public Instant getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(Instant anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public Diretor getDiretor() {
		return diretor;
	}

	public void setDiretor(Diretor diretor) {
		this.diretor = diretor;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

}

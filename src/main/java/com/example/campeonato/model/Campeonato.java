package com.example.campeonato.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.example.campeonato.model.Partida;
import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("deprecation")
@Entity
public class Campeonato  {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Nome é obrigatória")
	@Size(max = 30, message = "O Nome não pode conter mais de 30 caracteres")
	private String nome;
	private String fase;
	
	@JsonIgnore
	@OneToMany(mappedBy = "campeonato", cascade = CascadeType.ALL)
	private Set<Partida> partidas;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getFase() {
		return fase;
	}
	public void setFase(String fase) {
		this.fase = fase;
	}
	public Set<Partida> getPartidas() {
		return partidas;
	}
	public void setPartidas(Set<Partida> partidas) {
		this.partidas = partidas;
	}
	
	
	
	
}

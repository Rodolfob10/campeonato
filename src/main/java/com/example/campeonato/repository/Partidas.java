package com.example.campeonato.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.campeonato.model.Partida;

public interface Partidas extends JpaRepository<Partida, Long> {
	
}
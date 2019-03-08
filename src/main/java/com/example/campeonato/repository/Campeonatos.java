package com.example.campeonato.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.campeonato.model.Campeonato;

public interface Campeonatos extends JpaRepository<Campeonato, Long> {
	
}
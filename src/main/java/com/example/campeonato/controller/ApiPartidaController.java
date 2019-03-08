package com.example.campeonato.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.campeonato.model.Partida;
import com.example.campeonato.repository.Partidas;

@RestController
@RequestMapping("/api/partidas")
public class ApiPartidaController {

	@Autowired
	private Partidas partidas;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public Collection<Partida> listaConvidados() {
		return partidas.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<Partida> getPartida(@PathVariable("id") Long id) {
		return this.partidas.findById(id);
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Partida>> listar() {
		return new ResponseEntity<List<Partida>>(new ArrayList<Partida>(partidas.findAll()), 
				HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> removePartida(@PathVariable("id") Long id) {
		Optional<Partida> p = partidas.findById(id);
		if (p == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		partidas.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public  ResponseEntity<?> savePartida(@RequestBody Partida partida) {
		return new ResponseEntity<Partida> (partidas.save(partida), HttpStatus.OK);
	}

}

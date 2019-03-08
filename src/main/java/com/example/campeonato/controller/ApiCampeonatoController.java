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

import com.example.campeonato.model.Campeonato;
import com.example.campeonato.repository.Campeonatos;

@RestController
@RequestMapping("/api/campeonatos")
public class ApiCampeonatoController {
	
	@Autowired
	private Campeonatos campeonatos;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public Collection<Campeonato> listaCampeonatos() {
		return campeonatos.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<Campeonato> getCampeonato(@PathVariable("id") Long id) {
		return this.campeonatos.findById(id);
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Campeonato>> listar() {
		return new ResponseEntity<List<Campeonato>>(new ArrayList<Campeonato>(campeonatos.findAll()), 
				HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> removeCampeonato(@PathVariable("id") Long id) {
		Optional<Campeonato> c = campeonatos.findById(id);
		if (c == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		campeonatos.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public  ResponseEntity<?> saveCampeonato(@RequestBody Campeonato campeonato) {
		return new ResponseEntity<Campeonato> (campeonatos.save(campeonato), HttpStatus.OK);
	}


}

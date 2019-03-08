package com.example.campeonato.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.campeonato.model.Partida;
import com.example.campeonato.repository.Partidas;
import com.example.campeonato.repository.Campeonatos;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@Controller
@RequestMapping("/partidas")
public class PartidaController {
	
	@Autowired
	private Partidas partidas; 
	
	@Autowired
	private Campeonatos campeonatos;

	@RequestMapping("")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("ListaPartidas");
		mv.addObject(new Partida());
		mv.addObject("campeonatos",campeonatos.findAll());
		mv.addObject("partidas", partidas.findAll());
		return (mv);
	}

	@PostMapping
	public String salvar(Partida partida) {
		this.partidas.save(partida);
		return "redirect:/partidas";
	}

	@RequestMapping(value ="/excluir/{id}")
	public String excluirPartidaByPathVariable(@PathVariable Long id, HttpServletRequest request, HttpServletResponse response)
	{
		this.partidas.deleteById(id);
		return "redirect:/partidas";
	}
	
	@RequestMapping(value ="/alterar/{id}")
	public ModelAndView alterarPartidaByPathVariable(@PathVariable Long id, HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mv = new ModelAndView("ListaPartida");
		Partida partida = partidas.getOne(id);
		mv.addObject(partida);
		mv.addObject("partidas", partidas.findAll());
		return (mv);
	}
	
	@Bean
	public LayoutDialect layoutDialect() {
	    return new LayoutDialect();
	}

}

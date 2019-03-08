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

import com.example.campeonato.model.Campeonato;
import com.example.campeonato.repository.Campeonatos;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@Controller
@RequestMapping("/campeonatos")
public class CampeonatoController {
	
	
	@Autowired
	private Campeonatos campeonatos;


	@RequestMapping("")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("ListaCampeonatos");
		mv.addObject(new Campeonato());
		mv.addObject("campeonatos", campeonatos.findAll());
		return (mv);
	}

	@PostMapping
	public String salvar(Campeonato campeonato) {
		this.campeonatos.save(campeonato);
		return "redirect:/campeonatos";
	}

	@RequestMapping(value ="/excluir/{id}")
	public String excluirCampeonatoByPathVariable(@PathVariable Long id, HttpServletRequest request, HttpServletResponse response)
	{
		this.campeonatos.deleteById(id);
		return "redirect:/campeonatos";
	}
	
	@RequestMapping(value ="/alterar/{id}")
	public ModelAndView alterarCampeonatoByPathVariable(@PathVariable Long id, HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mv = new ModelAndView("ListaCampeonatos");
		Campeonato campeonato = campeonatos.getOne(id);
		mv.addObject(campeonato);
		mv.addObject("campeonatos", campeonatos.findAll());
		return (mv);
	}
	
	@Bean
	public LayoutDialect layoutDialect() {
	    return new LayoutDialect();
	}

}

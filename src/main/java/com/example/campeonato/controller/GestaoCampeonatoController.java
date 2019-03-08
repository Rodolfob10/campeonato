package com.example.campeonato.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class GestaoCampeonatoController {

	@RequestMapping("")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("Home");
		return (mv);
	}
}

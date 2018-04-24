package com.biswa.springangular.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biswa.springangular.models.HeroModel;
import com.biswa.springangular.services.HeroService;

@Controller
public class HomeController {
	
	@Autowired
	private HeroService heroService;
	
	@RequestMapping("/api/saveHero")
	@ResponseBody
	public String saveHero(@RequestBody HeroModel heroModel) {
		try {
		heroService.saveHero(heroModel);
		}
		catch(Exception e) {
			return "fail";
		}
		return "succes";
	}
	
	@RequestMapping("/api/getHeroes")
	@ResponseBody
	public List<HeroModel> getHeroes(){
		return heroService.getHeroes();
	}
}
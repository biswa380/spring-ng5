package com.biswa.springangular.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biswa.springangular.models.HeroModel;
import com.biswa.springangular.models.UserModel;
import com.biswa.springangular.services.HeroService;

@Controller
public class HomeController {
	
	@Autowired
	private HeroService heroService;
	
	@PreAuthorize("hasAuthority('hero-edit')")
	@RequestMapping("/api/saveHero")
	@ResponseBody
	public String saveHero(@RequestBody HeroModel heroModel) {
		try {
		heroService.saveHero(heroModel);
		}
		catch(Exception e) {
			return "fail";
		}
		return "success";
	}
	
	@PreAuthorize("hasAuthority('hero-view')")
	@RequestMapping("/api/getHeroes")
	@ResponseBody
	public List<HeroModel> getHeroes(){
		return heroService.getHeroes();
	}
	
}
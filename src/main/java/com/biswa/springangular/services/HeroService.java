package com.biswa.springangular.services;

import java.util.List;

import com.biswa.springangular.models.HeroModel;

public interface HeroService {
	public void saveHero(HeroModel heroModel);
	
	public List<HeroModel> getHeroes();
}

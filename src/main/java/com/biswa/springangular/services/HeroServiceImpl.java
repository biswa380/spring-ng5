package com.biswa.springangular.services;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.biswa.springangular.domains.Hero;
import com.biswa.springangular.models.HeroModel;
import com.biswa.springangular.repository.HeroRepository;

@Service
public class HeroServiceImpl implements HeroService {

	@Autowired
	private HeroRepository heroRepository;
	
	@Transactional
	@Override
	public void saveHero(HeroModel heroModel) {
		// TODO Auto-generated method stub
		Hero hero = new Hero();
		
		hero.setName(heroModel.getName());
		hero.setPower(heroModel.getPower());
		hero.setCounter(heroModel.getCounter());
		
		heroRepository.save(hero);
	}

	@Override
	public List<HeroModel> getHeroes() {
		// TODO Auto-generated method stub
		List<Hero> heroes=heroRepository.findAll();
		List<HeroModel> heroModels = new ArrayList<HeroModel>();
		heroes.forEach(new Consumer<Hero>() {
			@Override
			public void accept(Hero hero) {
				// TODO Auto-generated method stub
				HeroModel heroModel=new HeroModel();
				heroModel.setName(hero.getName());
				heroModel.setCounter(hero.getCounter());
				heroModel.setPower(hero.getPower());
				
				heroModels.add(heroModel);
			}
		});
		return heroModels;
	}

}

package com.biswa.springangular.repository;


import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.biswa.springangular.domains.Hero;

public interface HeroRepository {
	
	@Transactional
	public void save(Hero hero);
	
	List<Hero> findAll();
}

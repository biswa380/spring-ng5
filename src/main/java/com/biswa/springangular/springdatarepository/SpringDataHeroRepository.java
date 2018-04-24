package com.biswa.springangular.springdatarepository;

import org.springframework.data.repository.Repository;

import com.biswa.springangular.domains.Hero;
import com.biswa.springangular.repository.HeroRepository;

public interface SpringDataHeroRepository extends HeroRepository, Repository<Hero, Integer> {
	

}

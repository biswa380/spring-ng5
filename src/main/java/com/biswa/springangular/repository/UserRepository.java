package com.biswa.springangular.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.biswa.springangular.domains.UserDetails;


public interface UserRepository extends JpaRepository<UserDetails, Integer>{

	UserDetails findByUsername(String username);


}

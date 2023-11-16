package com.infosys.anchal.manyToMany.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.anchal.manyToMany.entity.Person;

public interface PersonRepo extends JpaRepository<Person, Integer> {

}

package com.infosys.anchal.manyToMany.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.anchal.manyToMany.entity.Role;

public interface RoleRepo extends JpaRepository<Role, Integer>{

}

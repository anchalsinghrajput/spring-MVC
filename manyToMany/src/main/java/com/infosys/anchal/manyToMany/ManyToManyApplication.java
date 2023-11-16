package com.infosys.anchal.manyToMany;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.infosys.anchal.manyToMany.entity.Person;
import com.infosys.anchal.manyToMany.entity.Role;
import com.infosys.anchal.manyToMany.repo.PersonRepo;
import com.infosys.anchal.manyToMany.repo.RoleRepo;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class ManyToManyApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ManyToManyApplication.class, args);
	}

	@Autowired
    private RoleRepo roleRepo;
	
	@Override
	@Transactional
	public void run(String... args) throws Exception {
		Person person1 = new Person(1, "Anchal");
        Person person2 = new Person(2, "John");
        Person person3 = new Person(3, "khushi");
        
        Role role1 = new Role(1, "Admin");
        Role role2 = new Role(2, "Manager");
        Role role3 = new Role(3, "SalesPerson");
        
        List<Person> admin = Arrays.asList(person1, person2);
        List<Person> manager = Arrays.asList(person2, person3);
        List<Person> salesPerson = Arrays.asList(person1, person2, person3);

       
    // Save the roles with associated persons
       role1.setPersons(admin);
       role2.setPersons(manager);
       role3.setPersons(salesPerson);

       roleRepo.saveAll(Arrays.asList(role1, role2, role3));

       // Retrieve roles from the database
       Role adminRole = roleRepo.findById(1).get();
       Role managerRole = roleRepo.findById(2).get();
       Role salesRole = roleRepo.findById(3).get();

       // Print persons with the specified roles
       System.out.println("Persons with Role admin:");
       show(adminRole.getPersons());

       System.out.println("Persons with Role manager:");
       show(managerRole.getPersons());

       System.out.println("Persons with Role sales:");
       show(salesRole.getPersons());

       
	}
	
	public void show(List<Person> roleOfPerson) {
	    roleOfPerson.forEach(person -> System.out.println(person));
	}
}

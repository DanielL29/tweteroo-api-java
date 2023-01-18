package com.tweteroo.api.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.api.users.model.Person;

public interface H2PersonRepo extends JpaRepository<Person, Long> {

}

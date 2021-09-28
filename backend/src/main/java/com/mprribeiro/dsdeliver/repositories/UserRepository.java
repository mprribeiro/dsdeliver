package com.mprribeiro.dsdeliver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mprribeiro.dsdeliver.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}

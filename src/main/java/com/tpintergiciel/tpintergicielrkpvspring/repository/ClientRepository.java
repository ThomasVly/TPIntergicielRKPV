package com.tpintergiciel.tpintergicielrkpvspring.repository;

import com.tpintergiciel.tpintergicielrkpvspring.classes.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
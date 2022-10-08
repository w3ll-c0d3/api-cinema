package com.av1.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.av1.cinema.entity.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Integer> {

}

package com.av1.cinema.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.av1.cinema.entity.Genero;
import com.av1.cinema.repository.GeneroRepository;

@Service
public class GeneroService {
	@Autowired
	GeneroRepository generoRepository;
	
	public List<Genero> getAllGeneros() {
		return generoRepository.findAll();
	}
	
	public Genero getGeneroById(Integer id) {
		return generoRepository.findById(id).orElse(null);
	}
	
	public Genero saveGenero(Genero genero) {
		return generoRepository.save(genero);
	}
	
	public Genero updateGenero(Genero genero, Integer id) {
		Genero generoExistenteNoBanco = getGeneroById(id);
		
		generoExistenteNoBanco.setDescricao(genero.getDescricao());
		
		return generoRepository.save(generoExistenteNoBanco);
	}

	public Genero deleteGenero(Integer id) {
		generoRepository.deleteById(id);
		return getGeneroById(id);
	}

}

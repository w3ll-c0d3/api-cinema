package com.av1.cinema.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;


import com.av1.cinema.entity.Diretor;
import com.av1.cinema.entity.Filme;
import com.av1.cinema.entity.Genero;
import com.av1.cinema.repository.DiretorRepository;
import com.av1.cinema.repository.FilmeRepository;
import com.av1.cinema.repository.GeneroRepository;

@Service
public class FilmeService {
	@Autowired
	FilmeRepository filmeRepository;
	@Autowired
	GeneroRepository generoRepository;
	@Autowired
	DiretorRepository diretorRepository;
	
	public List<Filme> getAllFilmes() {
		return filmeRepository.findAll();
	}
	
	public Filme getFilmeById(Integer id) {
		return filmeRepository.findById(id).orElse(null);
	}
	
	public Filme saveFilme(Filme filme) {
        return filmeRepository.save(filme);
    }
	
	public Filme updateFilme(Filme filme, Integer id) {
		Filme filmeExistenteNoBanco = getFilmeById(id);
		
		filmeExistenteNoBanco.setNomeEn(filme.getNomeEn());
		filmeExistenteNoBanco.setNomeBr(filme.getNomeBr());
		filmeExistenteNoBanco.setAnoLancamento(filme.getAnoLancamento());
		filmeExistenteNoBanco.setGenero(filme.getGenero());
		filmeExistenteNoBanco.setSinopse(filme.getSinopse());
		filmeExistenteNoBanco.setDiretor(filme.getDiretor());
		
		return filmeRepository.save(filmeExistenteNoBanco);
	}

	public Filme deleteFilme(Integer id) {
		filmeRepository.deleteById(id);
		return getFilmeById(id);
	}
}

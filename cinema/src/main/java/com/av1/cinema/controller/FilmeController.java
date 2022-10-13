package com.av1.cinema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.webjars.NotFoundException;


import com.av1.cinema.entity.Diretor;
import com.av1.cinema.entity.Filme;
import com.av1.cinema.entity.Genero;
import com.av1.cinema.service.DiretorService;
import com.av1.cinema.service.FilmeService;
import com.av1.cinema.service.GeneroService;

@RestController
@RequestMapping("/filmes")
public class FilmeController {
//	C = Create
//	R = Read
//	U = Update
//	D = Delete
	
	@Autowired
	FilmeService filmeService;
	@Autowired
    GeneroService generoService;
	@Autowired
	DiretorService diretorService;
	
	@GetMapping("/search")
	public ResponseEntity<List<Filme>> getAllFilmes() {
		return new ResponseEntity<>(filmeService.getAllFilmes(), HttpStatus.OK);
	}

	// @GetMapping("/search")
	// public ResponseEntity<List<Filme>> getAllFilmes() {
	// 	Filme filme = filmeService.getAllFilmes();
	// 	if(filme != null) {
	// 		return new ResponseEntity<>(filme, HttpStatus.OK);
	// 	} else {
	// 		return new ResponseEntity<>(filme, HttpStatus.NOT_FOUND);
	// 	} //return new ResponseEntity<>(filmeService.getAllFilmes(), HttpStatus.OK);
	//  }

	@GetMapping("/search/{id}")
	public ResponseEntity<Filme> getFilmeById(@PathVariable Integer id) {
		Filme filme = filmeService.getFilmeById(id);
		if(filme != null) {
			return new ResponseEntity<>(filme, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(filme, HttpStatus.NOT_FOUND);
		}
	}

    @PostMapping("/save")
    public ResponseEntity<Filme> saveFilme(@RequestBody Filme filme) {
        List<Diretor> diretor = diretorService.getAllDiretores();
        List<Genero> genero = generoService.getAllGeneros();

        Boolean diretorFlag = false;
        Boolean generoFlag = false;

        for(int i = 0; i <= diretor.size() - 1; i++) {
            if(diretor.get(i).getIdDiretor() == filme.getDiretor().getIdDiretor()) {
                diretorFlag = true;
            }
        }

        for(int j = 0; j <= genero.size() - 1; j++) {
            if(genero.get(j).getIdGenero() == filme.getGenero().getIdGenero()) {
                generoFlag = true;
            }
        }

        if(diretorFlag == true && generoFlag == true) {
            return new ResponseEntity<>(filmeService.saveFilme(filme), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Filme> deleteGenero(@PathVariable Integer id) {
		Filme filme = filmeService.deleteFilme(id);
		if (filme != null) {
			return new ResponseEntity<>(filme, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(filme, HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Filme> updateFilme(@RequestBody Filme filme, @PathVariable Integer id) {
		Filme filme2 = filmeService.getFilmeById(id);
		if(filme2 != null) {
			return new ResponseEntity<>(filmeService.updateFilme(filme, id), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(filme2, HttpStatus.NOT_FOUND);
		}
	}
}

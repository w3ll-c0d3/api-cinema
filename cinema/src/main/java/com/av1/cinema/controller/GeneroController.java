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

import com.av1.cinema.entity.Genero;
import com.av1.cinema.service.GeneroService;

@RestController
@RequestMapping("/generos")
public class GeneroController {
//	C = Create
//	R = Read
//	U = Update
//	D = Delete
	
	@Autowired
	GeneroService generoService;
	
	@GetMapping("/search")
	public ResponseEntity<List<Genero>> getAllGeneros() {
		return new ResponseEntity<>(generoService.getAllGeneros(), HttpStatus.OK);
	}

	@GetMapping("/search/{id}")
	public ResponseEntity<Genero> getGeneroById(@PathVariable Integer id) {
		Genero genero = generoService.getGeneroById(id);
		if(genero != null) {
			return new ResponseEntity<>(genero, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(genero, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/save")
	public ResponseEntity<Genero> saveGenero(@RequestBody Genero genero) {
		return new ResponseEntity<>(generoService.saveGenero(genero), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Genero> deleteGenero(@PathVariable Integer id) {
		Genero genero = generoService.deleteGenero(id);
		if (genero != null) {
			return new ResponseEntity<>(genero, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(genero, HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Genero> updateGenero(@RequestBody Genero genero, @PathVariable Integer id) {
		return new ResponseEntity<>(generoService.updateGenero(genero, id), HttpStatus.OK);
	}
}

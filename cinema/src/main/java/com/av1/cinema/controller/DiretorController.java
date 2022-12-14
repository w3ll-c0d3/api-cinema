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

import com.av1.cinema.entity.Diretor;

import com.av1.cinema.service.DiretorService; 

@RestController
@RequestMapping("/diretores")
public class DiretorController {
//	C = Create
//	R = Read
//	U = Update
//	D = Delete
	
	@Autowired
	DiretorService diretorService;
		
	@GetMapping("/search")
    public ResponseEntity<List<Diretor>> getAllDiretores() {
        List<Diretor> lista = diretorService.getAllDiretores();
        if(lista.size() == 0 ){
            return new ResponseEntity<>(lista, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(lista, HttpStatus.OK);
        }
    }

	@GetMapping("/search/{id}")
	public ResponseEntity<Diretor> getDiretorById(@PathVariable Integer id) {
		Diretor diretor = diretorService.getDiretorById(id);
		if(diretor != null) {
			return new ResponseEntity<>(diretor, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(diretor, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/save")
	public ResponseEntity<Diretor> saveDiretor(@RequestBody Diretor diretor) {
		return new ResponseEntity<>(diretorService.saveDiretor(diretor), HttpStatus.CREATED);
	}
	
	@PostMapping("/saveAll")
    public ResponseEntity<List<Diretor>> saveAllDiretor(@RequestBody List<Diretor> diretor) {
        return new ResponseEntity<>(diretorService.saveAllDiretor(diretor), HttpStatus.CREATED);
    }
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Diretor> deleteDiretor(@PathVariable Integer id) {
		Diretor diretor = diretorService.deleteDiretor(id);
		if (diretor != null) {
			return new ResponseEntity<>(diretor, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(diretor, HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Diretor> updateDiretor(@RequestBody Diretor diretor, @PathVariable Integer id) {
		Diretor diretor2 = diretorService.getDiretorById(id);
		if(diretor2 != null) {
			return new ResponseEntity<>(diretorService.updateDiretor(diretor, id), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(diretor2, HttpStatus.NOT_FOUND);
		}
	}	
}

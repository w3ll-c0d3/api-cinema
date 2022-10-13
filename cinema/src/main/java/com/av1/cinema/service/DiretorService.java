package com.av1.cinema.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.av1.cinema.entity.Diretor;
import com.av1.cinema.repository.DiretorRepository;

@Service
public class DiretorService {
	@Autowired
	DiretorRepository diretorRepository;
	
	public List<Diretor> getAllDiretores() {
		// return diretorRepository.findAll();
		return diretorRepository.findAll();
	}
	
	public Diretor getDiretorById(Integer id) {
		return diretorRepository.findById(id).orElse(null);
	}
	
	public Diretor saveDiretor(Diretor diretor) {
		return diretorRepository.save(diretor);
	}
	
	public List<Diretor> saveAllDiretor(List<Diretor> diretor) {
        return diretorRepository.saveAll(diretor);
    }
	
	public Diretor updateDiretor(Diretor diretor, Integer id) {
		Diretor diretorExistenteNoBanco = getDiretorById(id);
		
		diretorExistenteNoBanco.setNome(diretor.getNome());
		
		
		return diretorRepository.save(diretorExistenteNoBanco);
	}

	public Diretor deleteDiretor(Integer id) {
		diretorRepository.deleteById(id);
		return getDiretorById(id);
	}
}

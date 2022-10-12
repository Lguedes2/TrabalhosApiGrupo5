package br.com.residencia.cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.residencia.cinema.entity.Diretor;
import br.com.residencia.cinema.repository.DiretorRepository;

@Service
public class DiretorService {
	@Autowired
	DiretorRepository diretorRepository;
	
	public List<Diretor> getAllDiretors(){
		return diretorRepository.findAll();
	}
	
	public Diretor getDiretorById(Integer id) {
		return diretorRepository.findById(id).get();
		//return DiretorRepository.findById(id).orElse(null);
	}
		
	public Diretor saveDiretor (Diretor diretor) {
		return diretorRepository.save(diretor);
	}
	
	public Diretor updateDiretor (Diretor diretor, Integer id) {
		//Diretor DiretorExistenteNoBanco = DiretorRepository.findById(id).get();
		
		Diretor diretorExistenteNoBanco = getDiretorById(id);
		
		//diretorExistenteNoBanco.setCodigoDiretor(diretor.getCodigoDiretor());
		diretorExistenteNoBanco.setFilmes(diretor.getFilmes());
		diretorExistenteNoBanco.setNomeDiretor(diretor.getNomeDiretor());
		
		return diretorRepository.save (diretorExistenteNoBanco);
		//return DiretorRepository.save (Diretor);
	}
	
	public Diretor deleteDiretor(Integer id) {
		diretorRepository.deleteById(id);
		return getDiretorById(id);
	}
	
}
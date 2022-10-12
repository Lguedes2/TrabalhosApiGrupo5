package br.com.residencia.cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.residencia.cinema.entity.Genero;
import br.com.residencia.cinema.repository.GeneroRepository;

@Service
public class GeneroService {
	@Autowired
	GeneroRepository generoRepository;
	
	public List<Genero> getAllGeneros(){
		return generoRepository.findAll();
	}
	
	public Genero getGeneroById(Integer id) {
		return generoRepository.findById(id).get();
		//return generoRepository.findById(id).orElse(null);
	}
		
	public Genero saveGenero (Genero genero) {
		return generoRepository.save(genero);
	}
	
	public Genero updateGenero (Genero genero, Integer id) {
		//Genero generoExistenteNoBanco = generoRepository.findById(id).get();
		
		Genero generoExistenteNoBanco = getGeneroById(id);
		
		//generoExistenteNoBanco.setCodigoGenero(genero.getCodigoGenero());
		generoExistenteNoBanco.setDescricao(genero.getDescricao());
		generoExistenteNoBanco.setFilmes(genero.getFilmes());
		
		return generoRepository.save (generoExistenteNoBanco);
		//return generoRepository.save (genero);
	}
	
	public Genero deleteGenero(Integer id) {
		generoRepository.deleteById(id);
		return getGeneroById(id);
	}
	
}
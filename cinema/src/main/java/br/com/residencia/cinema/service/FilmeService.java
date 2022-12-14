package br.com.residencia.cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.residencia.cinema.entity.Filme;
import br.com.residencia.cinema.repository.FilmeRepository;

@Service
public class FilmeService {
	@Autowired
	FilmeRepository filmeRepository;
	
	public List<Filme> getAllFilmes(){
		return filmeRepository.findAll();
	}
	
	public Filme getFilmeById(Integer id) {
		return filmeRepository.findById(id).get();
		//return FilmeRepository.findById(id).orElse(null);
	}
		
	public Filme saveFilme (Filme filme) {
		return filmeRepository.save(filme);
	}
	
	public Filme updateFilme (Filme filme, Integer id) {
		//Filme FilmeExistenteNoBanco = FilmeRepository.findById(id).get();
		
		Filme filmeExistenteNoBanco = getFilmeById(id);
		
		filmeExistenteNoBanco.setAnoLancamento(filme.getAnoLancamento());
		//filmeExistenteNoBanco.setCodigoFilme(filme.getCodigoFilme());
		filmeExistenteNoBanco.setDiretor(filme.getDiretor());
		filmeExistenteNoBanco.setGenero(filme.getGenero());
		filmeExistenteNoBanco.setNomeBr(filme.getNomeBr());
		filmeExistenteNoBanco.setNomeEn(filme.getNomeBr());
		filmeExistenteNoBanco.setSinopse(filme.getSinopse());
		
		return filmeRepository.save (filmeExistenteNoBanco);
		//return FilmeRepository.save (Filme);
	}
	
	public Filme deleteFilme(Integer id) {
		filmeRepository.deleteById(id);
		return getFilmeById(id);
	}
	
}
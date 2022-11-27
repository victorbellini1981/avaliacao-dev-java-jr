package br.belmicro.api.teste.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.belmicro.api.teste.configuration.Dados;
import br.belmicro.api.teste.modelo.Produto;

@Service
public class ProdutoService {

	@Autowired
	private Dados dados;
	

		
	public List<Produto> getAll(){
		return dados.getProdutos();
	}
	
	public Produto create(Produto prd) {
		prd.setId(UUID.randomUUID());
		dados.getProdutos().add(prd);
		return prd;
	}
}

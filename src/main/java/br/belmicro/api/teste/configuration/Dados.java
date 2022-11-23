package br.belmicro.api.teste.configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.belmicro.api.teste.modelo.Produto;

/*
Este bean está sendo criado apenas para criar os dados. Ele não faz parte do teste. NO lugar dele, haveria o acesso a um banco de dados.
Portanto, ignore essa classe, ao começar seu teste
*/
@Configuration
public class Dados {
	
	private static List<Produto> produtos = new ArrayList<Produto>(); 
	
	@Bean
	public void createDados() {
		addDadoList("Computador", 3000f);
		addDadoList("XBOX", 5000f);
		addDadoList("Celular Iphone", 4000f);
		addDadoList("Celular Android", 3000f);
		addDadoList("Impressora", 1000f);
		addDadoList("Televisão", 6000f);
		
	}
	
	private void addDadoList(String nome, float valor) {
		Produto prd = new Produto();
		prd.setId(UUID.randomUUID());
		prd.setNome(nome);
		prd.setValor(valor);
		
		produtos.add(prd);
	}
	
	public List<Produto> getProdutos(){
		return produtos;
	}

}

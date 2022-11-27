package br.belmicro.api.teste.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.belmicro.api.teste.modelo.Produto;
import br.belmicro.api.teste.service.ProdutoService;

@RequestMapping("v1/produtos")
@RestController
public class ProdutoController {
	
	@Autowired
	ProdutoService produtoService;
	
	@Autowired
	HttpServletRequest request;
	
	@GetMapping("/")
	public ResponseEntity<List<Produto>> getProdutos(){
		return ResponseEntity.ok(produtoService.getAll());
	}
	
	@PostMapping("/")
	public ResponseEntity<Produto> criar(@RequestBody Produto produto){
		
		produto = produtoService.create(produto);
		return ResponseEntity.status(HttpStatus.CREATED).header("location", request.getRequestURL().append(produto.getId()).toString()).body(produto);
	}

}

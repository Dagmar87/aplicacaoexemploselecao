package com.esig.aplicacaoexemploselecao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esig.aplicacaoexemploselecao.model.Responsavel;
import com.esig.aplicacaoexemploselecao.repository.ResponsavelRepository;

@RestController
@RequestMapping({ "/responsavel" })
public class ResponsavelController {

	@Autowired
	private ResponsavelRepository rep;

	// Consultar uma lista de todos responsaveis cadastrados -
	// http://localhost:8072/responsavel
	@GetMapping
	public List findAll() {

		return rep.findAll();

	}

	// Consultar um determinado responsavel cadastrado partir do id deste -
	// http://localhost:8072/responsavel/{id}
	@GetMapping(value = "{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {

		return rep.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());

	}

	// Criar um novo cadastro de um responsavel -
	// http://localhost:8072/responsavel
	@PostMapping
	public Responsavel create(@RequestBody Responsavel resp) {

		return rep.save(resp);

	}

	// Atualizar os dados de um responsavel cadastrado -
	// http://localhost:8072/responsavel/{id}
	@PutMapping(value = "{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Responsavel resp) {

		return rep.findById(id).map(r -> {
			r.setNome(resp.getNome());
			Responsavel update = rep.save(r);
			return ResponseEntity.ok().body(update);
		}).orElse(ResponseEntity.notFound().build());

	}

	// Deletar os dados do responsavel cadastrado -
	// http://localhost:8072/responsavel/{id}
	@DeleteMapping(path = "{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {

		return rep.findById(id).map(r -> {
			rep.deleteById(id);
			return ResponseEntity.ok().body("Deletado com Sucesso");
		}).orElse(ResponseEntity.notFound().build());

	}

}

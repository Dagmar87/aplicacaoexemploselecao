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

import com.esig.aplicacaoexemploselecao.model.Tarefa;
import com.esig.aplicacaoexemploselecao.repository.TarefaRepository;

@RestController
@RequestMapping({ "/tarefa" })
public class TarefaController {

	@Autowired
	private TarefaRepository rep;

	// Consultar uma lista de todas tarefas cadastradas -
	// http://localhost:8072/tarefa
	@GetMapping
	public List findAll() {

		return rep.findAll();

	}

	// Consultar uma determinada tarefa cadastrada partir do numero deste -
	// http://localhost:8072/tarefa/{numero}
	@GetMapping(value = "{numero}")
	public ResponseEntity<?> findById(@PathVariable Long numero) {

		return rep.findById(numero).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());

	}

	// Criar um novo cadastro de uma tarefa - http://localhost:8072/tarefa
	@PostMapping
	public Tarefa create(@RequestBody Tarefa tarefa) {

		return rep.save(tarefa);

	}

	// Atualizar os dados de uma tarefa cadastrada -
	// http://localhost:8072/tarefa/{numero}
	@PutMapping(value = "{numero}")
	public  ResponseEntity<?> update(@PathVariable Long numero, @RequestBody Tarefa tarefa){
		
		return rep.findById(numero)
				.map(record -> {
					record.setTitulo(tarefa.getTitulo());
					record.setDescricao(tarefa.getDescricao());
					record.setResponsavel(tarefa.getResponsavel());
					record.setPrioridade(tarefa.getPrioridade());
					record.setDeadline(tarefa.getDeadline());
					Tarefa update = rep.save(record);
					return ResponseEntity.ok().body(update);
				}).orElse(ResponseEntity.notFound().build());
		
	}

	// Deletar os dados da tarefa cadastrada -
	// http://localhost:8072/tarefa/{numero}
	@DeleteMapping(path = "{numero}")
	public ResponseEntity<?> delete(@PathVariable Long numero) {

		return rep.findById(numero).map(r -> {
			rep.deleteById(numero);
			return ResponseEntity.ok().body("Deletado com Sucesso");
		}).orElse(ResponseEntity.notFound().build());

	}

}

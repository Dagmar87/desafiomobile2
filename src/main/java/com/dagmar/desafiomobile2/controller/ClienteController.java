package com.dagmar.desafiomobile2.controller;

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

import com.dagmar.desafiomobile2.model.Cliente;
import com.dagmar.desafiomobile2.repository.ClienteRepository;

@RestController
@RequestMapping({"/cliente"})
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	// Consultar uma lista de todos clientes cadastrados -
	// http://localhost:8080/cliente
	@GetMapping
	public List findAll(){
		
		return clienteRepository.findAll();
		
	}
	
	// Consultar um determinado cliente cadastrado partir do id deste -
	// http://localhost:8080/cliente/{id}
	@GetMapping(value = "{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		
		return clienteRepository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
		
	}
	
	// Criar um novo cadastro de um cliente -
	// http://localhost:8080/cliente
	@PostMapping
	public Cliente create(@RequestBody Cliente cli){
		
		return clienteRepository.save(cli);
		
	}
	
	// Atualizar os dados de um cliente cadastrado -
	// http://localhost:8080/cliente/{id}
	@PutMapping(value = "{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Cliente cli){
		
		return clienteRepository.findById(id).map(r -> {
			r.setNome(cli.getNome());
			r.setCpf(cli.getCpf());
			r.setEndereco(cli.getEndereco());
			r.setDatanasc(cli.getDatanasc());
			Cliente update = clienteRepository.save(r);
			return ResponseEntity.ok().body(update);
		}).orElse(ResponseEntity.notFound().build());
		
	}
	
	// Apagar os dados do cliente cadastrado -
	// http://localhost:8080/nota/{id}
	@DeleteMapping(path = "{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		return clienteRepository.findById(id).map(r -> {
			clienteRepository.deleteById(id);
			return ResponseEntity.ok().body("Deletado com Sucesso");
		}).orElse(ResponseEntity.notFound().build());
		
	}

}

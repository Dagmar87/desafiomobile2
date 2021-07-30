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

import com.dagmar.desafiomobile2.model.Pedido;
import com.dagmar.desafiomobile2.repository.PedidoRepository;

@RestController
@RequestMapping({ "/pedido" })
public class PedidoController {
	
	@Autowired
	private PedidoRepository rep;
	
	// Consultar uma lista de todos pedidos cadastrados -
	// http://localhost:8080/pedido
	@GetMapping
	public List findAll(){
		
		return rep.findAll();
		
	}
	
	// Consultar um determinado pedido cadastrado partir do id deste -
	// http://localhost:8080/pedido/{id}
	@GetMapping(value = "{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		
		return rep.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
		
	}
	
	// Criar um novo cadastro de um pedido -
	// http://localhost:8080/pedido
	@PostMapping
	public Pedido create(@RequestBody Pedido ped){
		
		return rep.save(ped);
		
	}
	
	// Atualizar os dados de um pedido cadastrado -
	// http://localhost:8080/pedido/{id}
	@PutMapping(value = "{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Pedido ped){
		
		return rep.findById(id).map(r -> {
			r.setCliente(ped.getCliente());
			r.setValortotal(ped.getValortotal());
			r.setDataped(ped.getDataped());
			Pedido update = rep.save(r);
			return ResponseEntity.ok().body(update);
		}).orElse(ResponseEntity.notFound().build());
		
	}
	

	// Apagar os dados do pedido cadastrado -
	// http://localhost:8080/pedido/{id}
	@DeleteMapping(path = "{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		return rep.findById(id).map(r -> {
			rep.deleteById(id);
			return ResponseEntity.ok().body("Deletado com Sucesso");
		}).orElse(ResponseEntity.notFound().build());
		
	}

}

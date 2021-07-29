package com.dagmar.desafiomobile2.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nome", length = 255, nullable = false)
	@NotNull(message = "Nome é Obrigatório")
	@Length(max = 255, min = 3, message = "O nome deve conter entre 3 e 255 caracteres")
	private String nome;
	
	@Column(name = "cpf", length = 11, nullable = false)
	@NotNull(message = "CPF é Obrigatório")
	@Length(max = 11, message = "O CPF deve conter até 11 caracteres")
	private String cpf;
	
	@Column(name = "endereco", length = 1000, nullable = false)
	@NotNull(message = "Endereco é Obrigatório")
	@Length(max = 1000, min = 3, message = "O endereco deve conter entre 3 e 1000 caracteres")
	private String endereco;
	
	@Column(name = "datanasc", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date datanasc; 

}

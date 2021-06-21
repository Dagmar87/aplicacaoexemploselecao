package com.esig.aplicacaoexemploselecao.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tarefa")
public class Tarefa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "numero")
	private Long numero;

	@Column(name = "titulo", length = 255, nullable = false)
	@NotNull(message = "Título é Obrigatório")
	@Length(max = 255, min = 3, message = "O Título deve conter entre 3 e 255 caracteres")
	private String titulo;

	@Column(name = "descricao", length = 2000, nullable = false)
	@Length(max = 2000, message = "A Descrição deve conter até 2000 caracteres")
	private String descricao;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "responsavel_id")
	private Responsavel responsavel;

	@Column(name = "prioridade", nullable = false)
	@Enumerated(EnumType.STRING)
	private Prioridade prioridade;

	@Column(name = "deadline", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date deadline;

}

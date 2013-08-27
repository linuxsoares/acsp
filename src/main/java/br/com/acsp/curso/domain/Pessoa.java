/**
 *
 */
package br.com.acsp.curso.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import br.com.acsp.curso.util.CustomEnumEscolaridadeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author eduardobregaida
 */
@MappedSuperclass
public abstract class Pessoa implements Serializable {

	private static final long serialVersionUID = -5261337447506230696L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column
	private String nome;
	@NotBlank
	@Column
	private String rg;
	@Column
	private Long cpf;
	@Column
	private Long tituloEleitor;
	@Column
	private Long alistamentoMilitar;
	@Column
	private boolean ativo;

    @JsonSerialize(using = CustomEnumEscolaridadeSerializer.class)
	@Enumerated(EnumType.ORDINAL)
	private EscolaridadeType escolaridade;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public Long getTituloEleitor() {
		return tituloEleitor;
	}

	public void setTituloEleitor(Long tituloEleitor) {
		this.tituloEleitor = tituloEleitor;
	}

	public Long getAlistamentoMilitar() {
		return alistamentoMilitar;
	}

	public void setAlistamentoMilitar(Long alistamentoMilitar) {
		this.alistamentoMilitar = alistamentoMilitar;
	}

	public EscolaridadeType getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(EscolaridadeType escolaridade) {
		this.escolaridade = escolaridade;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}

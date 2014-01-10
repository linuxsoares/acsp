/**
 * 
 */
package br.com.acsp.curso.domain;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

/**
 * @author eduardobregaida
 * 
 */
@MappedSuperclass
@DiscriminatorValue("PILOTO")
public abstract class Piloto extends Pessoa {

	@Column
	private String nomePista;
	@Column
	private Long cma;
	@Column
	private Long cht;
	@Column
	private Long codigoANAC;
    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "aeronave_piloto", joinColumns = { @JoinColumn(name = "piloto_id") }, inverseJoinColumns = { @JoinColumn(name = "aeronave_id") })
	private List<Aeronave> aeronaves;

	public String getNomePista() {
		return nomePista;
	}

	public void setNomePista(String nomePista) {
		this.nomePista = nomePista;
	}

	public Long getCma() {
		return cma;
	}

	public void setCma(Long cma) {
		this.cma = cma;
	}

	public Long getCht() {
		return cht;
	}

	public void setCht(Long cht) {
		this.cht = cht;
	}

	public Long getCodigoANAC() {
		return codigoANAC;
	}

	public void setCodigoANAC(Long codigoANAC) {
		this.codigoANAC = codigoANAC;
	}

	public List<Aeronave> getAeronaves() {
		return aeronaves;
	}

	public void setAeronaves(List<Aeronave> aeronaves) {
		this.aeronaves = aeronaves;
	}

}

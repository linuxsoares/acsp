/**
 *
 */
package br.com.acsp.curso.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author pedrosa
 */

@Entity
public class Agenda implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @DateTimeFormat(style = "S-")
	@Column
	private Date dataReserva;

	@ManyToOne
	@JoinColumn(name = "aeronave_id")
	private Aeronave aeronave;

	@ManyToOne
	@JoinColumn(name = "instrutor_id")
	private Instrutor instrutor;

	@ManyToOne
	@JoinColumn(name = "aula_id")
	private Aula aula;

	@ManyToOne
	@JoinColumn(name = "aluno_id")
	private Aluno aluno;

	@ManyToOne
	@JoinColumn(name = "socio_id")
	private Socio socio;
	
	@ManyToOne
	@JoinColumn(name = "horario_id")
	private Horario horario; 

	@Column
	private Integer qtdeHoras;

	@Column
	private boolean flag360milhas;

	@Column
	private boolean flagVooNoturno;// >16:00

	@Column
	private boolean flagVooMatutinoEspecial;// <09:00

	@Column
	private boolean flagPresenca;

	@Enumerated(EnumType.STRING)
	private StatusType status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataReserva() {
		return dataReserva;
	}

	public void setDataReserva(Date dataReserva) {
		this.dataReserva = dataReserva;
	}

	public Aeronave getAeronave() {
		return aeronave;
	}

	public void setAeronave(Aeronave aeronave) {
		this.aeronave = aeronave;
	}

	public Instrutor getInstrutor() {
		return instrutor;
	}

	public void setInstrutor(Instrutor instrutor) {
		this.instrutor = instrutor;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public Integer getQtdeHoras() {
		return qtdeHoras;
	}

	public void setQtdeHoras(Integer qtdeHoras) {
		this.qtdeHoras = qtdeHoras;
	}

	public boolean isFlag360milhas() {
		return flag360milhas;
	}

	public void setFlag360milhas(boolean flag360milhas) {
		this.flag360milhas = flag360milhas;
	}

	public boolean isFlagVooNoturno() {
		return flagVooNoturno;
	}

	public void setFlagVooNoturno(boolean flagVooNoturno) {
		this.flagVooNoturno = flagVooNoturno;
	}

	public boolean isFlagVooMatutinoEspecial() {
		return flagVooMatutinoEspecial;
	}

	public void setFlagVooMatutinoEspecial(boolean flagVooMatutinoEspecial) {
		this.flagVooMatutinoEspecial = flagVooMatutinoEspecial;
	}

	public boolean isFlagPresenca() {
		return flagPresenca;
	}

	public void setFlagPresenca(boolean flagPresenca) {
		this.flagPresenca = flagPresenca;
	}

	public StatusType getStatus() {
		return status;
	}

	public void setStatus(StatusType status) {
		this.status = status;
	}
	
}

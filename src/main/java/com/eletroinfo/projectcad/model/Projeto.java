package com.eletroinfo.projectcad.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.hibernate.annotations.NotFound;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.jmx.export.annotation.ManagedNotification;
import org.springframework.jmx.export.annotation.ManagedNotifications;


@Entity
@Table(name = "projeto")
public class Projeto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@NotBlank(message = "Nome do projeto é obrigatório!")
	@Size(min = 4, max = 20, message = "Nome deve conter entre 4 e 20 dígitos")
	private String nome;
	
	@Column(name = "data_inicio")
	private Date dataInicio;
	
	@Column(name = "data_fim")
	private Date dataFim;
	
	@Transient
	private String dataInicioJs;
	
	@Transient
	private String dataFimJs;
	
	@PositiveOrZero(message = "Data Inicio deve ser menor ou igual a data fim!")
	private Integer duracao;
	
	@NotNull(message = "Escolha o Status!")
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@NotBlank(message = "Descrição é obrigatória!")
	private String descricao;
	
	public boolean isNovo() {
		return codigo == null;
	}
	
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	
	public String getDataInicioJs() {
		return dataInicioJs;
	}

	public void setDataInicioJs(String dataInicioJs) {
		this.dataInicioJs = dataInicioJs;
	}

	public String getDataFimJs() {
		return dataFimJs;
	}

	public void setDataFimJs(String dataFimJs) {
		this.dataFimJs = dataFimJs;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Integer getDuracao() {
		return duracao;
	}
	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Projeto other = (Projeto) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
}
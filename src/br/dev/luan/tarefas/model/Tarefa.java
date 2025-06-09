package br.dev.luan.tarefas.model;

import java.time.LocalDateTime;

public class Tarefa {

	private String codigo;
	private String titulo;
	private String descricao;
	private LocalDateTime dataInicio;
	private LocalDateTime dataPrazo;
	private LocalDateTime dataConclusao;
	private Funcionario responsavel;
	private Status status;
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDateTime dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDateTime getDataPrazo() {
		return dataPrazo;
	}

	public void setDataPrazo(LocalDateTime dataPrazo) {
		this.dataPrazo = dataPrazo;
	}

	public LocalDateTime getDataConclusao() {
		return dataConclusao;
	}

	public void setDataConclusao(LocalDateTime dataConclusao) {
		this.dataConclusao = dataConclusao;
	}

	public Funcionario getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Funcionario responsavel) {
		this.responsavel = responsavel;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return this.codigo + "," + this.titulo + "," + this.status + "," + this.descricao + "," + this.responsavel + ","
				+ this.dataInicio + "," + this.dataConclusao + "," + this.dataPrazo + "\n";
	}

}

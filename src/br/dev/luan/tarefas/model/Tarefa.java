package br.dev.luan.tarefas.model;

import java.time.LocalDateTime;

public class Tarefa {
	private int codigo;
	private String titulo;
	private String descricao;
	private LocalDateTime dataInicio;
	private LocalDateTime dataPrazo;
	private LocalDateTime dataConclusao;
	private Funcionario responsavel;
	
	public Tarefa(String titulo, String descrica) {
		
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

	public Funcionario getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Funcionario responsavel) {
		this.responsavel = responsavel;
	}

	public int getCodigo() {
		return codigo;
	}

	public LocalDateTime getDataConclusao() {
		return dataConclusao;
	}


}

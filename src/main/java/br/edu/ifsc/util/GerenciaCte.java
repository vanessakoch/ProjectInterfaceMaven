package br.edu.ifsc.util;

public class GerenciaCte {
	private String id;
	private String data;
	private String remetente;
	private String situacao;
	private String valorNota;

	public GerenciaCte(String id, String data, String remetente, String situacao, String valorNota) {
		super();
		this.id = id;
		this.data = data;
		this.remetente = remetente;
		this.situacao = situacao;
		this.valorNota = valorNota;
	}

	public String getId() {
		return id;
	}

	public String getData() {
		return data;
	}

	public String getRemetente() {
		return remetente;
	}

	public String getSituacao() {
		return situacao;
	}

	public String getValorNota() {
		return valorNota;
	}

}

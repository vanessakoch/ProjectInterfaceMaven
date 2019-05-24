package br.edu.ifsc.util;

public class GerenciaMdfe {
	private String numero;
	private String emissao;
	private String chaveAcesso;
	private String veiculo;
	private String situacao;

	public GerenciaMdfe(String numero, String emissao, String chaveAcesso, String veiculo, String situacao) {
		super();
		this.numero = numero;
		this.emissao = emissao;
		this.chaveAcesso = chaveAcesso;
		this.veiculo = veiculo;
		this.situacao = situacao;
	}

	public String getNumero() {
		return numero;
	}

	public String getEmissao() {
		return emissao;
	}

	public String getChaveAcesso() {
		return chaveAcesso;
	}

	public String getVeiculo() {
		return veiculo;
	}

	public String getSituacao() {
		return situacao;
	}

}

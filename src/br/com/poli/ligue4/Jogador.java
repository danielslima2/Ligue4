package br.com.poli.ligue4;

public class Jogador extends Pessoa{
	

	private int jogaVal;
	//CONSTRUTOR DE JOGADOR
	public Jogador(String nome, int val) {
		super(nome);
		this.jogaVal = val;	
	}
	
	//RETORNA UMA STRING COM O NOME E O VALOR DO JOGADOR
	@Override
	public String toString() {
		return "("+this.jogaVal+")"+" O nome do jogador é "+ super.getNome();
	}
	
	public int getJogaVal() {
		return jogaVal;
	}	
}
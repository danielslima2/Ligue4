package br.com.poli.ligue4;

public class Pessoa {

		private String nome;
		
		//CONSTRUTOR DE PESSOA
		public Pessoa (String nome) {
			this.nome = nome;
		}
		//RETORNA O NOME DA PESSOA
		public String toString() {
			return " nome do jogador é"+ this.nome;
		}
			
		
		public String getNome() {
			return nome;
		}
}
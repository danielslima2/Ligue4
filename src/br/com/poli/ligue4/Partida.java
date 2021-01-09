package br.com.poli.ligue4;

public class Partida {
		private Jogador joga1 = null;
		private Jogador joga2 = null;
		private boolean gameOver = false;
		private boolean vencedor;
		private Tabuleiro tabuleiro1 = new Tabuleiro(6,7);
	
		public Partida(String nomeJogador1, String nomeJogador2) {
		    joga1 = new Jogador(nomeJogador1, 1);
		    joga2 = new Jogador(nomeJogador2, 2);
		}

		//RECEBE A JOGARA REFERENTE À COLUNA E O VALOR DO JOGADOR FAZENDO TODAS CHECAGENS
		public void fazerJogada(int x, int jogaVal) {
			if(jogaVal ==1) {
				tabuleiro1.receberPosicao(x,jogaVal);
				vitoriaVertical(x);
				vitoriaHorizontal();
				vitoriaDiagonalDireita();
				vitoriaDiagonalEsquerda();
				gameOver();
			}
			else {
				tabuleiro1.receberPosicao(x,jogaVal);		
				vitoriaVertical(x);
				vitoriaHorizontal();
				vitoriaDiagonalDireita();
				vitoriaDiagonalEsquerda();
				gameOver();
			}
		}
		//VERIFICAÇAO VITORIA VERTICAL
		public void vitoriaVertical(int x) {
			for (int i=0; i<3; i++) {
					if(tabuleiro1.getMatriz(i, x)==tabuleiro1.getMatriz(i+1, x) && tabuleiro1.getMatriz(i+2, x)==tabuleiro1.getMatriz(i+3, x)
						&& tabuleiro1.getMatriz(i, x)==tabuleiro1.getMatriz(i+3, x) && tabuleiro1.getMatriz(i, x)!= 0) {
						vencedor = true;
					}
				}
			}
		//VERIFICAÇAO VITORIA HORIZONTAL
		public void vitoriaHorizontal() {
				for(int i=0; i<6; i++){
					for(int j=0; j<4; j++) {
						if(tabuleiro1.getMatriz(i, j)==tabuleiro1.getMatriz(i, j+1) && tabuleiro1.getMatriz(i, j+2)==tabuleiro1.getMatriz(i,j+3)
							&&tabuleiro1.getMatriz(i, j)==tabuleiro1.getMatriz(i, j+3)&& tabuleiro1.getMatriz(i, j)!= 0) {
						vencedor = true;
					}
		        }
			}		
		}		
		//VERIFICAÇAO VITORIA DIAGONAL SUBINDO
		public void vitoriaDiagonalDireita() {
			for(int i=0; i<3; i++){
				for(int j=0; j<4; j++) {
					if(tabuleiro1.getMatriz(i, j)==tabuleiro1.getMatriz(i+1, j+1) && tabuleiro1.getMatriz(i+2, j+2)==tabuleiro1.getMatriz(i+3,j+3)
						&&tabuleiro1.getMatriz(i, j)==tabuleiro1.getMatriz(i+3, j+3)&& tabuleiro1.getMatriz(i, j)!= 0) {
					vencedor = true;
				}
	        }
		}		
	}	
		//VERIFICAÇAO VITORIA DIAGONAL DESCENDO
		public void vitoriaDiagonalEsquerda() {
			for(int i=3; i<6; i++){
				for(int j=0; j<4; j++) {
					if(tabuleiro1.getMatriz(i, j)==tabuleiro1.getMatriz(i-1, j+1) && tabuleiro1.getMatriz(i-2, j+2)==tabuleiro1.getMatriz(i-3,j+3)
						&&tabuleiro1.getMatriz(i, j)==tabuleiro1.getMatriz(i-3, j+3)&& tabuleiro1.getMatriz(i, j)!= 0) {
					vencedor = true;
				}
	        }
		}		
	}		
		//VERIFICA A ULTIMA LINHA DO TABULEIRO PARA VER SE ESTA VAZIA
		public void gameOver() {
				if(tabuleiro1.getMatriz(5, 0)!=0 && tabuleiro1.getMatriz(5, 1)!=0 && tabuleiro1.getMatriz(5, 2)!=0 &&
					tabuleiro1.getMatriz(5, 3)!=0 && tabuleiro1.getMatriz(5, 4)!=0 && tabuleiro1.getMatriz(5, 5)!=0 &&
					tabuleiro1.getMatriz(5, 5)!=0 && tabuleiro1.getMatriz(5, 6)!=0 ) {
						gameOver = true;
					}
		}
		public Tabuleiro getTabuleiro() {
			return tabuleiro1;
		}
		
		public Jogador getJoga1() {
			return joga1;
		}
		public Jogador getJoga2() {
			return joga2;
		}

		public boolean isVencedor() {
			return vencedor;
		}


		public boolean isGameOver() {
			return gameOver;
		}
}
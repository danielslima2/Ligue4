package br.com.poli.ligue4;

import java.util.Scanner;

public class Tabuleiro {
		Scanner sc = new Scanner(System.in);
		private int x=6;
		private int y=7;
		
		private int v[][] = new int [x][y];
		
		public Tabuleiro (int x, int y) {
			this.x =x;
			this.y =y;
		}
		
		//VERIFICA SE A JOGADA É VALIDA, SE NAO FOR DEVOLVE UM ERRO
		public void validaJogada(int x) throws Exception{
			if(x>6 || x<0 || v[5][x]==1 || v[5][x]==2) {
				throw new Exception("Coluna cheia");
			}
		}
		
		
		//DEFINI SE A JOGADA É 1 OU 2 COM BASE NO jogaVal
		public void receberPosicao(int y, int jogaVal){		
				for(int i=0; i<6; i++) {
					if(v[i][y] == 0) {
						if(jogaVal==1) {
						v[i][y]=1;
						break;
						}
						else {
							v[i][y]=2;
							break;
							}
						}
					}	
				}
		//RETORNA O TABULEIRO EM STRING
		public String toString() {
				return " (0) (1) (2) (3) (4) (5) (6) \n"+
				"|---.---.---.---.---.---.---|\n"+
				"| "+v[5][0]+" . "+v[5][1]+" . "+v[5][2]+" . "+v[5][3]+" . "+v[5][4]+" . "+v[5][5]+" . "+v[5][6]+ " |\n"+
				"|---.---.---.---.---.---.---|\n"+
				"| "+v[4][0]+" . "+v[4][1]+" . "+v[4][2]+" . "+v[4][3]+" . "+v[4][4]+" . "+v[4][5]+" . "+v[4][6]+ " |\n"+
				"|---.---.---.---.---.---.---|\n"+
				"| "+v[3][0]+" . "+v[3][1]+" . "+v[3][2]+" . "+v[3][3]+" . "+v[3][4]+" . "+v[3][5]+" . "+v[3][6]+ " |\n"+
				"|---.---.---.---.---.---.---|\n"+
				"| "+v[2][0]+" . "+v[2][1]+" . "+v[2][2]+" . "+v[2][3]+" . "+v[2][4]+" . "+v[2][5]+" . "+v[2][6]+ " |\n"+
				"|---.---.---.---.---.---.---|\n"+
				"| "+v[1][0]+" . "+v[1][1]+" . "+v[1][2]+" . "+v[1][3]+" . "+v[1][4]+" . "+v[1][5]+" . "+v[1][6]+ " |\n"+
				"|---.---.---.---.---.---.---|\n"+
				"| "+v[0][0]+" . "+v[0][1]+" . "+v[0][2]+" . "+v[0][3]+" . "+v[0][4]+" . "+v[0][5]+" . "+v[0][6]+ " |\n"+
				"|---.---.---.---.---.---.---|";
				}
		
		public int getMatriz(int x, int y) {
			return this.v[x][y];
		}
}
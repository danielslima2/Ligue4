package br.com.poli.main;
import javax.swing.JOptionPane;
import br.com.poli.ligue4.Partida;

/*
 * Alunos:  Daniel Salgueiro Lima
 * 			Luis Otavio C. Mingati		
 */



public class Main {
	

	
	public static void main(String[] args) {
	
	int x, jogaVal;
	String nome1, nome2;
	
	nome1 = JOptionPane.showInputDialog("Jogador 1, escreva seu nome: ");
	nome2 = JOptionPane.showInputDialog("Jogador 2, escreva seu nome: ");
	Partida ligue4 = new Partida(nome1, nome2);
	JOptionPane.showMessageDialog(null, ligue4.getTabuleiro().toString());
	JOptionPane.showMessageDialog(null, ligue4.getJoga1().toString());
	JOptionPane.showMessageDialog(null, ligue4.getJoga2().toString());
	JOptionPane.showMessageDialog(null, ligue4.getJoga1().getNome()+ " faça sua jogada.");

	for(int n =0; ligue4.isVencedor() ==false || ligue4.isGameOver() ==false ; n++) {
		//PEDE A JOGADA DOS JOGADORES
		x = Integer.parseInt(JOptionPane.showInputDialog(null, "informe sua jogada "));
		
		if(n%2==0) {
			try {
			ligue4.getTabuleiro().validaJogada(x); 
			jogaVal =1;	
			ligue4.fazerJogada(x,jogaVal);
			//CASO HAJA UM VENCEDOR TERMINA O JOGO
			if (ligue4.isVencedor()==true) {
				JOptionPane.showMessageDialog(null, ligue4.getJoga1().getNome()+ " ganhou!!!");
				JOptionPane.showMessageDialog(null, ligue4.getTabuleiro().toString());
				break;
			}
			//CASO NAO HAJA NENHUM VENCEDOR DETERMINA O EMPATE
			if(ligue4.isGameOver()==true) {
				JOptionPane.showMessageDialog(null, "Empate!");
				JOptionPane.showMessageDialog(null, ligue4.getTabuleiro().toString());
				break;
			}
			//PRINTA TABULEIRO E QUEM FOI O ULTIMO A JOGAR
			JOptionPane.showMessageDialog(null, ligue4.getTabuleiro().toString());
			JOptionPane.showMessageDialog(null, "Jogador "+ligue4.getJoga1().getNome()+" fez a jogada: "+x);
			JOptionPane.showMessageDialog(null, ligue4.getJoga2().getNome()+ " faça sua jogada.");
		}	
				catch (Exception jogadaInvalida) {
				JOptionPane.showMessageDialog(null, "-1");
				n++;
				}
			}
		else {
			try {
			ligue4.getTabuleiro().validaJogada(x);
			jogaVal =2;
			ligue4.fazerJogada(x,jogaVal);
			//CASO HAJA UM VENCEDOR TERMINA O JOGO
			if (ligue4.isVencedor() ==true) {
				JOptionPane.showMessageDialog(null, ligue4.getJoga2().getNome() + " ganhou!!!");
				JOptionPane.showMessageDialog(null, ligue4.getTabuleiro().toString());
				break;
			}
			//CASO NAO HAJA NENHUM VENCEDOR DETERMINA O EMPATE
			if(ligue4.isGameOver()==true) {
				JOptionPane.showMessageDialog(null, "Empate!");
				JOptionPane.showMessageDialog(null, ligue4.getTabuleiro().toString());
				break;
			}
			//PRINTA TABULEIRO E QUEM FOI O ULTIMO A JOGAR
			JOptionPane.showMessageDialog(null, ligue4.getTabuleiro().toString());
			JOptionPane.showMessageDialog(null, "Jogador "+ligue4.getJoga2().getNome()+" fez a jogada: "+x);
			JOptionPane.showMessageDialog(null, ligue4.getJoga1().getNome()+ " faça sua jogada.");
		}	
			catch(Exception jogadaInvalida) {
			JOptionPane.showMessageDialog(null, "-1");
			n++;
		}
			}
				}
	
	
	}	
}
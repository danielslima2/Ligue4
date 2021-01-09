package br.com.poli.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.poli.ligue4.Jogador;
import br.com.poli.ligue4.Partida;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class Ligue4 extends JFrame {

	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ligue4 janela = new Ligue4();
					janela.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	JFrame frame = new JFrame();
	public Ligue4() {
		setForeground(Color.CYAN);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(460, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("JOGAR");
		button.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
		button.setForeground(Color.BLACK);
		button.setBackground(Color.GREEN);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					frame.dispose();
					
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
		});
		button.setBounds(142, 129, 157, 60);
		contentPane.add(button);
		
		JLabel lblNewLabel = new JLabel("LIGUE 4");
		lblNewLabel.setFont(new Font("MV Boli", Font.PLAIN, 52));
		lblNewLabel.setBounds(110, 11, 217, 107);
		contentPane.add(lblNewLabel);
		
		

		
		
	

	}
}

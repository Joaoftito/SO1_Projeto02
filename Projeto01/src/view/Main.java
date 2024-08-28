package view;

import javax.swing.JOptionPane;
import controller.RedesController;

public class Main {
	
	public static void main(String[] args) {
		RedesController mod = new RedesController();
		int num = 0;
		
		while (num != 9) {
			num = Integer.parseInt(JOptionPane.showInputDialog("Escolha um método para rodar: \n\n 1 - Método IP \n 2 - Método PING \n 9 - Finalizar programa"));
			
			switch (num) {
				case 1: mod.ip();
				break;
				case 2: mod.ping();
				break;
				case 9: JOptionPane.showMessageDialog(null, "Programa finalizado!");
				break;
				default: JOptionPane.showMessageDialog(null, "Opção inválida!");
				break;
			}
		}
	}

}
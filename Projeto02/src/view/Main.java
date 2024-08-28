package view;

import javax.swing.JOptionPane;
import controller.KillController;

public class Main {
	
	public static void main(String[] args) {
		KillController mod = new KillController();
		int num = 0;
		String valor = "";
		
		while (num != 9) {
			num = Integer.parseInt(JOptionPane.showInputDialog("Escolha um método para rodar: \n\n 1 - Ver lista dos processos ativos \n 2 - Matar processo por PID \n 3 - Matar processo por nome \n 9 - Finalizar programa"));
			
			switch (num) {
				case 1: mod.listaProcessos();
				break;
				case 2: mod.mataPid(valor = JOptionPane.showInputDialog("Digite o Pid do processo desejado para ser encerrado"));
				break;
				case 3: mod.mataNome(valor = JOptionPane.showInputDialog("Digite o nome do processo desejado para ser encerrado"));
				break;
				case 9: JOptionPane.showMessageDialog(null, "Programa finalizado!");
				break;
				default: JOptionPane.showMessageDialog(null, "Opção inválida!");
				break;
			}
		}

	}

}

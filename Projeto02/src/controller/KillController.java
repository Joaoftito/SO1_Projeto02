package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {
	
	public KillController() {
		super();
	}
	
	private String os() {
		String os = System.getProperty("os.name");
		return os;
	}
	
	public void listaProcessos() {
		String os = os();
		String proc = "TASKLIST /FO TABLE";
		String[] vetor = os.split(" ");
		
		if (vetor[0].contains("Windows")) {
			vetor = proc.split(" ");
			
			try {
				Process p = Runtime.getRuntime().exec(vetor);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				
				while (linha != null) {
					System.out.println(linha);
					linha = buffer.readLine();
				}
				
				buffer.close();
				leitor.close();
				fluxo.close();
			} catch (Exception e){
				System.err.println(e.getMessage());
			}
			
		} else {
			if (vetor[0].contains("Linux")) {
				proc = "ps -ef";
				vetor = proc.split(" ");
				
				try {
					Process p = Runtime.getRuntime().exec(vetor);
					InputStream fluxo = p.getInputStream();
					InputStreamReader leitor = new InputStreamReader(fluxo);
					BufferedReader buffer = new BufferedReader(leitor);
					String linha = buffer.readLine();
					
					while (linha != null) {
						System.out.println(linha);
						linha = buffer.readLine();
					}
					
					buffer.close();
					leitor.close();
					fluxo.close();
				} catch (Exception e){
					System.err.println(e.getMessage());
				}
			}

		}
	}
	
	public void mataPid(String valor) {
		String os = os();
		String[] vetor = os.split(" ");
		
		String cmd = "TASKKILL /PID";
		StringBuffer buffer = new StringBuffer();
		int pid = 0;
		
		if(vetor[0].contains("Windows")) {
			vetor = cmd.split(" ");
			
			try {
				pid = Integer.parseInt(valor);
				buffer.append(cmd);
				buffer.append(" ");
				buffer.append(pid);
				
			} catch (Exception e) {
				System.err.println("Digite um PID válido!");	
			}
			
			String matar = buffer.toString();
			vetor = matar.split(" ");
			
			try {
				Runtime.getRuntime().exec(vetor);
				
			} catch (Exception e) {
			}
			
		} else {
			if (vetor[0].contains("Linux")) {
				cmd = "kill -9";
				vetor = cmd.split(" ");
				
				try {
					pid = Integer.parseInt(valor);
					buffer.append(cmd);
					buffer.append(" ");
					buffer.append(pid);

				} catch (Exception e) {
					System.err.println("Digite um PID válido!");
				}
				
				String matar = buffer.toString();
				vetor = matar.split(" ");
				
				try {
					Runtime.getRuntime().exec(vetor);
					
				} catch (Exception e) {
				}
			}
		}
	}
	
	public void mataNome(String valor) {
		String os = os();
		String[] vetor = os.split(" ");
		
		String cmd = "TASKKILL /IM";
		StringBuffer buffer = new StringBuffer();
		
		if(vetor[0].contains("Windows")) {
			vetor = cmd.split(" ");
			
			try {
				buffer.append(cmd);
				buffer.append(" ");
				buffer.append(valor);
				
			} catch (Exception e) {
				System.err.println("Digite um nome válido!");	
			}
			
			String matar = buffer.toString();
			vetor = matar.split(" ");
			
			try {
				Runtime.getRuntime().exec(vetor);
				
			} catch (Exception e) {
			}
			
		} else {
			if (vetor[0].contains("Linux")) {
				cmd = "pkill -f";
				vetor = cmd.split(" ");
				
				try {
					buffer.append(cmd);
					buffer.append(" ");
					buffer.append(valor);

				} catch (Exception e) {
					System.err.println("Digite um nome válido!");
				}
				
				String matar = buffer.toString();
				vetor = matar.split(" ");
				
				try {
					Runtime.getRuntime().exec(vetor);
					
				} catch (Exception e) {
				}
			}
		}
	}
}
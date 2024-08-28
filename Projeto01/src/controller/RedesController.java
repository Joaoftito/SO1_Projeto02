package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {
	
	public RedesController() {
		super();
	}
	
	private String os() {
		String os = System.getProperty("os.name");
		return os;
	}
	
	public void ip() {
		String os = os();
		String ip = "ipconfig";
		String[] vetor = os.split(" ");
		
		if (vetor[0].contains("Windows")) {
			vetor = ip.split(" ");
			
			try {
				Process p = Runtime.getRuntime().exec(vetor);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				String adaptador = "";
				
				while (linha != null) {
					
					if(linha.contains("Adaptador")) {
						adaptador = linha;
						linha = buffer.readLine();
					}
					
					if(linha.contains("IPv4")) {
						System.out.println(adaptador);
						System.out.println(linha);
						linha = buffer.readLine();
					}
					
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
				ip = "ip addr";
				vetor = ip.split(" ");
				
				try {
					Process p = Runtime.getRuntime().exec(vetor);
					InputStream fluxo = p.getInputStream();
					InputStreamReader leitor = new InputStreamReader(fluxo);
					BufferedReader buffer = new BufferedReader(leitor);
					String linha = buffer.readLine();
					
					while (linha != null) { 
						
						if(linha.contains("link")) {
							vetor = linha.split(" ");
							linha = buffer.readLine();
						}
						
						if(linha.contains("inet")) {
							System.out.println(vetor[4]);
							
							vetor = linha.split(" ");
							System.out.println(vetor[4] + " " + vetor[5]);
							linha = buffer.readLine();
							linha = buffer.readLine();
							linha = buffer.readLine();
						}
						
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

	
	public void ping() {
		String os = os();
		String ping = "ping -4 -n 10 www.google.com.br";
		String[] vetor = os.split(" ");
		
		if (vetor[0].contains("Windows")) {
			vetor = ping.split(" ");
			
			try {
				Process p = Runtime.getRuntime().exec(vetor);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				
				while (linha != null) {
					
					if(linha.contains("ximo")) {
						vetor = linha.split(" ");
						System.out.println(vetor[10] + " " + vetor[11] + " " + vetor[12]);
					}
					
					linha = buffer.readLine();
				}
				
				buffer.close();
				leitor.close();
				fluxo.close();
				
			} catch (Exception e){
				System.err.println(e.getMessage());
			}
		}
		
		if (vetor[0].contains("Linux")) {
			ping = "ping -4 -c 10 www.google.com.br";
			vetor = ping.split(" ");
			
			try {
				Process p = Runtime.getRuntime().exec(vetor);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				
				while (linha != null) {
					
					if(linha.contains("rtt")) {
						vetor = linha.split(" ");
						String[] vetor2 = linha.split("/");
						System.out.println(vetor2[1] + " " + vetor2[4] + " " + vetor[4]);
					}
					
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
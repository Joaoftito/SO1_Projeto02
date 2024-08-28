package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DistroController {
	
	public DistroController() {
		super();
	}
	
	private String os() {
		String os = System.getProperty("os.name");
		return os;
	}
	
	public void exibeDistro() {
		String os = os();
		String[] vetor = os.split(" ");
		
		String proc = "cat /etc/os-release";
		
		if (vetor[0].contains("Windows")) {
			System.out.println("Não será possível verificar o nome e a versão pois o sistema operacional não é Linux!");
			
		} else {
			if(vetor[0].contains("Linux")) {
				vetor = proc.split(" ");
				
				try {
					Process p = Runtime.getRuntime().exec(vetor);
					InputStream fluxo = p.getInputStream();
					InputStreamReader leitor = new InputStreamReader(fluxo);
					BufferedReader buffer = new BufferedReader(leitor);
					String linha = buffer.readLine();
					
					while (linha != null) {
						
						if (linha.contains("PRETTY")) {
							linha = buffer.readLine();
							System.out.println(linha);
						}
						
						if (linha.contains("VERSION=")) {
							vetor = linha.split(" ");
							System.out.println(vetor[0] + "\"");
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

}

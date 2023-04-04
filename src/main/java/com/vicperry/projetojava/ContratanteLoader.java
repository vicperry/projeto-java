package com.vicperry.projetojava;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.vicperry.projetojava.model.domain.Contratante;
import com.vicperry.projetojava.model.domain.Usuario;
import com.vicperry.projetojava.model.service.ContratanteService;

@Order(2)
@Component
public class ContratanteLoader implements ApplicationRunner {
	@Autowired
	private ContratanteService contratanteService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		try {
			String arq = "contratantes.txt";
			
			try {
				FileReader fileR = new FileReader(arq);
				BufferedReader leitura = new BufferedReader(fileR);

				String linha = leitura.readLine();			
				String[] campos = null;

				while(linha != null) {
					
					campos = linha.split(";");
					
					Usuario usuario = new Usuario();
					usuario.setId(1);
										
					Contratante contratante = new Contratante(
							campos[0], 
							campos[1], 
							campos[2]
						);
					contratante.setUsuario(usuario);
					
					contratanteService.incluir(contratante);

					System.out.println("A inclusão do solicitante "+contratante.getNome()+" foi realizada com sucesso!!!");

					linha = leitura.readLine();
				}

				leitura.close();
				fileR.close();
			} catch (IOException e) {
				System.out.println("[ERRO] " + e.getMessage());
			} 
			
		} finally {
			System.out.println("Processamento realizado com sucesso!!!");
		}
		
	}
	
	
}

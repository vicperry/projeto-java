package com.vicperry.projetojava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.vicperry.projetojava.model.domain.Magico;
import com.vicperry.projetojava.model.domain.Usuario;
import com.vicperry.projetojava.model.service.MagicoService;

@Order(4)
@Component
public class MagicoLoader implements ApplicationRunner {
	@Autowired
	private MagicoService magicoService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Usuario admin = new Usuario();
		admin.setId(1);
		
		try {
			Magico magico = new Magico("Zatara",200,"95919-1785");
			magico.setFazPirotecnia(true);
			magico.setNumeroTruques(5);
			magico.setUsaCoelho(false);
			magico.setUsuario(admin);
			System.out.println(magico.toString());
			System.out.println("Salário-hora do mágico = R$" + magico.calcularValorHora());

			magicoService.incluir(magico);
		} catch (Exception e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Magico magico = new Magico("Mandrake",200,"95919-2783");
			magico.setFazPirotecnia(false);
			magico.setUsaCoelho(false);
			magico.setNumeroTruques(2);
			magico.setUsuario(admin);
			System.out.println(magico.toString());
			System.out.println("Salário-hora do mágico = R$" + magico.calcularValorHora());

			magicoService.incluir(magico);
		} catch (Exception e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
			Magico magico = new Magico("Zatanna",100,"95919-3775");
			magico.setFazPirotecnia(true);
			magico.setNumeroTruques(7);
			magico.setUsaCoelho(true);
			magico.setUsuario(admin);
			System.out.println(magico.toString());
			System.out.println("Salário-hora do mágico = R$" + magico.calcularValorHora());

			magicoService.incluir(magico);
		} catch (Exception e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		System.out.println("Listagem de Mágicos:");
		for(Magico magico : magicoService.obterLista()) {
			System.out.println(magico.getId() + " " + magico.toString());
		}
	}

}

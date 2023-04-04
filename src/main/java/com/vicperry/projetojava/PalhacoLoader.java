package com.vicperry.projetojava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.vicperry.projetojava.model.domain.Palhaco;
import com.vicperry.projetojava.model.domain.Usuario;
import com.vicperry.projetojava.model.service.PalhacoService;

@Order(3)
@Component
public class PalhacoLoader implements ApplicationRunner {
	
	@Autowired
	private PalhacoService palhacoService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Usuario admin = new Usuario();
		admin.setId(1);
		
		try {
			Palhaco palhaco = new Palhaco("Pedro",100,"95919-8785");
			palhaco.setHumorAdulto(true);
			palhaco.setNomeArtistico("Patati");
			palhaco.setTamanhoSapato(50);
			palhaco.setUsuario(admin);
			System.out.println(palhaco.toString());
			System.out.println("Salário-hora do palhaço = R$" + palhaco.calcularValorHora());

			palhacoService.incluir(palhaco);
		} catch (Exception e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Palhaco palhaco = new Palhaco("Mario",100,"95919-8783");
			palhaco.setHumorAdulto(false);
			palhaco.setNomeArtistico("Patata");
			palhaco.setTamanhoSapato(42);
			palhaco.setUsuario(admin);
			System.out.println(palhaco.toString());
			System.out.println("Salário-hora do palhaço = R$" + palhaco.calcularValorHora());

			palhacoService.incluir(palhaco);
		} catch (Exception e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
			Palhaco palhaco = new Palhaco("Nox",100,"95919-8775");
			palhaco.setHumorAdulto(false);
			palhaco.setNomeArtistico("Bozo");
			palhaco.setTamanhoSapato(38);
			palhaco.setUsuario(admin);
			System.out.println(palhaco.toString());
			System.out.println("Salário-hora do palhaço = R$" + palhaco.calcularValorHora());

			palhacoService.incluir(palhaco);
		} catch (Exception e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		System.out.println("Listagem de Palhaços:");
		for(Palhaco palhaco : palhacoService.obterLista()) {
			System.out.println(palhaco.getId() + " " + palhaco.toString());
		}
	}

}

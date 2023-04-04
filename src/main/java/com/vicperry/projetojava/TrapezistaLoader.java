package com.vicperry.projetojava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.vicperry.projetojava.model.domain.Trapezista;
import com.vicperry.projetojava.model.domain.Usuario;
import com.vicperry.projetojava.model.service.TrapezistaService;

@Order(5)
@Component
public class TrapezistaLoader implements ApplicationRunner {
	@Autowired
	private TrapezistaService trapezistaService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Usuario admin = new Usuario();
		admin.setId(1);
		
		try {
			Trapezista trapezista = new Trapezista("Robin",150,"85919-1785");
			trapezista.setAltura(1.80);
			trapezista.setPossuiRedeSegurança(true);
			trapezista.setNumeroAcrobaciasRealizadas(5);
			trapezista.setUsuario(admin);
			System.out.println(trapezista.toString());
			System.out.println("Salário-hora do trapezista = R$" + trapezista.calcularValorHora());

			trapezistaService.incluir(trapezista);
		} catch (Exception e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Trapezista trapezista = new Trapezista("Barbara",150,"94919-2783");
			trapezista.setAltura(1.60);
			trapezista.setPossuiRedeSegurança(true);
			trapezista.setNumeroAcrobaciasRealizadas(4);
			trapezista.setUsuario(admin);
			System.out.println(trapezista.toString());
			System.out.println("Salário-hora do trapezista = R$" + trapezista.calcularValorHora());

			trapezistaService.incluir(trapezista);
		} catch (Exception e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
			Trapezista trapezista = new Trapezista("Harley",150,"75919-3775");
			trapezista.setAltura(1.70);
			trapezista.setPossuiRedeSegurança(false);
			trapezista.setNumeroAcrobaciasRealizadas(5);
			trapezista.setUsuario(admin);
			System.out.println(trapezista.toString());
			System.out.println("Salário-hora do trapezista = R$" + trapezista.calcularValorHora());

			trapezistaService.incluir(trapezista);
		} catch (Exception e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		System.out.println("Listagem de Trapezistas:");
		for(Trapezista trapezista : trapezistaService.obterLista()) {
			System.out.println(trapezista.getId() + " " + trapezista.toString());
		}
	}

}

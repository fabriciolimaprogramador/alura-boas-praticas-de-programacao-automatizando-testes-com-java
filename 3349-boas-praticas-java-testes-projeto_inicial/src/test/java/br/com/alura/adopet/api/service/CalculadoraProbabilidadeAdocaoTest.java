package br.com.alura.adopet.api.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.alura.adopet.api.dto.CadastroAbrigoDto;
import br.com.alura.adopet.api.dto.CadastroPetDto;
import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.model.ProbabilidadeAdocao;
import br.com.alura.adopet.api.model.TipoPet;

class CalculadoraProbabilidadeAdocaoTest {

	@Test
	void deveriaRetornarProbabilidadeAltaParaPetComIdadeBaixaEPesoBaixo() {
		//idade = 4 anos e peso = 4kg - ALTA
		
		Abrigo abrigo = new Abrigo(new CadastroAbrigoDto("Abrigo feliz", "9499999999", "abrigofeliz@gmail.com"));
		Pet pet = new Pet(new CadastroPetDto(TipoPet.GATO, "Miau", "Siames", 4, "Cinza", 4.0f), abrigo);
		
		CalculadoraProbabilidadeAdocao calculadora = new CalculadoraProbabilidadeAdocao();
		ProbabilidadeAdocao probabilidade = calculadora.calcular(pet);
		
		Assertions.assertEquals(ProbabilidadeAdocao.ALTA, probabilidade);
	}
	
	@Test
	void deveriaRetornarProbabilidadeMediaParaPetComIdadeAltaEPesoBaixo() {
		//idade = 15 anos e peso = 4kg - MEDIA
		
		Abrigo abrigo = new Abrigo(new CadastroAbrigoDto("Abrigo feliz", "9499999999", "abrigofeliz@gmail.com"));
		Pet pet = new Pet(new CadastroPetDto(TipoPet.GATO, "Miau", "Siames", 15, "Cinza", 4.0f), abrigo);
		
		CalculadoraProbabilidadeAdocao calculadora = new CalculadoraProbabilidadeAdocao();
		ProbabilidadeAdocao probabilidade = calculadora.calcular(pet);
		
		Assertions.assertEquals(ProbabilidadeAdocao.MEDIA, probabilidade);
	}
	
	
	
	

}

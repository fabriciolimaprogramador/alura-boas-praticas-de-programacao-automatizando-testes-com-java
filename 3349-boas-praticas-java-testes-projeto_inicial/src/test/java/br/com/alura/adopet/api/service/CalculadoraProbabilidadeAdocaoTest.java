package br.com.alura.adopet.api.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.alura.adopet.api.dto.CadastroAbrigoDto;
import br.com.alura.adopet.api.dto.CadastroPetDto;
import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.model.ProbabilidadeAdocao;
import br.com.alura.adopet.api.model.TipoPet;

class CalculadoraProbabilidadeAdocaoTest {

	@Test
    @DisplayName("Probabilidade alta para gatos jovens com peso baixo")
	void probabilidadeAltaCenario1() {
		//idade = 4 anos e peso = 4kg - ALTA
		
		//Arrange
		Abrigo abrigo = new Abrigo(new CadastroAbrigoDto("Abrigo feliz", "9499999999", "abrigofeliz@gmail.com"));
		Pet pet = new Pet(new CadastroPetDto(TipoPet.GATO, "Miau", "Siames", 4, "Cinza", 4.0f), abrigo);
		
		CalculadoraProbabilidadeAdocao calculadora = new CalculadoraProbabilidadeAdocao();
		
		//Act
		ProbabilidadeAdocao probabilidade = calculadora.calcular(pet);
		
		//Assert
		Assertions.assertEquals(ProbabilidadeAdocao.ALTA, probabilidade);
	}
	
	@Test
    @DisplayName("Probabilidade média para gatos idosos com peso baixo")
	void probabilidadeMediaCenario2() {
		//idade = 15 anos e peso = 4kg - MEDIA
		
		Abrigo abrigo = new Abrigo(new CadastroAbrigoDto("Abrigo feliz", "9499999999", "abrigofeliz@gmail.com"));
		Pet pet = new Pet(new CadastroPetDto(TipoPet.GATO, "Miau", "Siames", 15, "Cinza", 4.0f), abrigo);
		
		CalculadoraProbabilidadeAdocao calculadora = new CalculadoraProbabilidadeAdocao();
		ProbabilidadeAdocao probabilidade = calculadora.calcular(pet);
		
		Assertions.assertEquals(ProbabilidadeAdocao.MEDIA, probabilidade);
	}
	
	
	
	

}

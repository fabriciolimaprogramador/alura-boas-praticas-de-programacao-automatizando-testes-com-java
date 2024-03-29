package br.com.alura.adopet.api.validacoes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.alura.adopet.api.dto.SolicitacaoAdocaoDto;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.StatusAdocao;
import br.com.alura.adopet.api.repository.AdocaoRepository;

@ExtendWith(MockitoExtension.class)
class ValidacaoTutorComLimiteDeAdocoesTest {

	@InjectMocks
	private ValidacaoTutorComLimiteDeAdocoes validacao;

	@Mock
	private AdocaoRepository adocaoRepository;

	@Mock
	private SolicitacaoAdocaoDto dto;

	@Test
	void tutorComLimiteMaximoDeAdocoes() {

		BDDMockito.given(adocaoRepository.countByTutorIdByStatus(dto.idTutor(), StatusAdocao.APROVADO)).willReturn(5L);

		Assertions.assertThrows(ValidacaoException.class, () -> validacao.validar(dto));

	}

	@Test
	void tutorSemLimiteMaximoDeAdocoes() {

		BDDMockito.given(adocaoRepository.countByTutorIdByStatus(dto.idTutor(), StatusAdocao.APROVADO)).willReturn(4L);

		Assertions.assertDoesNotThrow(() -> validacao.validar(dto));

	}

}

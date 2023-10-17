package br.com.alura.adopet.api.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.alura.adopet.api.dto.SolicitacaoAdocaoDto;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.StatusAdocao;
import br.com.alura.adopet.api.repository.AdocaoRepository;

@Component
public class ValidacaoTutorComLimiteDeAdocoes implements ValidacaoSolicitacaoAdocao {

    @Autowired
    private AdocaoRepository adocaoRepository;

//    @Autowired
//    private TutorRepository tutorRepository;

    public void validar(SolicitacaoAdocaoDto dto) {
        if(adocaoRepository.countByTutorIdByStatus(dto.idTutor(), StatusAdocao.APROVADO) ==  5) {
        	throw new ValidacaoException("Tutor chegou ao limite máximo de 5 adoções!");
        }
    }
//    public void validar(SolicitacaoAdocaoDto dto) {
//    	List<Adocao> adocoes = adocaoRepository.findAll();
//    	Tutor tutor = tutorRepository.getReferenceById(dto.idTutor());
//    	for (Adocao adocao : adocoes) {
//    		int contador = 0;
//    		if (adocao.getTutor() == tutor && adocao.getStatus() == StatusAdocao.APROVADO) {
//    			contador = contador + 1;
//    		}
//    		if (contador == 5) {
//    			throw new ValidacaoException("Tutor chegou ao limite máximo de 5 adoções!");
//    		}
//    	}
//    }
    
    

}

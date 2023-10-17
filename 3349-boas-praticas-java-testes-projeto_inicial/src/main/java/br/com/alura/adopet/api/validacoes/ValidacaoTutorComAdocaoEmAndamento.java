package br.com.alura.adopet.api.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.alura.adopet.api.dto.SolicitacaoAdocaoDto;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.StatusAdocao;
import br.com.alura.adopet.api.repository.AdocaoRepository;

@Component
public class ValidacaoTutorComAdocaoEmAndamento implements ValidacaoSolicitacaoAdocao {

    @Autowired
    private AdocaoRepository adocaoRepository;

//    @Autowired
//    private TutorRepository tutorRepository;

    public void validar(SolicitacaoAdocaoDto dto) {
        
        if(adocaoRepository.existsByTutorIdAndStatus(dto.idTutor(), StatusAdocao.AGUARDANDO_AVALIACAO)) {
        	throw new ValidacaoException("Tutor já possui outra adoção aguardando avaliação!");
        }
        
    }

//    public void validar(SolicitacaoAdocaoDto dto) {
//    	List<Adocao> adocoes = adocaoRepository.findAll();
//    	Tutor tutor = tutorRepository.getReferenceById(dto.idTutor());
//    	for (Adocao adocao : adocoes) {
//    		if (adocao.getTutor() == tutor && adocao.getStatus() == StatusAdocao.AGUARDANDO_AVALIACAO) {
//    			throw new ValidacaoException("Tutor já possui outra adoção aguardando avaliação!");
//    		}
//    	}
//    }

}

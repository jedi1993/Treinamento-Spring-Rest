package algalogapi2.algalog.domain.service;

import algalogapi2.algalog.domain.exception.EntidadeNaoEncontradaExcepetion;
import algalogapi2.algalog.domain.exception.NegocioException;
import algalogapi2.algalog.domain.model.Entrega;
import algalogapi2.algalog.domain.repository.EntregaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscaEntregaService {
    @Autowired
    private EntregaRepository entregaRepository;

    public Entrega buscar(Long entregaId){
        return entregaRepository.findById(entregaId).orElseThrow(()-> new EntidadeNaoEncontradaExcepetion("Entrega não encontrada!!!!!"));
    }
}

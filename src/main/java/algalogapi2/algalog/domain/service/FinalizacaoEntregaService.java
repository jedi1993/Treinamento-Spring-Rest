package algalogapi2.algalog.domain.service;

import algalogapi2.algalog.domain.exception.NegocioException;
import algalogapi2.algalog.domain.model.Entrega;
import algalogapi2.algalog.domain.model.StatusEntrega;
import algalogapi2.algalog.domain.repository.EntregaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class FinalizacaoEntregaService {

    @Autowired
    private BuscaEntregaService buscaEntregaService;
    @Autowired
    private EntregaRepository entregaRepository;

    @Transactional
    public void finalizar(Long entregaId){
        Entrega entrega = buscaEntregaService.buscar(entregaId);

        entrega.finalizar();

        entregaRepository.save(entrega);
    }
}

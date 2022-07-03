package algalogapi2.algalog.domain.service;

import algalogapi2.algalog.domain.exception.NegocioException;
import algalogapi2.algalog.domain.model.Entrega;
import algalogapi2.algalog.domain.model.Ocorrencia;
import algalogapi2.algalog.domain.repository.EntregaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class RegistroOcorrenciaService {
    @Autowired
    private BuscaEntregaService buscaEntregaService;
    @Transactional
    public Ocorrencia registrar(Long entregaId, String descricao){
        Entrega entrega = buscaEntregaService.buscar(entregaId);
        return entrega.adicionarOcorrencia(descricao);
    }
}

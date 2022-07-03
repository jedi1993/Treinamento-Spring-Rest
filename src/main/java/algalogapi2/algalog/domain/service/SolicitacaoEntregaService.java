package algalogapi2.algalog.domain.service;

import algalogapi2.algalog.domain.exception.NegocioException;
import algalogapi2.algalog.domain.model.Cliente;
import algalogapi2.algalog.domain.model.Entrega;
import algalogapi2.algalog.domain.model.StatusEntrega;
import algalogapi2.algalog.domain.repository.ClienteRepository;
import algalogapi2.algalog.domain.repository.EntregaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Service
public class SolicitacaoEntregaService {
    @Autowired
    private EntregaRepository entregaRepository;
    @Autowired
    private CatalogoClienteService catalogoClienteService;

    @Transactional
    public Entrega solicitar(Entrega entrega){
        Cliente cliente = catalogoClienteService.buscar(entrega.getCliente().getId());
        entrega.setCliente(cliente);
        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(OffsetDateTime.now());
        return entregaRepository.save(entrega);
    }
}

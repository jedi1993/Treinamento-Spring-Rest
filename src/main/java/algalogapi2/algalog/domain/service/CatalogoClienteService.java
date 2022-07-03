package algalogapi2.algalog.domain.service;

import algalogapi2.algalog.domain.exception.NegocioException;
import algalogapi2.algalog.domain.model.Cliente;
import algalogapi2.algalog.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Stream;

@Service
public class CatalogoClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente buscar(Long clienteId){
        return  clienteRepository.findById(clienteId).orElseThrow(()-> new NegocioException("Cliente não encontrado"));

    }

    @Transactional
    public Cliente salvarCliente(Cliente cliente){

        return clienteRepository.save(cliente);

    }
    @Transactional
    public void excluir(Long clienteId){
        clienteRepository.deleteById(clienteId);
    }
}

package algalogapi2.algalog.api.controller;

import algalogapi2.algalog.api.assembler.EntregaAssembler;
import algalogapi2.algalog.api.model.DestinatarioModel;
import algalogapi2.algalog.api.model.EntregaModel;
import algalogapi2.algalog.api.model.input.EntregaInput;
import algalogapi2.algalog.domain.model.Entrega;
import algalogapi2.algalog.domain.repository.EntregaRepository;
import algalogapi2.algalog.domain.service.FinalizacaoEntregaService;
import algalogapi2.algalog.domain.service.SolicitacaoEntregaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/entregas")
public class EntregaController {
    @Autowired
    private SolicitacaoEntregaService solicitacaoEntregaService;
    @Autowired
    private EntregaRepository entregaRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private EntregaAssembler entregaAssembler;
    @Autowired
    private FinalizacaoEntregaService finalizacaoEntregaService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntregaModel solicitar(@Valid @RequestBody EntregaInput entregaInput){
        Entrega novaEntrega = entregaAssembler.toEntity(entregaInput);
        Entrega entregaSolicitada = solicitacaoEntregaService.solicitar(novaEntrega);
        return entregaAssembler.toModel(entregaSolicitada);
    }
    @GetMapping
    public List<EntregaModel> listar(){

        return entregaAssembler.toCollectionModel(entregaRepository.findAll());
    }
    @GetMapping("/{entregaId}")
    public ResponseEntity<EntregaModel> buscar(@PathVariable Long entregaId){
        return entregaRepository.findById(entregaId).map(entrega ->
                ResponseEntity.ok(entregaAssembler.toModel(entrega)))
                .orElse(ResponseEntity.notFound().build());


    }
    @PutMapping("{entregaId}/finalizacao")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void finalizar(@PathVariable Long entregaId){
        finalizacaoEntregaService.finalizar(entregaId);

    }
}

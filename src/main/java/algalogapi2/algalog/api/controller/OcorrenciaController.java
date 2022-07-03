package algalogapi2.algalog.api.controller;

import algalogapi2.algalog.api.assembler.OcorrenciaAssembler;
import algalogapi2.algalog.api.model.input.OcorrenciaInput;
import algalogapi2.algalog.domain.model.Entrega;
import algalogapi2.algalog.domain.model.Ocorrencia;
import algalogapi2.algalog.domain.model.OcorrenciaModel;
import algalogapi2.algalog.domain.service.BuscaEntregaService;
import algalogapi2.algalog.domain.service.RegistroOcorrenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {
    @Autowired
    private RegistroOcorrenciaService registroOcorrenciaService;
    @Autowired
    private OcorrenciaAssembler ocorrenciaAssembler;
    @Autowired
    private BuscaEntregaService buscaEntregaService;



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OcorrenciaModel registrar(@PathVariable Long entregaId, @Valid @RequestBody OcorrenciaInput ocorrenciaInput){
        Ocorrencia ocorrenciaRegistrada = registroOcorrenciaService.registrar(entregaId,ocorrenciaInput.getDescricao());

       return ocorrenciaAssembler.toModel(ocorrenciaRegistrada);

    }
    @GetMapping
    public List<OcorrenciaModel> listar(@PathVariable Long entregaId){
        Entrega entrega = buscaEntregaService.buscar(entregaId);

        return ocorrenciaAssembler.toCollectionModel(entrega.getOcorrencias());
    }

}

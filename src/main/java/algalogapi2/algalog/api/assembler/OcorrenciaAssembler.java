package algalogapi2.algalog.api.assembler;

import algalogapi2.algalog.domain.model.Ocorrencia;
import algalogapi2.algalog.domain.model.OcorrenciaModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OcorrenciaAssembler {
    @Autowired
    private ModelMapper modelMapper;

    public OcorrenciaModel toModel(Ocorrencia ocorrencia){
        return modelMapper.map(ocorrencia,OcorrenciaModel.class);
    }
    public List<OcorrenciaModel> toCollectionModel(List<Ocorrencia> ocorrencias){
        return ocorrencias.stream().map(this::toModel).collect(Collectors.toList());
    }
}

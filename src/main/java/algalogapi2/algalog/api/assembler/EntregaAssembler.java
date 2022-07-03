package algalogapi2.algalog.api.assembler;

import algalogapi2.algalog.api.model.EntregaModel;
import algalogapi2.algalog.api.model.input.EntregaInput;
import algalogapi2.algalog.domain.model.Entrega;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EntregaAssembler {
    @Autowired
    private ModelMapper modelMapper;

    public EntregaModel toModel(Entrega entrega){
        return modelMapper.map(entrega,EntregaModel.class);
    }
    public List<EntregaModel> toCollectionModel(List<Entrega> entregas){
        return entregas.stream().map(this::toModel).collect(Collectors.toList());
    };
    
    public Entrega toEntity(EntregaInput entregaInput){
        return modelMapper.map(entregaInput,Entrega.class);
    }
}

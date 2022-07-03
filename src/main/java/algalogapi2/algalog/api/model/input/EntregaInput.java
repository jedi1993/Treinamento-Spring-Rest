package algalogapi2.algalog.api.model.input;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class EntregaInput {
    @Valid
    @NotNull
    private ClienteIdInput clienteIdInput;
    @Valid
    @NotNull
    private DestinatarioInput destinatarioInput;
    @NotNull
    private BigDecimal taxa;

    public ClienteIdInput getClienteIdInput() {
        return clienteIdInput;
    }

    public void setClienteIdInput(ClienteIdInput clienteIdInput) {
        this.clienteIdInput = clienteIdInput;
    }

    public DestinatarioInput getDestinatarioInput() {
        return destinatarioInput;
    }

    public void setDestinatarioInput(DestinatarioInput destinatarioInput) {
        this.destinatarioInput = destinatarioInput;
    }

    public BigDecimal getTaxa() {
        return taxa;
    }

    public void setTaxa(BigDecimal taxa) {
        this.taxa = taxa;
    }
}

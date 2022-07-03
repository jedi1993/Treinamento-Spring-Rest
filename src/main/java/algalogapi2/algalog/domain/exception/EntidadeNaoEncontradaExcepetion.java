package algalogapi2.algalog.domain.exception;

public class EntidadeNaoEncontradaExcepetion extends NegocioException{
    private static final long serialVersionUID = 1l;

    public EntidadeNaoEncontradaExcepetion(String message) {
        super(message);
    }
}

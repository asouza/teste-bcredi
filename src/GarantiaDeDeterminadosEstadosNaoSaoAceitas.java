import java.util.Set;

public class GarantiaDeDeterminadosEstadosNaoSaoAceitas implements Validacao {

	@Override
	public boolean taValida(Proposta proposta) {
		return !proposta.garantiasForaDosEstados(
				Set.of(SiglaEstado.PR, SiglaEstado.SC, SiglaEstado.RS))
				.isEmpty();
	}

}

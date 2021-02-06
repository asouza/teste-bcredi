
public class TempoMaximoPagamento implements Validacao{

	@Override
	public boolean taValida(Proposta proposta) {
		return proposta.anosPagamentoEntre(2,15);
	}

}

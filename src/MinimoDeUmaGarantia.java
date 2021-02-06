
public class MinimoDeUmaGarantia implements Validacao{

	@Override
	public boolean taValida(Proposta proposta) {
		return proposta.numeroGarantias() >= 1;
	}

}

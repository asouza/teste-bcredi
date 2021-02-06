
public class MinimoUmProponentePrincipal implements Validacao {

	@Override
	public boolean taValida(Proposta proposta) {
		return proposta.proponentesPrincipais().size() == 1;
	}

}

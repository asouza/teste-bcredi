
public class MinimoDoisProponentes implements Validacao{

	@Override
	public boolean taValida(Proposta proposta) {
		return proposta.numeroProponentes() >= 2;
	}

}

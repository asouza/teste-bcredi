
//3
public class RendaProponentePrincipal implements Validacao {

	@Override
	public boolean taValida(Proposta proposta) {
		//1
		Proponente proponente = proposta.proponentePrincipal(1);
		// padrao que quero evitar, invocar duas coisas do objeto num fluxo
		//1
		if (proponente.idadeEntre(18, 24)) {
			return proponente.rendaMinima(proposta.projetaValorParcela(4));
		}
		//1
		if (proponente.idadeEntre(25, 50)) {
			return proponente.rendaMinima(proposta.projetaValorParcela(3));
		}
		
		return proponente.rendaMinima(proposta.projetaValorParcela(2));
	}

}

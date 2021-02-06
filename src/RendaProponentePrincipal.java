
public class RendaProponentePrincipal implements Validacao {

	@Override
	public boolean taValida(Proposta proposta) {
		Proponente proponente = proposta.proponentePrincipal(1);
		// padrao que quero evitar, invocar duas coisas do objeto num fluxo
		if (proponente.idadeEntre(18, 24)) {
			return proponente.rendaMinima(proposta.projetaValorParcela(4));
		}
		if (proponente.idadeEntre(25, 50)) {
			return proponente.rendaMinima(proposta.projetaValorParcela(3));
		}
		
		proponente.rendaAceitavel(
				new Combinacao(18,24,proposta.projetaValorParcela(4)),
				new Combinacao(25,50,proposta.projetaValorParcela(3)),
				new Combinacao(51,200,proposta.projetaValorParcela(2))				
				);
		
		return proponente.rendaMinima(proposta.projetaValorParcela(2));
	}

}

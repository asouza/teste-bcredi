import java.math.BigDecimal;

public class SomaDasGarantiasMaiorQueDobroEmprestimo implements Validacao{

	@Override
	public boolean taValida(Proposta proposta) {
		//mais uma oportunidade de parametrizar e criar um metodo na proposta
		BigDecimal somaValorGarantias = proposta.somaGarantias();
		
		BigDecimal valorProjetado = proposta.projetaValorEmprestimo(2);
		
		return somaValorGarantias.compareTo(valorProjetado) >= 0;
	}

}

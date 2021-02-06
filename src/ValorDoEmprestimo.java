import java.math.BigDecimal;

public class ValorDoEmprestimo implements Validacao{

	@Override
	public boolean taValida(Proposta proposta) {
		return proposta.valorEntre(new BigDecimal("30000"),new BigDecimal("3000000"));
	}

}

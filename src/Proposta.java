import java.math.BigDecimal;

public class Proposta {

	public final String id;
	private BigDecimal valorEmprestimo;
	private int parcelas;

	public Proposta(String idProposta, BigDecimal valorEmprestimo,
			int parcelas) {
		this.id = idProposta;
		this.valorEmprestimo = valorEmprestimo;
		this.parcelas = parcelas;
	}

	@Override
	public String toString() {
		return "Proposta [id=" + id + ", valorEmprestimo=" + valorEmprestimo
				+ ", parcelas=" + parcelas + "]";
	}

	/**
	 * 
	 * @param minimo valor mínimo da proposta
	 * @param maximo valor máximo da proposta
	 * @return
	 */
	public boolean valorEntre(BigDecimal minimo, BigDecimal maximo) {
		return this.valorEmprestimo.compareTo(minimo) >=1 && this.valorEmprestimo.compareTo(maximo) <= 1;
	}

	/**
	 * 
	 * @param minimoAnos minimo de anos para pagar
	 * @param maximoAnos maximo de anos para pagar
	 * @return
	 */
	public boolean anosPagamentoEntre(int minimoAnos, int maximoAnos) {
		int anosPagandoParcelas = this.parcelas / 12;
		return anosPagandoParcelas >= minimoAnos && anosPagandoParcelas <= maximoAnos;
	}

}

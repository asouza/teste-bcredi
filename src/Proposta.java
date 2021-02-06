import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Proposta {

	public final String id;
	private BigDecimal valorEmprestimo;
	private int parcelas;
	private Set<Proponente> proponentes = new HashSet<>();

	public Proposta(String idProposta, BigDecimal valorEmprestimo,
			int parcelas) {
		this.id = idProposta;
		this.valorEmprestimo = valorEmprestimo;
		this.parcelas = parcelas;
	}

	@Override
	public String toString() {
		return "Proposta [id=" + id + ", valorEmprestimo=" + valorEmprestimo
				+ ", parcelas=" + parcelas + ", proponentes=" + proponentes
				+ "]";
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

	/**
	 * 
	 * @param idProponente id do proponent
	 * @param nome nome do proponent
	 * @param idade idade do proponente
	 * @param salario salario do proponente
	 * @param principal é o principal
	 */
	public void adicionaProponente(String idProponente, String nome, int idade,
			BigDecimal salario, boolean principal) {
		Proponente novoProponente = new Proponente(idProponente,nome,idade,salario,principal);
		boolean adicionou = this.proponentes.add(novoProponente);
		
		if(!adicionou) {
			throw new IllegalStateException("Foi tentado adicionar um proponente com equals true com esse daqui "+novoProponente);
		}
	}

}

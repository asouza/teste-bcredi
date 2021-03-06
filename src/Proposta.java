import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//10
public class Proposta {

	public final String id;
	private BigDecimal valorEmprestimo;
	private int parcelas;
	//1
	private Set<Proponente> proponentes = new HashSet<>();
	//1
	private Set<Garantia> garantias = new HashSet<>();

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
				+ ", garantias=" + garantias + "]";
	}

	/**
	 * 
	 * @param minimo valor mínimo da proposta
	 * @param maximo valor máximo da proposta
	 * @return
	 * 
	 */
	public boolean valorEntre(BigDecimal minimo, 
			BigDecimal maximo) {
		return this.valorEmprestimo.compareTo(minimo) > 0
		&& this.valorEmprestimo.compareTo(maximo) < 0;
	}
	
	/**
	 * 
	 * @param minimoAnos minimo de anos para pagar
	 * @param maximoAnos maximo de anos para pagar
	 * @return
	 */
	public boolean anosPagamentoEntre(int minimoAnos, int maximoAnos) {
		int anosPagandoParcelas = this.parcelas / 12;
		return anosPagandoParcelas >= minimoAnos
				&& anosPagandoParcelas <= maximoAnos;
	}

	/**
	 * 
	 * @param idProponente id do proponent
	 * @param nome         nome do proponent
	 * @param idade        idade do proponente
	 * @param salario      salario do proponente
	 * @param principal    é o principal
	 */
	public void adicionaProponente(String idProponente, String nome, int idade,
			BigDecimal salario, boolean principal) {
		Proponente novoProponente = new Proponente(idProponente, nome, idade,
				salario, principal);
		boolean adicionou = this.proponentes.add(novoProponente);

		//1
		if (!adicionou) {
			throw new IllegalStateException(
					"Foi tentado adicionar um proponente com equals true com esse daqui "
							+ novoProponente);
		}
	}

	public int numeroProponentes() {
		return this.proponentes.size();
	}

	public Set<Proponente> proponentesPrincipais() {
		//1
		return this.proponentes.stream().filter(Proponente::principal)
				.collect(Collectors.toSet());
	}

	public List<Integer> idadeProponentes() {
		//1
		return this.proponentes.stream()
				.mapToInt(proponente -> proponente.getIdade()).boxed()
				.collect(Collectors.toList());
	}

	/**
	 * 
	 * @param maximoProponentesPrincipais maximo de proponentes principais que
	 *                                    deve ter na proposta
	 * @return
	 */
	public Proponente proponentePrincipal(int maximoProponentesPrincipais) {
		//1
		if (proponentesPrincipais().size() > maximoProponentesPrincipais) {
			throw new IllegalStateException(
					"Não poderia haver mais de um proponente principal "
							+ proponentes);
		}

		return proponentesPrincipais().iterator().next();
	}

	/**
	 * 
	 * @param multiplicador multiplicador do valor da parcela
	 * @return
	 */
	public BigDecimal projetaValorParcela(int multiplicador) {
		// aqui eu preciso entender mais do negócio para ser o arredondamento
		BigDecimal valorParcela = this.valorEmprestimo
				.divide(new BigDecimal(this.parcelas), RoundingMode.HALF_UP);
		BigDecimal valorParcelaProjetado = valorParcela
				.multiply(new BigDecimal(multiplicador));
		return valorParcelaProjetado;
	}

	public void adicionaGarantia(String idGarantia, BigDecimal valorGarantia,
			SiglaEstado siglaEstado) {
		Garantia novaGarantia = new Garantia(idGarantia, valorGarantia,
				siglaEstado);
		boolean adicionou = this.garantias.add(novaGarantia);

		//1
		if (!adicionou) {
			throw new IllegalStateException(
					"Foi tentado adicionar uma garantia com equals true com essa daqui "
							+ novaGarantia);
		}
	}

	public int numeroGarantias() {
		return this.garantias.size();
	}

	/**
	 * 
	 * @param siglas siglas de estados que queremos ter garantias
	 * @return
	 */
	public Collection<Garantia> garantiasEmDeterminadosEstados(
			Collection<SiglaEstado> siglas) {
		//1
		return this.garantias.stream()
				.filter(garantia -> garantia.pertenceAEstados(siglas))
				.collect(Collectors.toSet());
	}

	public BigDecimal somaGarantias() {
		//2
		return this.garantias.stream().map(garantia -> garantia.getValor())
				.reduce(BigDecimal.ZERO,
						(atual, proximo) -> atual.add(proximo));
	}

	/**
	 * 
	 * @param multiplicador multiplicador para projetar valor de emprestimo
	 * @return
	 */
	public BigDecimal projetaValorEmprestimo(int multiplicador) {
		return this.valorEmprestimo.multiply(new BigDecimal(multiplicador));
	}

}

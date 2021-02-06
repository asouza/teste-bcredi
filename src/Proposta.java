import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Proposta {

	public final String id;
	private BigDecimal valorEmprestimo;
	private int parcelas;
	private Set<Proponente> proponentes = new HashSet<>();
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
	 */
	public boolean valorEntre(BigDecimal minimo, BigDecimal maximo) {
		return this.valorEmprestimo.compareTo(minimo) >= 1
				&& this.valorEmprestimo.compareTo(maximo) <= 1;
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
		return this.proponentes.stream().filter(Proponente::principal)
				.collect(Collectors.toSet());
	}

	public List<Integer> idadeProponentes() {
		return this.proponentes.stream()
				.mapToInt(proponente -> proponente.getIdade())
				.boxed()
				.collect(Collectors.toList());
	}

	/**
	 * 
	 * @param maximoProponentesPrincipais maximo de proponentes principais que deve ter na proposta
	 * @return
	 */
	public Proponente proponentePrincipal(int maximoProponentesPrincipais) {
		if(proponentesPrincipais().size() > maximoProponentesPrincipais) {
			throw new IllegalStateException("Não poderia haver mais de um proponente principal "+proponentes);
		}
		
		return proponentesPrincipais().iterator().next();
	}

	/**
	 * 
	 * @param multiplicador multiplicador do valor da parcela
	 * @return
	 */
	public BigDecimal projetaValorParcela(int multiplicador) {
		//aqui eu preciso entender mais do negócio para ser o arredondamento
		BigDecimal valorParcela = this.valorEmprestimo.divide(new BigDecimal(this.parcelas), RoundingMode.HALF_UP);
		BigDecimal valorParcelaProjetado = valorParcela.multiply(new BigDecimal(multiplicador));
		return valorParcelaProjetado;
	}

	public void adicionaGarantia(String idGarantia, BigDecimal valorGarantia,
			SiglaEstado siglaEstado) {
		Garantia novaGarantia = new Garantia(idGarantia,valorGarantia,siglaEstado);
		boolean adicionou = this.garantias.add(novaGarantia);
		
		if (!adicionou) {
			throw new IllegalStateException(
					"Foi tentado adicionar uma garantia com equals true com essa daqui "
							+ novaGarantia);
		}		
	}

	public int numeroGarantias() {
		return this.garantias.size();
	}
	
	

}

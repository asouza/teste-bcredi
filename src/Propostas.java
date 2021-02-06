import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Representa as propostas geradas por processamento
 * 
 * @author albertoluizsouza
 *
 */
public class Propostas {

	private Map<String, Proposta> propostas = new HashMap<String, Proposta>();

	public void adiciona(Proposta novaProposta) {
		this.propostas.put(novaProposta.id, novaProposta);
	}

	@Override
	public String toString() {
		return "Propostas [propostas=" + propostas + "]";
	}

	public Proposta get(String idProposta) {
		Proposta proposta = propostas.get(idProposta);
		Objects.requireNonNull(proposta, "Precisa existir uma proposta com o id "+idProposta);
		return proposta;
	}

}

import java.util.HashMap;
import java.util.Map;

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

}

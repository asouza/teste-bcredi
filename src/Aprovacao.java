/**
 * Tupla que indica o status de aprovacao para determinada proposta
 * @author albertoluizsouza
 *
 */
public class Aprovacao {

	private String idProposta;
	private boolean aprovada;

	public Aprovacao(String idProposta, boolean aprovada) {
		super();
		this.idProposta = idProposta;
		this.aprovada = aprovada;
	}

}

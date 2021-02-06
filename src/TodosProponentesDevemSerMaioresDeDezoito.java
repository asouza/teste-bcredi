
public class TodosProponentesDevemSerMaioresDeDezoito implements Validacao {

	@Override
	public boolean taValida(Proposta proposta) {
		return proposta.idadeProponentes().stream()
				.allMatch(idade -> idade >= 18);
	}

}

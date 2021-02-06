import java.math.BigDecimal;

public class AdicionaProponente implements Logica{

	@Override
	public Proposta executa(String message, Propostas propostas) {
		String[] dados = message.split(",");
		String idProposta = dados[4];
		
		Proposta proposta = propostas.get(idProposta);
		
		String id = dados[5];
		String nome= dados[6];
		int idade= Integer.parseInt(dados[7]);
		BigDecimal salario = new BigDecimal(dados[8]);
		boolean principal = Boolean.parseBoolean(dados[9]);
		
		proposta.adicionaProponente(id,nome,idade,salario,principal);
		
				
		return proposta;
	}

}

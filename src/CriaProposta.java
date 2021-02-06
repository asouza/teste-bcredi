import java.math.BigDecimal;

public class CriaProposta implements Logica{

	@Override
	public Proposta executa(String message,Propostas propostas) {
		String[] dados = message.split(",");
		String idProposta = dados[4];
		BigDecimal valorEmprestimo = new BigDecimal(dados[5]);
		int parcelas = Integer.parseInt(dados[6]);
				
		Proposta novaProposta = new Proposta(idProposta,valorEmprestimo,parcelas);
		propostas.adiciona(novaProposta);
		
		return novaProposta;
	}

}

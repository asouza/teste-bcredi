import java.math.BigDecimal;

public class AdicionaGarantia implements Logica{

	@Override
	public Proposta executa(String message, Propostas propostas) {
		String[] dados = message.split(",");
		String idProposta = dados[4];
		
		Proposta proposta = propostas.get(idProposta);
		
		String id = dados[5];
		BigDecimal valorGarantia = new BigDecimal(dados[6]);
		SiglaEstado siglaEstado = SiglaEstado.valueOf(dados[7]);
		
		proposta.adicionaGarantia(id,valorGarantia,siglaEstado);
		return proposta;
	}

}

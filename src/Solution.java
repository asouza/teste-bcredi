
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

//20
public class Solution {
	

// Essa função recebe uma lista de mensagens, por exemplo:
  //
  // [
  //   "72ff1d14-756a-4549-9185-e60e326baf1b,proposal,created,2019-11-11T14:28:01Z,80921e5f-4307-4623-9ddb-5bf826a31dd7,1141424.0,240",
  //   "af745f6d-d5c0-41e9-b04f-ee524befa425,warranty,added,2019-11-11T14:28:01Z,80921e5f-4307-4623-9ddb-5bf826a31dd7,31c1dd83-8fb7-44ff-8cb7-947e604f6293,3245356.0,DF",
  //   "450951ee-a38d-475c-ac21-f22b4566fb29,warranty,added,2019-11-11T14:28:01Z,80921e5f-4307-4623-9ddb-5bf826a31dd7,c8753500-1982-4003-8287-3b46c75d4803,3413113.45,DF",
  //   "66882b68-baa4-47b1-9cc7-7db9c2d8f823,proponent,added,2019-11-11T14:28:01Z,80921e5f-4307-4623-9ddb-5bf826a31dd7,3f52890a-7e9a-4447-a19b-bb5008a09672,Ismael Streich Jr.,42,62615.64,true"
  // ]
  //
  // Complete a função para retornar uma String com os IDs das propostas válidas no seguinte formato (separado por vírgula):
  // "52f0b3f2-f838-4ce2-96ee-9876dd2c0cf6,51a41350-d105-4423-a9cf-5a24ac46ae84,50cedd7f-44fd-4651-a4ec-f55c742e3477"
	//20
  public static String processMessages(List<String> messages) {
	  //1
	  //1
	  //1
	  //1
	  Map<String, Logica> logicas = Map.of(
			  "proposal.created",new CriaProposta(),
			  "proponent.added",new AdicionaProponente(),
			  "warranty.added",new AdicionaGarantia()
			  );			  
	  //1
	  Propostas propostas = new Propostas();	
	  //1
	  List<Validacao> validacoes = List.of(
			  //1
			  new ValorDoEmprestimo(),
			  //1
			  new TempoMaximoPagamento(),
			  //1
			  new MinimoDoisProponentes(),
			  //1
			  new MinimoUmProponentePrincipal(),
			  //1
			  new TodosProponentesDevemSerMaioresDeDezoito(),
			  //1
			  new RendaProponentePrincipal(),
			  //1
			  new MinimoDeUmaGarantia(),
			  //1
			  new GarantiaDeDeterminadosEstadosNaoSaoAceitas(),
			  //1
			  new SomaDasGarantiasMaiorQueDobroEmprestimo()
	  );
	  Set<String> idPropostasValidas = new LinkedHashSet<>();
	  
//	* para cada linha preciso executar uma lógica em função do tipo de operacao
//	* para cada execução de lógica eu preciso acessar possíveis propostas já criadas
//	* para cada linha também já pode ir executando as validações por proposta
//	* no final da execução só ficam as propostas que geraram uma saída verdadeira para as validações
	  
	//1
	for(String message : messages) {
		String[] partesDaMensagem = message.split(",");	
		String tipoLogica = partesDaMensagem[1]+"."+partesDaMensagem[2];
		
		Logica logicaASerExecutada = logicas.get(tipoLogica);
		
		Objects.requireNonNull(logicaASerExecutada, "Não foi possível encontrar a lógica para o tipo "+tipoLogica);
		//1
		Proposta propostaASerValidada = logicaASerExecutada.executa(message,propostas);
			
		//1
		for (Validacao validacao : validacoes) {
			boolean resultado = validacao.taValida(propostaASerValidada);
			//1
			if(resultado) {
				idPropostasValidas.add(propostaASerValidada.id);
			}
			//1
			else {
				idPropostasValidas.remove(propostaASerValidada.id);
				break;
			}
			
		}
	}
	 
    return idPropostasValidas.stream().collect(Collectors.joining(","));
  }
}
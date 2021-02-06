
public class CriaProposta implements Logica{

	@Override
	public Proposta executa(String message,Propostas propostas) {
		System.out.println("cria proposta");
		return new Proposta();
	}

}

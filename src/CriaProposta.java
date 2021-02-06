
public class CriaProposta implements Logica{

	@Override
	public Aprovacao executa(String message,Propostas propostas) {
		System.out.println("cria proposta");
		return new Aprovacao("", false);
	}

}

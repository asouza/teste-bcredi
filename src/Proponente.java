import java.math.BigDecimal;

public class Proponente {

	private String idProponente;
	private String nome;
	private int idade;
	private BigDecimal salario;
	private boolean principal;

	public Proponente(String idProponente, String nome, int idade,
			BigDecimal salario, boolean principal) {
				this.idProponente = idProponente;
				this.nome = nome;
				this.idade = idade;
				this.salario = salario;
				this.principal = principal;
		// TODO Auto-generated constructor stub
	}
	
	public boolean principal() {
		return this.principal;
	}
	
	

	@Override
	public String toString() {
		return "Proponente [idProponente=" + idProponente + ", nome=" + nome
				+ ", idade=" + idade + ", salario=" + salario + ", principal="
				+ principal + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idProponente == null) ? 0 : idProponente.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Proponente other = (Proponente) obj;
		if (idProponente == null) {
			if (other.idProponente != null)
				return false;
		} else if (!idProponente.equals(other.idProponente))
			return false;
		return true;
	}

	public int getIdade() {
		return idade;
	}
	
	

}

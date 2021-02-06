import java.math.BigDecimal;
import java.util.Collection;

public class Garantia {

	private String idGarantia;
	private BigDecimal valorGarantia;
	private SiglaEstado siglaEstado;

	public Garantia(String idGarantia, BigDecimal valorGarantia,
			SiglaEstado siglaEstado) {
		this.idGarantia = idGarantia;
		this.valorGarantia = valorGarantia;
		this.siglaEstado = siglaEstado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idGarantia == null) ? 0 : idGarantia.hashCode());
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
		Garantia other = (Garantia) obj;
		if (idGarantia == null) {
			if (other.idGarantia != null)
				return false;
		} else if (!idGarantia.equals(other.idGarantia))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Garantia [idGarantia=" + idGarantia + ", valorGarantia="
				+ valorGarantia + ", siglaEstado=" + siglaEstado + "]";
	}

	public boolean pertenceAEstados(Collection<SiglaEstado> siglas) {
		return siglas.contains(this.siglaEstado);
	}
	
	

}

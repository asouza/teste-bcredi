import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PropostaTest {

	@ParameterizedTest
	@CsvSource({
		"1000,999,1001,true",
		"1001,999,1001,false",
		"999,999,1001,false"
	})
	void teste1(BigDecimal valorEmprestimo,BigDecimal minimo, BigDecimal maximo, boolean resultado) throws Exception {
		Proposta proposta = new Proposta(
					"984759534", 
					valorEmprestimo,
					10);
		

		
		Assertions.assertEquals(resultado,proposta.valorEntre(minimo, maximo));
		;
	}
}

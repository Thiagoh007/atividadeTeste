package Test.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Avaliador;
import model.Lance;
import model.Leilao;
import model.Usuario;

public class AvaliadorTest {
	private Usuario joao;
	private Usuario jose;
	private Usuario maria;
	private Leilao leilao;
	private Avaliador avaliador;

	@BeforeEach
	private void instanciarObjetos() {
		joao = new Usuario("Joao");
		jose = new Usuario("Jose");
		maria = new Usuario("Maria");
		leilao = new Leilao("Playstation 3 novo");
		avaliador = new Avaliador();

	}

	@Test
	public void testarMaiorLanceSemOrdem() {

		// Criando lances
		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(jose, 400.0));
		leilao.propoe(new Lance(maria, 250.0));

		// Executando
		avaliador.avalia(leilao);

		// Comparando
		double maiorEsperado = 400.0;
		assertEquals(maiorEsperado, avaliador.getMaiorLance(), 0.0001);
	}

	@Test
	public void testarMenorLanceSemOrdem() {

		// Criando lances
		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(jose, 400.0));
		leilao.propoe(new Lance(maria, 250.0));

		// Executando
		avaliador.avalia(leilao);

		// Comparando
		double menorEsperado = 250.0;
		assertEquals(menorEsperado, avaliador.getMenorLance(), 0.0001);
	}

	@Test
	public void testarMaiorLanceComOrdemCrescente() {

		// Criando lances
		leilao.propoe(new Lance(maria, 250.0));
		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(jose, 400.0));

		// Executando
		avaliador.avalia(leilao);

		// Comparando
		double maiorEsperado = 400.0;
		assertEquals(maiorEsperado, avaliador.getMaiorLance(), 0.0001);
	}

	@Test
	public void testarMenorLanceComOrdemCrescente() {

		// Criando lances
		leilao.propoe(new Lance(maria, 250.0));
		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(jose, 400.0));

		// Executando
		avaliador.avalia(leilao);

		// Comparando
		double menorEsperado = 250.0;
		assertEquals(menorEsperado, avaliador.getMenorLance(), 0.0001);
	}

	@Test
	public void testarMaiorLanceComOrdemDecrescente() {

		// Criando lances
		leilao.propoe(new Lance(jose, 400.0));
		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(maria, 250.0));

		// Executando
		avaliador.avalia(leilao);

		// Comparando
		double maiorEsperado = 400.0;
		assertEquals(maiorEsperado, avaliador.getMaiorLance(), 0.0001);
	}

	@Test
	public void testarMenorLanceComOrdemDecrescente() {

		// Criando lances
		leilao.propoe(new Lance(jose, 400.0));
		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(maria, 250.0));

		// Executando
		avaliador.avalia(leilao);

		// Comparando
		double menorEsperado = 250.0;
		assertEquals(menorEsperado, avaliador.getMenorLance(), 0.0001);
	}

	@Test
	public void testarMaiorLanceComUmLance() {

		// Criando lances
		leilao.propoe(new Lance(jose, 400.0));

		// Executando
		avaliador.avalia(leilao);

		// Comparando
		double maiorEsperado = 400.0;
		assertEquals(maiorEsperado, avaliador.getMaiorLance(), 0.0001);
	}

	@Test
	public void testarMenorLanceComUmLance() {

		// Criando lances
		leilao.propoe(new Lance(jose, 400.0));

		// Executando
		avaliador.avalia(leilao);

		// Comparando
		double menorEsperado = 400.0;
		assertEquals(menorEsperado, avaliador.getMenorLance(), 0.0001);
	}

	@Test
	public void testarMaiorLanceSemLance() {

		// Criando lances

		// Executando
		avaliador.avalia(leilao);

		// Comparando
		double maiorEsperado = Double.NEGATIVE_INFINITY;
		assertEquals(maiorEsperado, avaliador.getMaiorLance(), 0.0001);
	}

	@Test
	public void testarMenorLanceSemLance() {

		// Criando lances

		// Executando
		avaliador.avalia(leilao);

		// Comparando
		double menorEsperado = Double.POSITIVE_INFINITY;
		assertEquals(menorEsperado, avaliador.getMenorLance(), 0.0001);
	}
}

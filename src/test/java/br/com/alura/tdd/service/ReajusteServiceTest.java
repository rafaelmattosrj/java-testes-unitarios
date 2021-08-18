package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

class ReajusteServiceTest {

	private ReajusteService service;
	private Funcionario funcionario;

	//substitui o inicializar(); de todos os metodos
	@BeforeEach
	public void inicializar() {
//		System.out.println("Inicializar");
		this.service = new ReajusteService();
		this.funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000.00"));
	}
	
//	@AfterEach
//	public void finalizar() {
//		System.out.println("Fim");
//	}
//	
//	@BeforeAll
//	public static void antesDeTodos() {
//		System.out.println("ANTES DE TODOS");
//	}
//	
//	@AfterAll
//	public static void depoisDeTodos() {
//		System.out.println("DEPOIS DE TODOS");
//	}
	
	@Test
	void reajusteDeveriaSerDeTresPorcentoQuandoDesempenhoForADesejar() {
		inicializar();
		service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
	}
	
	@Test
	void reajusteDeveriaSerDeQuinzePorcentoQuandoDesempenhoForBom() {
		inicializar();
		service.concederReajuste(funcionario, Desempenho.BOM);
		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
	}
	
	@Test
	void reajusteDeveriaSerDeVintePorcentoQuandoDesempenhoForOtimo() {
		service.concederReajuste(funcionario, Desempenho.OTIMO);	
		assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
	}
	
	
	
//	@Test
//	void reajusteDeveriaSerDeTresPorcentoQuandoDesempenhoForADesejar() {
//		ReajusteService service = new ReajusteService();
//		Funcionario funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000.00"));
//
//		service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
//		
//		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
//	}
//	
//	@Test
//	void reajusteDeveriaSerDeQuinzePorcentoQuandoDesempenhoForBom() {
//		ReajusteService service = new ReajusteService();
//		Funcionario funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000.00"));
//
//		service.concederReajuste(funcionario, Desempenho.BOM);
//		
//		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
//	}
//	
//	@Test
//	void reajusteDeveriaSerDeVintePorcentoQuandoDesempenhoForOtimo() {
//		ReajusteService service = new ReajusteService();
//		Funcionario funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000.00"));
//
//		service.concederReajuste(funcionario, Desempenho.OTIMO);
//		
//		assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
//	}
	
}
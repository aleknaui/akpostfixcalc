package Test;
import akPostfixCalc.akPila;

import junit.framework.TestCase;

public class akPilaTest extends TestCase {
	
	// --------------------------------------------------
	// Atributos
	// --------------------------------------------------
	
	/** Pila sobre la cual se realizaran las pruebas */
	private akPila<String> pila;
	
	// --------------------------------------------------
	// Metodos
	// --------------------------------------------------

	/**
	 * Prepara el escenario 1 para las pruebas.
	 * post: La pila se encuentra vacía
	 */
	protected void setUpScenario1(){
		pila = new akPila<String>();
	}
	
	/**
	 * Prepara el escenario 2 para las pruebas.
	 * post: La pila contiene los elementos "1", "2" y "3"
	 */
	protected void setUpScenario2(){
		pila = new akPila<String>();
		pila.push("1");
		pila.push("2");
		pila.push("3");
	}

	/**
	 * Realiza pruebas sobre el método peek().
	 * 1. Si la pila está vacía, se debe tirar una excepción.
	 * 2. Si la pila no está vacía, el tamaño de la pila debe mantenerse constante y el valor retornado debe
	 * ser el último valor ingresado.
	 */
	public void testPeek() {
		setUpScenario1();
		try{
			pila.peek();
			fail("Al ejecutar peek() sobre una pila vacía, se tira una excepción");
		} catch ( NullPointerException e ){}
		
		setUpScenario2();
		int s1 = pila.size();
		String ans = pila.peek();
		assertEquals( "Se debe retornar el valor \"3\" al ejecutar peek()", "3", ans );
		assertEquals( "El tamaño de la pila no debe variar al ejecutar peek()", pila.size(), s1 );
	}
	
	/**
	 * Realiza pruebas sobre el método pop().
	 * 1. Si la pila está vacía, se debe tirar una excepción.
	 * 2. Si la pila no está vacía, el tamaño de la pila debe mantenerse constante y el valor retornado debe
	 * ser el último valor ingresado.
	 */
	public void testPop() {
		setUpScenario1();
		try{
			pila.pop();
			fail("Al ejecutar pop() sobre una pila vacía, se tira una excepción");
		} catch ( NullPointerException e ){}
		
		setUpScenario2();
		int s1 = pila.size();
		String ans = pila.pop();
		assertEquals( "Se debe retornar el valor \"3\" al ejecutar pop()", "3", ans );
		assertEquals( "El tamaño de la pila debe haberse decrementado en 1", s1-1, pila.size() );
	}

	/**
	 * Realiza pruebas sobre el método push().
	 * 1. La pila debe aumentar su tamaño en 1 (en ambos escenarios).
	 * 2. Al llamar peek(), debe retornar "Prueba" (en ambos escenarios).
	 */
	public void testPush() {
		setUpScenario1();
		pila.push("Prueba");
		assertEquals( "El tamaño de la pila debió haberse incrementado en 1", 1, pila.size() );
		assertEquals( "El último elemento de la pila debe ser \"Prueba\"", "Prueba", pila.peek() );
		
		setUpScenario2();
		pila.push("Prueba");
		assertEquals( "El tamaño de la pila debió haberse incrementado en 1", 4, pila.size() );
		assertEquals( "El último elemento de la pila debe ser \"Prueba\"", "Prueba", pila.peek() );
	}

	public void testSuperPop() {
		setUpScenario1();
		try{
			pila.superPop();
			assertTrue( "La pila debe quedar vacía", pila.isEmpty() );
		} catch( Exception e ){ fail( "El método no debe tirar una excepción" ); }
		
		setUpScenario2();
		try{
			pila.superPop();
			assertTrue( "La pila debe quedar vacía", pila.isEmpty() );
		} catch( Exception e ){ fail( "El método no debe tirar una excepción" ); }
	}

}

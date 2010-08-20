package akPostfixCalc;

import java.util.LinkedList;

/**
 * Clase que implementa la estructura de datos Pila
 * @author ale
 * @param <E> Genérico. El tipo de datos que se desea contener en la pila.
 */
public class akPila_LinkedList<E> extends AbstractPila<E>{
	
	// --------------------------------------------------
	// Atributos
	// --------------------------------------------------
	
	/** Los elementos que conforman la pila */
	private LinkedList<E> elementos;
	
	// --------------------------------------------------
	// Constructor
	// --------------------------------------------------
	
	/**
	 * Crea una nueva pila con 0 elementos.
	 * post: Se ha creado una pila vacía
	 */
	public akPila_LinkedList(){
		elementos = new LinkedList<E>();
	}
	
	// --------------------------------------------------
	// Metodos
	// --------------------------------------------------	

	@SuppressWarnings("unchecked")
	@Override
	public E peek() throws NullPointerException {
		if( isEmpty() ) throw new NullPointerException( "La lista se encuentra vacía" );
		else
			return elementos.getLast();
	}

	@SuppressWarnings("unchecked")
	@Override
	public E pop() throws NullPointerException {
		if( isEmpty() ) throw new NullPointerException( "La lista se encuentra vacía" );
		else
			return elementos.removeLast();
	}
	
	@Override
	public void push( E elemento ) {
		elementos.addLast( elemento );
	}

	@Override
	public int size() {
		return elementos.size();
	}
}
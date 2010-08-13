package akPostfixCalc;
public interface Pila<E>{
	
	/** Indica si la pila esta vacia.
	@return true Si esta vacia. false Si no lo esta. */
	public boolean isEmpty();
	
	/** Introduce un elemento a la pila.
	pre: El elemento es del tipo indicado como genérico. 
	post: El elemento ha sido agregado a la pila.
	@param elemento El elemento a introducir. */
	public void push( E elemento );
	
	/** Saca un elemento de la pila y lo retorna.
	pre: La pila no puede estar vacia.
	post: La pila ya no contiene el elemento retornado.
	@return El elemento que se saca de la pila. */
	public E pop() throws NullPointerException;
	
	/** Retorna el elemento que toca sacar en la pila, pero no lo saca.
	pre: La pila no puede estar vacia.
	post: La pila no ha sido modificada.
	@return El elemento que esta hasta arriba de la pila. */
	public E peek() throws NullPointerException;
	
	/** Informa el tamanio de la pila
	@return La cantidad de elementos de la pila */
	public int size();
	
	/** Quita todos los elementos de la pila.
	pre: La pila puede estar o no vacía.
	post: La pila queda vacia. */
	public void superPop();
}
package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> 
{
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() 
	{
		// TODO: Implement this method
		this.head = new LLNode(null);
		this.tail = new LLNode(null);
		this.head.setNext(this.tail);
		this.tail.setPrev(this.head);
		this.size = 0;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		boolean result = false;

		if(element == null)
			throw new NullPointerException();
		else
		{
			LLNode<E> newElt = new LLNode(element, this.tail.getPrev(), this.tail);
			this.size++;
			result = true;
		}

		return result;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */

	private LLNode<E> getNode(int index)
	{
		LLNode<E> watcher = this.head.getNext();
		
		if(index == 0)
			return watcher;

		if((index < 0) || (index >= this.size))
			throw new IndexOutOfBoundsException();
		else
		{
			for(int i = 1; i <= index; i++)
				watcher = watcher.getNext();
		}

		return watcher;
	}

	public E get(int index) 
	{
		// TODO: Implement this method.
		E data = null;

		if(this.size == 0)
			throw new IndexOutOfBoundsException();
		else
		{
			LLNode<E> watcher = this.getNode(index);
			data = watcher.getData();
		}

		return data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if(element == null)
			throw new NullPointerException();
		else
		{
			LLNode<E> watcher = this.getNode(index);
			LLNode<E> newElt = new LLNode(element, watcher.getPrev(), watcher);
			this.size++;
		}

	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return this.size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */


	public E remove(int index) 
	{
		// TODO: Implement this method
		LLNode<E> watcher;
		E data = null;

		if(this.size == 0)
			throw new IndexOutOfBoundsException();
		else
		{
			watcher = this.getNode(index);
			data = watcher.getData();
		}

		watcher.getPrev().setNext(watcher.getNext());
		watcher.getNext().setPrev(watcher.getPrev());
		this.size--;

		return data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		E oldValue = null;
		
		if(element == null)
			throw new NullPointerException();
		
		if(this.size == 0)
			throw new IndexOutOfBoundsException();
		else
		{
			LLNode<E> watcher = this.getNode(index);
			oldValue = watcher.getData();
			watcher.setData(element);
		}

		return oldValue;
	}   
	
	public String toString()
	{
		String result = "[";
		
		LLNode<E> watcher = this.head;
		E data;
		
		while(watcher.getNext().getData() != null)
		{
			watcher = watcher.getNext();
			data = watcher.getData();
			result += data + " ";
		}
		
		
		return result + "]";
	}

}

class LLNode<E> 
{
	protected LLNode<E> prev;
	protected LLNode<E> next;
	protected E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

	public LLNode(E thisData, LLNode<E> thisPrev, LLNode<E> thisNext)
	{
		this.data = thisData;
		this.prev = thisPrev;
		thisPrev.setNext(this);
		this.next = thisNext;
		thisNext.setPrev(this);
	}

	public LLNode<E> getPrev()
	{
		return this.prev;
	}

	public LLNode<E> getNext()
	{
		return this.next;
	}

	public E getData()
	{
		return this.data;
	}

	public void setPrev(LLNode<E> thisPrev)
	{
		this.prev = thisPrev;
	}

	public void setNext(LLNode<E> thisNext)
	{
		this.next = thisNext;
	}

	public void setData(E thisData)
	{
		this.data = thisData;
	}

}

/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester 
{

	private static final int LONG_LIST_LENGTH = 10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;

	/**
	 * @throws java.lang.Exception
	 */

	@Before
	public void setUp() throws Exception
	{
		// Feel free to use these lists, or add your own
		shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();

		for(int index = 0; index < LONG_LIST_LENGTH; index++)
			longerList.add(index);

		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
	}

	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		String errorMessage = "Check out get out of bounds";

		//test empty list, get should throw an exception
		try
		{
			emptyList.get(0);
			fail(errorMessage);
		}
		catch(IndexOutOfBoundsException e)
		{

		}

		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));

		try
		{
			shortList.get(-1);
			fail(errorMessage);
		}
		catch(IndexOutOfBoundsException e)
		{

		}

		try
		{
			shortList.get(2);
			fail(errorMessage);
		}
		catch(IndexOutOfBoundsException e)
		{

		}

		// test longer list contents
		for(int index = 0; index < LONG_LIST_LENGTH; index++)
			assertEquals("Check " + index + " element", (Integer)index, longerList.get(index));

		// test off the end of the longer array
		try
		{
			longerList.get(-1);
			fail(errorMessage);
		}
		catch(IndexOutOfBoundsException e)
		{

		}

		try
		{
			longerList.get(LONG_LIST_LENGTH);
			fail(errorMessage);
		}
		catch(IndexOutOfBoundsException e)
		{

		}
	}


	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());

		// TODO: Add more tests here

		try
		{
			emptyList.remove(0);
			fail("Check out remove out of bounds");
		}
		catch(IndexOutOfBoundsException e)
		{

		}

	}


	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
		// TODO: implement this test

		try
		{
			emptyList.add(null);
			fail("Check out add null element");
		}
		catch(NullPointerException e)
		{

		}

		emptyList.add((Integer) 3);
		assertEquals("Add: check add element ", (Integer)3, emptyList.get(0));

		emptyList.add((Integer) 5);
		assertEquals("Add: check add element ", (Integer)5, emptyList.get(1));

		emptyList = new MyLinkedList<Integer>();

	}


	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test
		String assertMessage = "Size: check size method ";

		assertEquals(assertMessage, 0, emptyList.size());

		emptyList.add((Integer) 3);
		assertEquals(assertMessage, 1, emptyList.size());

		emptyList.add((Integer) 5);
		assertEquals(assertMessage, 2, emptyList.size());

		emptyList.remove(0);
		assertEquals(assertMessage, 1, emptyList.size());

		emptyList = new MyLinkedList<Integer>();
	}



	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
		// TODO: implement this test
		try
		{
			emptyList.add(0, null);
			fail("Check out add null element");
		}
		catch(NullPointerException e)
		{

		}

		String assertMessage = "AddAt : check addAt method ";

		emptyList.add(0, (Integer) 3);
		assertEquals(assertMessage, (Integer)3, emptyList.get(0));

		try
		{
			emptyList.add(-1, (Integer)5);
			fail("Check out add out of bound");
		}
		catch(IndexOutOfBoundsException e)
		{

		}

		try
		{
			emptyList.add(1, (Integer)5);
			fail("Check out add out of bound");
		}
		catch(IndexOutOfBoundsException e)
		{

		}

		emptyList.add(0, (Integer) 5);
		assertEquals(assertMessage, (Integer)3, emptyList.get(1));

		emptyList = new MyLinkedList<Integer>();
	}

	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
		// TODO: implement this test
		try
		{
			emptyList.set(0, (Integer)2);
			fail("Check out of bounds");
		}
		catch(IndexOutOfBoundsException e)
		{
			
		}
		
		try
		{
			list1.set(0, null);
			fail("Check out NullPointerException");
		}
		catch(NullPointerException e)
		{
			
		}
		
		String assertMessage = "Set : check set method ";
		int a = list1.set(0, (Integer)30);
		assertEquals(assertMessage, 65, a);
		assertEquals(assertMessage, (Integer)30, list1.get(0));
	}


	// TODO: Optionally add more test methods.
	@Test
	public void testToString()
	{
		String list1Values = list1.toString();
		assertEquals("Check toString", "[65 21 42 ]", list1Values);
	}

}

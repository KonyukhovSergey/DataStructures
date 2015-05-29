package ru.serjik.data.tests;

import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Test;

import ru.serjik.data.LinkedList;

public class LinkedListTests
{
	@Test
	public void Create()
	{
		LinkedList<Object> list = new LinkedList<Object>();
		Assert.assertEquals(true, list.empty());
		Assert.assertEquals(0, list.size());
	}

	@Test
	public void Add()
	{
		LinkedList<Object> list = new LinkedList<Object>();

		list.add(null);
		Assert.assertEquals(1, list.size());
		Assert.assertTrue(list.contains(null));
	}

	@Test
	public void Remove()
	{
		LinkedList<Object> list = new LinkedList<Object>();
		Object o1 = new Object();
		Object o2 = new Object();
		Object o3 = new Object();

		list.add(o1);
		list.add(o2);
		list.add(o3);

		list.remove(o2);
		Assert.assertFalse(list.contains(o2));
		Assert.assertTrue(list.contains(o1));
		Assert.assertTrue(list.contains(o3));

		list.remove(o3);
		Assert.assertFalse(list.contains(o2));
		Assert.assertTrue(list.contains(o1));
		Assert.assertFalse(list.contains(o3));

		list.remove(o1);
		Assert.assertFalse(list.contains(o2));
		Assert.assertFalse(list.contains(o1));
		Assert.assertFalse(list.contains(o3));

		Assert.assertTrue(list.empty());
	}

	@Test
	public void Stack()
	{
		LinkedList<Object> list = new LinkedList<Object>();
		Object o1 = new Object();
		Object o2 = new Object();
		Object o3 = new Object();

		try
		{
			list.peek();
			Assert.fail();
		}
		catch (NoSuchElementException e)
		{
		}

		list.push(o1);
		Assert.assertEquals(o1, list.peek());

		list.push(o2);
		Assert.assertEquals(o2, list.peek());

		list.push(o3);
		Assert.assertEquals(o3, list.peek());

		Assert.assertEquals(o3, list.pop());
		Assert.assertEquals(o2, list.pop());
		Assert.assertEquals(o1, list.pop());

		try
		{
			list.peek();
			Assert.fail();
		}
		catch (NoSuchElementException e)
		{
		}

		Assert.assertEquals(0, list.size());
	}

	@Test
	public void Queue()
	{
		LinkedList<Object> list = new LinkedList<Object>();
		Object o1 = new Object();
		Object o2 = new Object();
		Object o3 = new Object();

		try
		{
			list.dequeue();
			Assert.fail();
		}
		catch (NoSuchElementException e)
		{
		}

		list.enqueue(o1);
		list.enqueue(o2);
		list.enqueue(o3);
		Assert.assertEquals(o1, list.dequeue());
		Assert.assertEquals(o2, list.dequeue());
		Assert.assertEquals(o3, list.dequeue());

		try
		{
			list.dequeue();
			Assert.fail();
		}
		catch (NoSuchElementException e)
		{
		}

		Assert.assertEquals(0, list.size());
	}
	
	@Test
	public void Iterate()
	{
		LinkedList<Object> list = new LinkedList<Object>();
		Object o1 = new Object();
		Object o2 = new Object();
		Object o3 = new Object();
		
		Object[] array = {o1,o2,o3};
		
		list.add(o1);
		list.add(o2);
		list.add(o3);
		
		int i =0;
		for(Object o:list)
		{
			Assert.assertEquals(array[i++], o);
		}
	}
}

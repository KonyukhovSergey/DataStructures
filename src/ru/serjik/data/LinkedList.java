package ru.serjik.data;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements List<T>, Queue<T>, Stack<T>
{
	private static final class Link<E>
	{
		Link<E> prev, next;
		E value;

		Link(E value, Link<E> prev, Link<E> next)
		{
			this.value = value;
			this.prev = prev;
			this.next = next;
		}

		final void remove()
		{
			prev.next = next;
			next.prev = prev;
		}
	}

	private static final class LinkIterator<I> implements Iterator<I>
	{
		Link<I> item;
		Link<I> zero;

		public LinkIterator(Link<I> zero)
		{
			this.zero = zero;
		}

		@Override
		public boolean hasNext()
		{
			return item.next != zero;
		}

		@Override
		public I next()
		{
			item = item.next;
			return item.value;
		}

		@Override
		public void remove()
		{
			item = item.prev;
			item.next.remove();
		}
	}

	private transient Link<T> zero;
	private transient LinkIterator<T> iterator;

	private transient int size = 0;

	public LinkedList()
	{
		zero = new Link<T>(null, null, null);
		iterator = new LinkIterator<T>(zero);

		zero.next = zero;
		zero.prev = zero;
	}

	@Override
	public T add(T value)
	{
		return addLast(value);
	}

	@Override
	public T dequeue()
	{
		return removeFirst();
	}

	@Override
	public boolean empty()
	{
		return size == 0;
	}

	@Override
	public T enqueue(T value)
	{
		return addLast(value);
	}

	@Override
	public T pop()
	{
		return removeLast();
	}

	@Override
	public T push(T value)
	{
		return addLast(value);
	}

	@Override
	public T remove(T value)
	{
		Link<T> item = zero.next;

		while (item != zero)
		{
			if (item.value == value)
			{
				item.remove();
				size--;
				return item.value;
			}
			item = item.next;
		}

		throw new NoSuchElementException();
	}

	@Override
	public int size()
	{
		return size;
	}

	private T addLast(T value)
	{
		Link<T> last = new Link<T>(value, zero.prev, zero);
		zero.prev = last;
		last.prev.next = last;
		size++;
		return value;
	}

	private T removeLast()
	{
		Link<T> last = zero.prev;

		if (last != zero)
		{
			last.remove();
			size--;
			return last.value;
		}

		throw new NoSuchElementException();
	}

	private T removeFirst()
	{
		Link<T> first = zero.next;

		if (first != zero)
		{
			first.remove();
			size--;
			return first.value;
		}
		throw new NoSuchElementException();
	}

	@Override
	public T peek()
	{
		if (size != 0)
		{
			return zero.prev.value;
		}

		throw new NoSuchElementException();
	}

	@Override
	public Iterator<T> iterator()
	{
		iterator.item = zero;
		return iterator;
	}

	@Override
	public boolean contains(T value)
	{
		Link<T> item = zero.next;

		while (item != zero)
		{
			if (item.value == value)
			{
				return true;
			}

			item = item.next;
		}

		return false;
	}

}

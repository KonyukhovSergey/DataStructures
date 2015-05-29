package ru.serjik.data;

public interface Collection<T> extends Iterable<T>
{
	int size();

	boolean empty();

	boolean contains(T value);
}
